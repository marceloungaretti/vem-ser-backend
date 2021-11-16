package com.dbc.pessoaapi.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO extends PessoaCreateDTO{
    @ApiModelProperty(value = "ID da Pessoa")
    private Integer idPessoa;
}
