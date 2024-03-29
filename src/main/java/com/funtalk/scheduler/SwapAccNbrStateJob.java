package com.funtalk.scheduler;

import com.funtalk.SpringbootApplication;
import com.funtalk.mapper.TbOErrorMapper;
import com.funtalk.mapper.TbSCardinfoMapper;
import com.funtalk.oraclemapper.ServMapper;
import com.funtalk.pojo.SimpleServ;
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

@RunWith(SpringRunner.class) //1.4版本之前用的是@RunWith(SpringJUnit4ClassRunner.class)  SpringRunner的别名: SpringJUnit4ClassRunner
@SpringBootTest(classes = SpringbootApplication.class) //1.4版本之前用的是//@SpringApplicationConfiguration(classes = Application.class)

@Component
@ConditionalOnProperty(prefix = "spring.scheduling", name = "enabled", havingValue = "false")
public class SwapAccNbrStateJob {

    Logger logger =Logger.getLogger(SwapAccNbrStateJob.class);

    @Autowired ServMapper servMapper;
    @Autowired TbSCardinfoMapper  tbSCardinfoMapper;
    @Autowired TbOErrorMapper tbOErrorMapper;


//    @Scheduled(cron = "0 30 13  * * ?")
    public void swapState(){

        int offset=0;
        int limit=500;

        Long begin =new Date().getTime();

        logger.info("---swapState--->--update state using time--->");


        while (true){

            List<SimpleServ>  accnbrIotList = tbSCardinfoMapper.selectBylimit(offset,limit);

            if (accnbrIotList.size()<=0){

                // 初始化日发送量
                tbSCardinfoMapper.initializeDayuse();

                logger.info("---size--->"+offset+"--update state using time--->"+(new Date().getTime()-begin)/1000);

                break;

            }

            List<SimpleServ>  accnbrBossList= servMapper.selectStateByAccnbrForBatch(accnbrIotList);

            Map<String,String>  accnbrBossMap = accnbrBossList.stream().collect(
                              Collectors.collectingAndThen(
                                             Collectors.toCollection(
                                                   () -> new TreeSet<>(
                                                            Comparator.comparing(SimpleServ::getAccNbr))),
                                             ArrayList::new))
                                            .stream().collect(Collectors.toMap(x->x.getAccNbr(), x->x.getNewState()));


            List<SimpleServ> updateList= accnbrIotList.stream()
                                         .map(x ->{  if (accnbrBossMap.get(x.getAccNbr()) !=null )
                                                        x.setNewState(accnbrBossMap.get(x.getAccNbr()));
                                                      else x.setNewState("");
                                               return x;
                                             })
                                        .filter(x -> !"".equals(x.getNewState())
                                                     && !x.getOldState().equals(x.getNewState())
                                                     && !"2HXX".equals(x.getOldState()))
                                        .collect(Collectors.toList());


            if (updateList.size()>0)
                tbSCardinfoMapper.updateByAccnbrForBatch(updateList);


            offset+=500;

        }

    }


}
