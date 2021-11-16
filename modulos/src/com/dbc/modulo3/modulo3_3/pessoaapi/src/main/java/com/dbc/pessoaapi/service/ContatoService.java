package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    private ContatoEntity findById(Integer id) throws RegraDeNegocioException {
        ContatoEntity entity = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("contato não encontrado"));
        return entity;
    }


    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        ContatoEntity contatoCriado = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        contatoRepository.save(contatoCriado);
        return objectMapper.convertValue(contatoCriado, ContatoDTO.class);
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

//    public List<ContatoDTO> getByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
//        return contatoRepository.findAll().stream()
//                .filter(contatoEntity -> contatoEntity.getIdPessoa().equals(idPessoa))
//                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
//                .collect(Collectors.toList());
//    }

    public ContatoDTO getById(Integer id) throws RegraDeNegocioException {
        ContatoEntity entity = findById(id);
        ContatoDTO dto = objectMapper.convertValue(entity, ContatoDTO.class);
        return dto;
    }

    public ContatoDTO update(Integer idContato, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException{
        findById(idContato);
        ContatoEntity entity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        entity.setIdContato(idContato);
        ContatoEntity update = contatoRepository.save(entity);
        return objectMapper.convertValue(update, ContatoDTO.class);

    }


    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contato = findById(id);
        contatoRepository.delete(contato);
    }



}
