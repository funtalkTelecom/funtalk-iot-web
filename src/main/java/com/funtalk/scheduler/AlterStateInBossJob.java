package com.funtalk.scheduler;

import com.funtalk.SpringbootApplication;
import com.funtalk.mapper.TbOBatchrechargeMapper;
import com.funtalk.mapper.TbOBatchsubMapper;
import com.funtalk.oraclemapper.ServMapper;
import com.funtalk.pojo.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;


//@RunWith(SpringRunner.class) //1.4版本之前用的是@RunWith(SpringJUnit4ClassRunner.class)  SpringRunner的别名: SpringJUnit4ClassRunner
//@SpringBootTest(classes = SpringbootApplication.class) //1.4版本之前用的是//@SpringApplicationConfiguration(classes = Application.class)
@Component
@ConditionalOnProperty(prefix = "spring.scheduling", name = "enabled", havingValue = "true")
public class AlterStateInBossJob {

    Logger logger = Logger.getLogger(AlterStateInBossJob.class);

    @Autowired
    TbOBatchrechargeMapper tbOBatchrechargeMapper;
    @Autowired
    TbOBatchsubMapper tbOBatchsubMapper;
    @Autowired
    ServMapper  servMapper;

    static Map<Integer,Integer> failBatchIds = new HashMap<>();

    /**
     * 每隔10s查询一次
     * developed by simple.
     * fixedRate 是每隔xx时间执行一次  如果线程执行时间过长,即使到了fixedRate也不会立即执行，
     * 这种情况需要使用 @Async 以便每到fixedRate固定时间便启动一个线程去执行
     *
     */
  //  @Test
//    @Scheduled(fixedDelay = 10000)
    public void alterStateInBoss(){



        List<TbOBatchrecharge> tbOBatchrechargeList;
        List<TbOBatchsub>  tbOBatchsubList;

        Map<String,Object> paramMap = new HashMap();

        TbOBatchrechargeExample tbOBatchrechargeExample = new TbOBatchrechargeExample();
        TbOBatchrechargeExample.Criteria  criteria1= tbOBatchrechargeExample.createCriteria();
        criteria1.andCheckStateEqualTo("1");
        criteria1.andPayStateEqualTo("1");
        criteria1.andRechargeStateIn(Arrays.asList("1","-2")); // 全部成功 或 部分成功
        criteria1.andAlterBossEqualTo("0");

        tbOBatchrechargeList= tbOBatchrechargeMapper.selectByExample(tbOBatchrechargeExample);

        logger.info("======>begin to revoke limit for activation and to force to activate......");

        try {
            if (tbOBatchrechargeList.size()==0){
                logger.info("--alterStateInBoss没有需要处理的数据，休息30s-----"+Thread.currentThread().getName());
                Thread.sleep(30000);
            }
        }catch (Exception e){

            e.printStackTrace();
        }

        for (TbOBatchrecharge tbOBatchrecharge :tbOBatchrechargeList){


            if( failBatchIds.containsKey(tbOBatchrecharge.getBatchId())
                    && failBatchIds.get(tbOBatchrecharge.getBatchId())>10){

                paramMap.put("alterBoss","-1");
                paramMap.put("batchId",tbOBatchrecharge.getBatchId());
                tbOBatchrechargeMapper.updateState(paramMap);

                failBatchIds.remove(tbOBatchrecharge.getBatchId());
                continue;

            }

            // 取sub表中充值成功的记录 state=1
            TbOBatchsubExample tbOBatchsubExample = new TbOBatchsubExample();
            TbOBatchsubExample.Criteria criteria2=tbOBatchsubExample.createCriteria();
            criteria2.andBatchIdEqualTo(tbOBatchrecharge.getBatchId());
            criteria2.andRechargeStateEqualTo("1");
            criteria2.andActivateStateEqualTo("0");  //此字段 代表 取消限制和强制激活的操作标志

            tbOBatchsubList= tbOBatchsubMapper.selectByExample(tbOBatchsubExample);

            int listSize=tbOBatchsubList.size();

            String batchFlag="1";

            int toIndex=100;

            for (int i=0; i<listSize;i+=100) {

                List<String>  activateFailList = new ArrayList<>();


                if(i+100>listSize){
                    toIndex=listSize-i;
                }

            List<TbOBatchsub> newList =  tbOBatchsubList.subList(i,i+toIndex).stream()
                                                        .filter(o -> StringUtils.isNotEmpty(o.getAccNbr()))
                                                        .collect(Collectors.toList());

                logger.info("-------->"+newList.toString());
            try {

                servMapper.cancelLimit(newList);

                List<String>  limitServList =servMapper.getLimitServ(newList);

                for (String accNbr :limitServList){

                    try {
                            paramMap.put("accNbr",accNbr);
                            paramMap.put("operation",2);
                            paramMap.put("operator","Ms.cong");
                            servMapper.forcedToActivate(paramMap);

                    }catch (Exception e){

                        e.printStackTrace();
                        batchFlag="0";
                        activateFailList.add(accNbr);

                    }

                }

                List<TbOBatchsub> updateList =  newList.stream()
                                                        .filter(o -> {
                                                            if (activateFailList.size()==0) return  o!=null;
                                                            else return !activateFailList.contains(o.getAccNbr()); })
                                                        .map( o -> {
                                                            o.setLimitState("1");
                                                            o.setActivateState("1");
                                                            return o; })
                                                        .collect(Collectors.toList());

                tbOBatchsubMapper.updateBatchResult(updateList);

             }catch (Exception e){

                batchFlag="0";
                e.printStackTrace();

            }

            }

            if ("1".equals(batchFlag)){

               if (failBatchIds.containsKey(tbOBatchrecharge.getBatchId()))
                   failBatchIds.remove(tbOBatchrecharge.getBatchId());

                paramMap.put("alterBoss","1");
                paramMap.put("batchId",tbOBatchrecharge.getBatchId());
                tbOBatchrechargeMapper.updateState(paramMap);

            }else{

                Integer  failNum;
                failNum = failBatchIds.containsKey(tbOBatchrecharge.getBatchId()) ?
                          failBatchIds.get(tbOBatchrecharge.getBatchId())+1 : 1;
                failBatchIds.put(tbOBatchrecharge.getBatchId(),failNum);

            }


        }
    }
}
