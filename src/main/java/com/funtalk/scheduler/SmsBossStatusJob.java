package com.funtalk.scheduler;


import com.funtalk.mapper.TbSTaskAMapper;
import com.funtalk.oraclemapper.BfCdmaSmCallTMapper;
import com.funtalk.pojo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
@ConditionalOnProperty(prefix = "spring.scheduling", name = "enabled", havingValue = "true")
public class SmsBossStatusJob {

    Logger logger =Logger.getLogger(SmsBossStatusJob.class);

    @Autowired private  BfCdmaSmCallTMapper bfCdmaSmCallTMapper;
    @Autowired private  TbSTaskAMapper  tbSTaskAMapper;


    /**
     * 每隔30s查询一次
     * 查询1天内模组发送成功的订单在boss系统中的记录  查到,更新为4
     * developed by simple.
     */
//    @Scheduled(fixedDelay=30000)
    public void smsBossStatusCheckByDay(){

        this.smsBossStatusCheck("0",-2);  // 过去两个小时内

    }



    public  void smsBossStatusCheck(String timeFlag,int adjustNum){

        Calendar calendar;
        List<TbSTaskA>  tbSTaskAList =new ArrayList<TbSTaskA>();

        Map taskMap =new HashMap();

        TbSTaskAExample  tbSTaskAExample;
        TbSTaskAExample.Criteria  criteria1;

        BfCdmaSmCallT bfCdmaSmCallT;

        try {

            tbSTaskAExample =new TbSTaskAExample();
            criteria1 =tbSTaskAExample.createCriteria();
            //模组上报状态  2 成功 3 失败  -5 不明原因失败
            criteria1.andStateIn(new ArrayList<String>(Arrays.asList("2","3","-5")));

            calendar = Calendar.getInstance();
            if ("0".equals(timeFlag))
                calendar.add(Calendar.HOUR_OF_DAY,adjustNum);
            else if ("1".equals(timeFlag))
               calendar.add(Calendar.DAY_OF_MONTH, adjustNum);
            else if ("2".equals(timeFlag))
                calendar.add(Calendar.MONTH, adjustNum);
            else return;

            // 确定需要查询详单的任务   以模组上报时间确定范围
            criteria1.andSendEndTimeGreaterThan(calendar.getTime());

            calendar.setTime(new Date());
            calendar.add(Calendar.MINUTE, -12); // 12分钟之前的记录
            criteria1.andSendEndTimeLessThan(calendar.getTime());

            tbSTaskAList=tbSTaskAMapper.selectByExample(tbSTaskAExample);

            if (tbSTaskAList.size()==0){
                logger.info("--smsBossStatusCheck没有需要处理的数据，休息60s-----"+Thread.currentThread().getName());
                Thread.sleep(60000);
            }

            for (TbSTaskA tbSTaskA :tbSTaskAList){

                if (tbSTaskA.getPhoneA() !=null && tbSTaskA.getPhoneA().length()>0
                        && tbSTaskA.getPhoneB() !=null && tbSTaskA.getPhoneB().length()>0) {

                    taskMap.put("taskId",tbSTaskA.getTaskId());

                    bfCdmaSmCallT = new BfCdmaSmCallT();

                    calendar.setTime(tbSTaskA.getSendEndTime());  //设置查询时间为发送时间
                    calendar.add(Calendar.DAY_OF_MONTH, -1);//发送时间减1天
                    bfCdmaSmCallT.setBeginDate(calendar.getTime());

                    calendar.add(Calendar.DAY_OF_MONTH, 3);
                    bfCdmaSmCallT.setEndDate(calendar.getTime());

                    bfCdmaSmCallT.setServiceId(tbSTaskA.getPhoneA());
                    bfCdmaSmCallT.setCallPhone(tbSTaskA.getPhoneB());

                    List<BfCdmaSmCallT> bfCdmaSmCallTList = bfCdmaSmCallTMapper.selectSmsDispatch(bfCdmaSmCallT);


                    calendar.setTime(new Date());
                    calendar.add(Calendar.DAY_OF_MONTH,-1);

                    SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    logger.info("-----------------------------"+df.format(calendar.getTime()));

                    // 模组发送成功   and 过去xx小时内有话单  更新为4
                    // 模组发送成功   and 过去xx小时内无话单  更新为5
                    // 模组发送失败3  and 过去xx小时内无话单  更新为6
                    // 模组发送失败-5 and 过去xx小时内无话单  更新为7
                    if (bfCdmaSmCallTList.size()>0){

                        taskMap.put("state","4");
                        tbSTaskAMapper.updateStatus(taskMap);  // boss收到详单,更新为发送成功！

                    }else if (tbSTaskA.getCreateTime() != null &&
                            tbSTaskA.getCreateTime().getTime()<calendar.getTime().getTime()){

                      if (tbSTaskA.getState().equals("2"))
                          taskMap.put("state","5");
                      else if (tbSTaskA.getState().equals("3"))
                          taskMap.put("state","6");
                      else if (tbSTaskA.getState().equals("-5"))
                          taskMap.put("state","7");

                        tbSTaskAMapper.updateStatus(taskMap);

                    }

                }
            }


        }catch (Exception e){
            logger.info("-----------查询boss失败报错:"+e.getMessage());
        }

    }



}
