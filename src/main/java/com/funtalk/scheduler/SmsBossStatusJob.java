package com.funtalk.scheduler;


import com.funtalk.mapper.TbSSubtaskResultMapper;
import com.funtalk.oraclemapper.BfCdmaSmCallTMapper;
import com.funtalk.pojo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@ConditionalOnProperty(prefix = "spring.scheduling", name = "enabled", havingValue = "true")
public class SmsBossStatusJob {

    Logger logger =Logger.getLogger(SmsBossStatusJob.class);

    @Autowired private  BfCdmaSmCallTMapper bfCdmaSmCallTMapper;
    @Autowired private  TbSSubtaskResultMapper tbSSubtaskResultMapper;


    /**
     * 每隔30s查询一次
     * 查询1天内模组发送成功的订单在boss系统中的记录  查到,更新为4
     * developed by simple.
     */
    @Scheduled(fixedDelay=30000)
    public void smsBossStatusCheckByDay(){

        this.smsBossStatusCheck("0",-2);  // 过去两个小时内

    }



    public  void smsBossStatusCheck(String timeFlag,int adjustNum){

        Calendar calendar;
        List<TbSSubtaskResult>  tbSSubtaskResultList =new ArrayList<TbSSubtaskResult>();

        TbSSubtaskResultExample  tbSSubtaskResultExample;
        TbSSubtaskResultExample.Criteria  criteria1;

        BfCdmaSmCallT bfCdmaSmCallT;

        try {

            tbSSubtaskResultExample =new TbSSubtaskResultExample();
            criteria1 =tbSSubtaskResultExample.createCriteria();
            criteria1.andIfSendIn(new ArrayList<String>(Arrays.asList("2","3")));
            //criteria1.andIfSendEqualTo("2");

            calendar = Calendar.getInstance();
            if ("0".equals(timeFlag))
                calendar.add(Calendar.HOUR_OF_DAY,adjustNum);
            else if ("1".equals(timeFlag))
               calendar.add(Calendar.DAY_OF_MONTH, adjustNum);
            else if ("2".equals(timeFlag))
                calendar.add(Calendar.MONTH, adjustNum);
            else return;

            criteria1.andSendDateGreaterThan(calendar.getTime());

            calendar.setTime(new Date());
            calendar.add(Calendar.MINUTE, -12); // 12分钟之前的记录
            criteria1.andSendDateLessThan(calendar.getTime());

            tbSSubtaskResultList=tbSSubtaskResultMapper.selectByExample(tbSSubtaskResultExample);

            if (tbSSubtaskResultList.size()==0){
                logger.info("--smsBossStatusCheck没有需要处理的数据，休息60s-----"+Thread.currentThread().getName());
                Thread.sleep(60000);
            }

            for (TbSSubtaskResult sSubtaskResult :tbSSubtaskResultList){

                if (sSubtaskResult.getPhoneA() !=null && sSubtaskResult.getPhoneA().length()>0
                        && sSubtaskResult.getPhoneB() !=null && sSubtaskResult.getPhoneB().length()>0) {

                    bfCdmaSmCallT = new BfCdmaSmCallT();

                    calendar.setTime(sSubtaskResult.getSendDate());  //设置查询时间为发送时间
                    calendar.add(Calendar.DAY_OF_MONTH, -1);//发送时间减1天
                    bfCdmaSmCallT.setBeginDate(calendar.getTime());

                    calendar.add(Calendar.DAY_OF_MONTH, 3);
                    bfCdmaSmCallT.setEndDate(calendar.getTime());

                    bfCdmaSmCallT.setServiceId(sSubtaskResult.getPhoneA());
                    bfCdmaSmCallT.setCallPhone(sSubtaskResult.getPhoneB());

                    List<BfCdmaSmCallT> bfCdmaSmCallTList = bfCdmaSmCallTMapper.selectSmsDispatch(bfCdmaSmCallT);


                    calendar.setTime(new Date());
                    calendar.add(Calendar.DAY_OF_MONTH,-1);

                    SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    logger.info("--------------"+df.format(calendar.getTime()));

                    // 模组发送成功 and 有话单  更新为4
                    // 模组发送成功 and 过去24小时内无话单  更新为5
                    // 模组发送失败 and 过去24小时内无话单  更新为6

                    if (bfCdmaSmCallTList.size()>0){

                        tbSSubtaskResultMapper.updateBossStatus(sSubtaskResult.getNid(),"4");  // boss收到详单,更新为发送成功！

                    }else if (sSubtaskResult.getCreateTime() != null &&
                            sSubtaskResult.getCreateTime().getTime()<calendar.getTime().getTime()){

                      if (sSubtaskResult.getIfSend().equals("2"))
                      tbSSubtaskResultMapper.updateBossStatus(sSubtaskResult.getNid(),"5");
                      else if (sSubtaskResult.getIfSend().equals("3"))
                          tbSSubtaskResultMapper.updateBossStatus(sSubtaskResult.getNid(),"6");

                    }

                }
            }


        }catch (Exception e){
            logger.info("-----------查询boss失败报错:"+e.getMessage());
        }

    }



}
