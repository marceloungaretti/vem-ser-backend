package com.dbc.emailconsumidor.service;

import com.dbc.emailconsumidor.dto.EmailDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    @KafkaListener(
            topics = "${kafka.topic.send}",
            groupId = "${kafka.topic.group-id}",
            containerFactory = "listenerContainerFactoryLatest"
    )
    public void consumeEmailDto(@Payload String message) throws IOException, MessagingException, TemplateException {
        EmailDto emailDto = objectMapper.readValue(message, EmailDto.class);
        emailService.sendEmail(emailDto);
        log.info("Email enviado ao destinatário: {}",
                emailDto.getDestinatario());
    }
}
