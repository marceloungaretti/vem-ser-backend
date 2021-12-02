package com.dbc.pessoaapi.dto;

import lombok.Data;

@Data
public class ContatoDTO extends ContatoCreateDTO{
    private Integer idContato;
    private Integer idPessoa;
}