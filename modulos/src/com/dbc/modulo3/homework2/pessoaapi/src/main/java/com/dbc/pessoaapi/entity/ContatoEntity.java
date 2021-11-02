package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContatoEntity {
    private Integer idContato;

    private Integer idPessoa;

    @NotNull
    private TipoContato tipoContato;

    @NotNull
    @NotEmpty
    @Size(max = 13, message = "deve ter no máximo 13 caracteres")
    private String numero;

    @NotNull
    @NotEmpty
    private String descricao;

}
