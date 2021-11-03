package com.dbc.pessoaapi.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoEntity {
    @ApiModelProperty(value = "ID do contato")
    private Integer idContato;

    @ApiModelProperty(value = "ID da pessoa")
    private Integer idPessoa;

    @NotNull
    @ApiModelProperty(value = "Tipo do Contato")
    private TipoContato tipoContato;

    @NotNull
    @NotEmpty
    @Size(max = 13, message = "deve ter no máximo 13 caracteres")
    @ApiModelProperty(value = "Número")
    private String numero;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "Descrição")
    private String descricao;

}
