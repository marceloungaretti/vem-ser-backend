package com.dbc.scheduler.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class MeuNovoScheduler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 2000)
//    public void meuPrimeiroScheduler(){
//        log.info("{}", dateFormat.format(new Date()));
//    }
}
