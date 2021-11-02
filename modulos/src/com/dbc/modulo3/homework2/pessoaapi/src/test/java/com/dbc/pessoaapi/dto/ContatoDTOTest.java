package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class ContatoDTOTest {
    @Test
    public void test() {
        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setTipoContato(1);//COMERCIAL, RESIDENCIAL

        ContatoEntity contatoEntity = new ObjectMapper().convertValue(contatoDTO, ContatoEntity.class);
        System.out.println(contatoEntity);
    }
}