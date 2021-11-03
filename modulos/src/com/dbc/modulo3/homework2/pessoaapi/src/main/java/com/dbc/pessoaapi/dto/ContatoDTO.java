package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoDTO {
    @ApiModelProperty(value = "ID do contato")
    private Integer idContato;
    @ApiModelProperty(value = "ID da pessoa")
    private Integer idPessoa;
    @Size(max = 1)
    @NotNull
    @ApiModelProperty(value = "Tipo de Contato")
    private Integer tipoContato;
    @ApiModelProperty(value = "Número do contato")
    private String numero;
    @ApiModelProperty(value = "Descrição do contato")
    private String descricao;
}
