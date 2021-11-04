package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DadosPessoaisService{
    private final ObjectMapper objectMapper;
    private final DadosPessoaisClient dadosPessoaisClient;


    public List<DadosPessoaisDTO> listar() {
        return dadosPessoaisClient.listar();
    }


    public DadosPessoaisDTO getPorCpf(String cpf) {
        DadosPessoaisDTO dadosPessoaisDTO = dadosPessoaisClient.getPorCpf(cpf);
        return dadosPessoaisDTO;
    }

    public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.createDadosPessoais(dadosPessoaisDTO);
    }
}
