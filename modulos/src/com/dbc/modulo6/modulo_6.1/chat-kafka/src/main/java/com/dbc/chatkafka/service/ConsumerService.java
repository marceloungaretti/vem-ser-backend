package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.ProdutorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic.geral}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactoryLatest",
            clientIdPrefix = "geral"
    )
    public void consumeDto(@Payload String mensagem) throws JsonProcessingException {
        ProdutorDTO produtorDTO = objectMapper.readValue(mensagem, ProdutorDTO.class);
        log.info("{} [{}] (geral): {}",
                produtorDTO.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                produtorDTO.getUsuario(),
                produtorDTO.getMensagem());
    }

    @KafkaListener(
            topics = "${kafka.topic.marcelo}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactoryLatest",
            clientIdPrefix = "marcelo"
    )
    public void consumePrivateDto(@Payload String mensagem) throws JsonProcessingException {
        ProdutorDTO produtorDTO = objectMapper.readValue(mensagem, ProdutorDTO.class);
        log.info("{} [{}] (marcelo-privado): {}",
                produtorDTO.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                produtorDTO.getUsuario(),
                produtorDTO.getMensagem());
    }
}
