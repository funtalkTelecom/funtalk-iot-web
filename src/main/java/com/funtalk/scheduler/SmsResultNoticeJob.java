package com.funtalk.scheduler;

import com.funtalk.mapper.TbSTaskAMapper;
import com.funtalk.pojo.SmsNotice;
import com.funtalk.pojo.TbSTaskA;
import com.funtalk.utils.DateUtil;
import com.funtalk.utils.HttpClient4;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.*;
import org.safehaus.uuid.UUID;
import org.safehaus.uuid.UUIDGenerator;

@Component
@ConditionalOnProperty(prefix = "spring.scheduling", name = "enabled", havingValue = "true")
public class SmsResultNoticeJob {

    Logger logger = Logger.getLogger(SmsResultNoticeJob.class);

    @Autowired   TbSTaskAMapper  tbSTaskAMapper;


    /**
     * 每隔10s查询一次
     * developed by simple.
     */

    @Scheduled(fixedDelay=10000)
    //fixedRate 任务两次执行时间间隔是任务的开始点.  fixedDelay的间隔是前次任务的结束与下次任务的开始. 毫秒
    public void smsResultNoticeJob() throws Exception {

        String smsNoticeSeq="",smsNoticeBack="",state="2",stateMsg="";

        UUIDGenerator generator=UUIDGenerator.getInstance();
        List<TbSTaskA>  subTasks =new ArrayList<TbSTaskA>();

        Map<String,Object> paramMap= new HashMap<>();
        paramMap.put("json","");

        logger.info("The time is:"+ DateUtil.formatFullDate(new Date())+"," + "IOT is performing notice for sms result.");

            subTasks=tbSTaskAMapper.getNeedNoticeSms();


            if (subTasks.size()==0) {
                logger.info("--smsResultNoticeJob没有需要处理的数据,休息30s--"+Thread.currentThread().getName());
                Thread.sleep(30000);
            }

            for (TbSTaskA subTask :subTasks){

                UUID  uuid   = generator.generateTimeBasedUUID();         //基于时间版本
                smsNoticeSeq = uuid.toString().replaceAll("-", ""); //36位的流水

                SmsNotice smsNotice =new SmsNotice();

                smsNotice.setUid(smsNoticeSeq);
                smsNotice.setMobile(subTask.getPhoneB());
                smsNotice.setReqseq(subTask.getReqSeq());

                if ("4".equals(subTask.getState())) {
                    state = "1";
                    stateMsg = "发送成功!";
                }else
                    stateMsg="发送失败，用户未收到!";


                smsNotice.setState(state);
                smsNotice.setStatemsg(stateMsg);
                smsNotice.setBacktime(DateUtil.formatFullDate(new Date()));

                JSONObject json=new JSONObject();
                paramMap.put("json",json.fromObject(smsNotice).toString());

                try {

                    smsNoticeBack=HttpClient4.doPost(subTask.getNoticeUrl(),paramMap);

                    subTask.setNoticeState("1");
                    subTask.setNoticeSeq(smsNoticeSeq);
                    subTask.setNoticeTime(new Date());
                    subTask.setNoticeBack(smsNoticeBack.substring(0,smsNoticeBack.length()>180? 180 : smsNoticeBack.length()));
                    tbSTaskAMapper.updateNoticeStatus(subTask);

                } catch (Exception e) {

                    logger.error("An error occurred when sending notice message." + e.toString());

                    subTask.setNoticeState("2");
                    subTask.setNoticeSeq(smsNoticeSeq);
                    subTask.setNoticeTime(new Date());
                    subTask.setNoticeBack(smsNoticeBack.substring(0,smsNoticeBack.length()>180? 180 : smsNoticeBack.length()));
                    tbSTaskAMapper.updateNoticeStatus(subTask);

                }
            }
    }

}
