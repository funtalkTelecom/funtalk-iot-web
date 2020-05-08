package com.funtalk.scheduler;


import com.funtalk.mapper.TbOBatchrechargeMapper;
import com.funtalk.mapper.TbOBatchsubMapper;
import com.funtalk.utils.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.*;

@Component
@EnableScheduling
public class DealerChargeJob {

    Logger  logger = Logger.getLogger(DealerChargeJob.class);


    //@Scheduled(cron = "0/5 * 10 * * ?")
    // @Scheduled(fixedDelay = 2000)
    //fixedRate 任务两次执行时间间隔是任务的开始点.  fixedDelay的间隔是前次任务的结束与下次任务的开始. 毫秒
    public void chargeLogJob() {

        logger.info("The time is:"+DateUtil.formatFullDate(new Date())+"," +
                  "IOT is performing recharge for dealer's user by calling Boss interface.");

        try {



            /*

            TbLChargeExample  tbLChargeExample = new TbLChargeExample();
            TbLChargeExample.Criteria criteria1 = tbLChargeExample.createCriteria();

            criteria1.andPayStatusEqualTo(2);


            tbLChargeMapper.selectByExample();

                  TbSSmstemplateExample example = new TbSSmstemplateExample();
        TbSSmstemplateExample.Criteria criteria = example.createCriteria();
        criteria.andCustIdEqualTo(custId);
        return tbSSmstemplateMapper.selectByExample(example);

            URL url = Thread.currentThread().getContextClassLoader().getResource("");
            logger.info("-----thread-url----------->" + url.getPath()); */










        /*  Map map = bossAreaService.find170ByBossType(BossArea.Type.CUCC, true);

            if (!map.isEmpty()) {
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    String pre = (String) it.next();
                    ChargeLogUtil.CUCCMap.put(pre, pre);
                }
            }
            map.clear();*/


        } catch (Exception e) {
            logger.error("An error occurred when calling Boss interface." + e.toString());
        }

    }
}
