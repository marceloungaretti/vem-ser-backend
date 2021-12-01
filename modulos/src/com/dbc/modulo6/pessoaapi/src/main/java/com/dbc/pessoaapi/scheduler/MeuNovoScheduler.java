package com.dbc.pessoaapi.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@Slf4j
public class MeuNovoScheduler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 2000)
//    public void meuPrimeiroScheduler(){
//        log.info("{}", dateFormat.format(new Date()));
//    }
}
