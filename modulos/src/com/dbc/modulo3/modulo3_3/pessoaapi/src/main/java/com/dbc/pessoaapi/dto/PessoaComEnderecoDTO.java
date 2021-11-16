package com.dbc.pessoaapi.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaComEnderecoDTO extends PessoaDTO{

    private Set<EnderecoDTO> enderecos;

}
