package com.dbc.pessoaapi.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaComContatoDTO extends PessoaDTO{

    private Integer idPessoa;
    private Set<ContatoDTO> contatos;
}
