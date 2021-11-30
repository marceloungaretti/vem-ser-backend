package com.dbc.chatkafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
//    private final ObjectMapper objectMapper;
//
//    @KafkaListener(
//            topics = "${kafka.topic.geral}",
//            containerFactory = "listenerContainerFactoryLatest"
//    )
//    public void consumeDto(@Payload String mensagem,
//                           @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
//                           @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
//        log.info("MENSAGEM LIDA: '{}', CHAVE: '{}', OFFSET: '{}'", mensagem, key, offset);
//    }
}
