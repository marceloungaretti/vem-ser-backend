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
public class SchedulerCron {
    private final PessoaService pessoaService;

    @Scheduled(cron = "0 7 12 * * *")
    public void pessoasSemEdereco() throws IOException, MessagingException, TemplateException {
        pessoaService.sendEmailPessoaSemEndereco();
    }

    @Scheduled(cron = "0 11 12 * * *")
    public void aniversariante() throws IOException {
        pessoaService.sendAniversariante();
    }

    @Scheduled(cron = "0 11 12 * * *")
    public void promo() throws IOException, MessagingException, TemplateException {
        pessoaService.sendEmailXororo();
    }
}
