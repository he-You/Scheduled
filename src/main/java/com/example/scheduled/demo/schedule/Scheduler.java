package com.example.scheduled.demo.schedule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by heyou on 2019/5/10 0010.
 */
@Component
public class Scheduler {
    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);
    private  static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void reportCurrent(){
        logger.info("现在时间：{}",dataFormat.format(new Date()));
        try {
            Thread.sleep(5000);
            logger.info("正在sleep...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Scheduled(cron = "0 50 14 ? * *")
    public void taskOne(){
        logger.info("hello world!");
    }

}
