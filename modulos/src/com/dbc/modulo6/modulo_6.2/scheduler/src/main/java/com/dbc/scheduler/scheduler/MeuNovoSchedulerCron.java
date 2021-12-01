package com.dbc.scheduler.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class MeuNovoSchedulerCron {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "*/5 * * * * *", zone = "GMT-3")
    public void meuPrimeiroScheduler() throws InterruptedException {
        Thread.sleep(1000);
        log.info("{}", dateFormat.format(new Date()));
    }
}
