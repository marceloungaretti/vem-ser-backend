package com.dbc.pessoaapi.scheduler;

import com.dbc.pessoaapi.service.EmailService;
import com.dbc.pessoaapi.service.PessoaService;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class MeuNovoSchedulerCron {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final PessoaService pessoaService;

    @Scheduled(cron = "0 0 8,20 * * *", zone = "GMT-3")
    public void meuPrimeiroScheduler() throws InterruptedException, MessagingException, TemplateException, IOException {
        pessoaService.sendEmailPessoaSemEndereco();
    }

    @Scheduled(cron = "0 0 0 23 12 ?", zone = "GMT-3")
    public void schedulerNatal() throws MessagingException, TemplateException, IOException {
        pessoaService.sendEmailXororo();
    }
}
