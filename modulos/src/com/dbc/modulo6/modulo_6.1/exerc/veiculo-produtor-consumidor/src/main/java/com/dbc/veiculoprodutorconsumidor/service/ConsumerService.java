package com.dbc.veiculoprodutorconsumidor.service;

import com.dbc.veiculoprodutorconsumidor.dto.MediaTodosDTO;
import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.veiculoprodutorconsumidor.entity.VeiculoEntity;
import com.dbc.veiculoprodutorconsumidor.repository.VeiculoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final ObjectMapper objectMapper;
    private final VeiculoRepository veiculoRepository;

    @KafkaListener(
            topics = "${kafka.topic.dto}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactoryLatest"
    )
    public void consumeDto(@Payload String mensagem,
                           @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                           @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        VeiculoDTO veiculoDTO = objectMapper.readValue(mensagem, VeiculoDTO.class);
        VeiculoEntity veiculoEntity = objectMapper.convertValue(veiculoDTO, VeiculoEntity.class);
        veiculoRepository.save(veiculoEntity);
        log.info("MENSAGEM LIDA: '{}', CHAVE: '{}', OFFSET: '{}'", veiculoDTO, key, offset);
    }

    public List<VeiculoDTO> list() {
        return veiculoRepository.findAll()
                .stream()
                .map(veiculo -> objectMapper.convertValue(veiculo, VeiculoDTO.class))
                .collect(Collectors.toList());
    }


    public MediaTodosDTO mediaVelocidadeTodos() {
        MediaTodosDTO mediaTodosDTO = new MediaTodosDTO();
        mediaTodosDTO.setMediaTotal(veiculoRepository.mediaVelocidadeTodos());
        return mediaTodosDTO;
    }
}