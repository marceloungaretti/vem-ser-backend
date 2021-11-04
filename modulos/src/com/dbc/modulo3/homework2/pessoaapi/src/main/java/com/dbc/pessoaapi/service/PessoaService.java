package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final DadosPessoaisClient dadosPessoaisClient;

    @Autowired
    private EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws MessagingException, TemplateException, IOException {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity pessoaCriada = pessoaRepository.create(pessoaEntity);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
//        emailService.envioCreateComTemplate(pessoaDTO);
        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaCreateDTO) throws Exception {
        PessoaEntity entity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity update = pessoaRepository.update(id, entity);
        PessoaDTO dto = objectMapper.convertValue(update, PessoaDTO.class);
//        emailService.envioUpdateComTemplate(dto);
        return dto;
    }

    public void delete(Integer idPessoa) throws Exception {
        PessoaEntity pessoaEntity = pessoaRepository.buscarPorId(idPessoa);
        PessoaEntity entity = objectMapper.convertValue(pessoaEntity, PessoaEntity.class);
        PessoaDTO pessoaDTO = objectMapper.convertValue(entity, PessoaDTO.class);

        pessoaRepository.delete(idPessoa);
//        emailService.envioDeleteComTemplate(pessoaDTO);
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.listByName(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO getById(Integer id) throws Exception {
        PessoaEntity entity = pessoaRepository.getById(id);
        DadosPessoaisDTO dadosPessoaisDTO = dadosPessoaisClient.getPorCpf(entity.getCpf());
        PessoaDTO dto = objectMapper.convertValue(entity, PessoaDTO.class);
        dto.setDadosPessoaisDTO(dadosPessoaisDTO);
        return dto;
    }
}
