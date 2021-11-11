package com.dbc.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaComTodosDadosDTO extends PessoaDTO{

    Set<ContatoDTO> contatos;
    Set<EnderecoDTO> enderecos;


}
