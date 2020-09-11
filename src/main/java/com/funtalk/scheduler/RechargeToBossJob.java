package com.funtalk.scheduler;

import com.funtalk.mapper.TbOBatchrechargeMapper;
import com.funtalk.mapper.TbOBatchsubMapper;
import com.funtalk.outerface.neusoft.paymentBank.PaymentBankClient;
import com.funtalk.outerface.neusoft.paymentBank.PaymentBankRequest;
import com.funtalk.outerface.neusoft.paymentBank.PaymentBankResponse;
import com.funtalk.pojo.*;
import com.funtalk.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ConditionalOnProperty(prefix = "spring.scheduling", name = "enabled", havingValue = "true")
public class RechargeToBossJob {

    Logger logger = Logger.getLogger(RechargeToBossJob.class);

    @Autowired
    TbOBatchrechargeMapper tbOBatchrechargeMapper;
    @Autowired
    TbOBatchsubMapper tbOBatchsubMapper;

    /**
     * 每隔10s查询一次
     * developed by simple.
     */
//    @Scheduled(fixedDelay = 10000)
    public void batchRecharge(){


        List<TbOBatchrecharge> tbOBatchrechargeList;
        List<TbOBatchsub>  tbOBatchsubList;

        int  falseNum=0;
        String payStr="";
        Map paramMap = new HashMap();

        TbOBatchrechargeExample  tbOBatchrechargeExample = new TbOBatchrechargeExample();
        TbOBatchrechargeExample.Criteria  criteria1= tbOBatchrechargeExample.createCriteria();
        criteria1.andCheckStateEqualTo("1");
        criteria1.andPayStateEqualTo("1");
        criteria1.andRechargeStateEqualTo("0");

        tbOBatchrechargeList= tbOBatchrechargeMapper.selectByExample(tbOBatchrechargeExample);


        try {
            if (tbOBatchrechargeList.size()==0){
                logger.info("--batchRecharge没有需要处理的数据，休息30s-----"+Thread.currentThread().getName());
                Thread.sleep(30000);
            }
        }catch (Exception e){

            e.printStackTrace();
        }


        for (TbOBatchrecharge tbOBatchrecharge :tbOBatchrechargeList){

            falseNum=0;
            paramMap.put("batchId",tbOBatchrecharge.getBatchId());
            paramMap.put("rechargeState","2");
            tbOBatchrechargeMapper.updateState(paramMap);

            TbOBatchsubExample  tbOBatchsubExample = new TbOBatchsubExample();
            TbOBatchsubExample.Criteria criteria2=tbOBatchsubExample.createCriteria();
            criteria2.andBatchIdEqualTo(tbOBatchrecharge.getBatchId());
            criteria2.andRechargeStateEqualTo("0");

             tbOBatchsubList= tbOBatchsubMapper.selectByExample(tbOBatchsubExample);

             for (TbOBatchsub  tbOBatchsub : tbOBatchsubList){

                 logger.info("开始充值·················");

                 //新boss充值 未完成
            /*   try{

                   payStr="{amount:"+tbOBatchsub.getRechargeAmount().multiply(new BigDecimal(100)).longValue()+",serviceNum:"+tbOBatchsub.getAccNbr()+"}";

                   NbRechargeData nbRechargeData= new NbRechargeData("appKey", payStr,
                                                           "RECHARGE","timeStamp",
                                                           "transactionId");

                 }catch (Exception e){

                 }*/


            //东软boss充值  已完成
        /*   PaymentBankRequest bossRequest = null;

               try {

                     if (!StringUtil.isEmpty(tbOBatchsub.getAccNbr()) &&
                             tbOBatchsub.getRechargeAmount().multiply(new BigDecimal(100)).longValue() >0)
                     {

                         logger.info("正在调用boss充值接口,[phone=" +tbOBatchsub.getAccNbr() + ",amount=" + tbOBatchsub.getRechargeAmount() + "]");

                         bossRequest = new PaymentBankRequest();

                         bossRequest.setServiceId(tbOBatchsub.getAccNbr()); // 手机号
                         bossRequest.setBankId("9811");
                         //设置充值金额
                         bossRequest.setPayFee(tbOBatchsub.getRechargeAmount().multiply(new BigDecimal(100)).longValue()); // 精确到分


                         PaymentBankResponse response = PaymentBankClient.pay(bossRequest);

                         tbOBatchsub.setRechargeTransId(bossRequest.getBankFlowNumber());  // iot-web生成的流水

                         if(response!=null&&response.getResultCode()!=null){

                             logger.info("doPhoneCharge: code = " + response.getResultCode() + ", info=" + response.getResultInfo());

                             tbOBatchsub.setRechargeMark(response.getResultInfo() !=null ? response.getResultInfo() :"充值成功"  );

                             if ("0".equals(response.getResultCode())||"0000".equals(response.getResultCode())||
                                     ("-1".equals(response.getResultCode())&&response.getResultInfo().contains("缴费流水已经存在")))
                             {
                                 tbOBatchsub.setRechargeState("1");
                                 tbOBatchsub.setRechargeMark("充值成功!");

                             } else {

                                 falseNum+=1;
                                 tbOBatchsub.setRechargeState("-1");
                                 tbOBatchsub.setRechargeMark(response.getResultInfo() !=null ?
                                         (response.getResultInfo().length()>100 ?
                                                 "充值失败:"+response.getResultInfo().substring(0,99) : "充值失败:"+ response.getResultInfo()):"充值失败:BOSS系统返回充值失败状态!");

                             }

                         }else{
                                 falseNum+=1;
                                 logger.info("接收boss返回值为空");
                                 tbOBatchsub.setRechargeState("-5");
                                 tbOBatchsub.setRechargeMark("充值失败:连接BOSS系统失败或接收BOSS系统返回值为空,请尝试重新补充!");

                         }

                     }else{
                         falseNum+=1;
                         tbOBatchsub.setRechargeState("-2");
                         tbOBatchsub.setRechargeMark("充值失败:号码为空或充值金额<=0!");
                     }


                     tbOBatchsubMapper.updateByPrimaryKeySelective(tbOBatchsub);


                 } catch (Exception e) {

                     e.printStackTrace();
                     logger.error("充值异常："+e.toString());
                     if(bossRequest!=null){
                         tbOBatchsub.setRechargeTransId(bossRequest.getBankFlowNumber());

                     }
                     falseNum+=1;
                     tbOBatchsub.setRechargeState("-5");
                     tbOBatchsub.setRechargeMark("充值失败:连接BOSS或电信系统失败,请尝试重新补充!");
                     tbOBatchsubMapper.updateByPrimaryKeySelective(tbOBatchsub);

                 }*/
             }

//            paramMap.put("batchId",tbOBatchrecharge.getBatchId());
//             //  1:全部成功 -1 全部失败 -2 部分失败
//            paramMap.put("rechargeState",falseNum == 0 ? "1" :( falseNum == tbOBatchsubList.size() ?"-1":"-2") );
//            tbOBatchrechargeMapper.updateState(paramMap);

        }
    }

}
