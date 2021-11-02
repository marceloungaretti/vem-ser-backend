package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {
    private Integer idEndereco;
    @NotNull
    @Min(value = 1)
    private Integer idPessoa;
    @NotNull
    private TipoEndereco tipo;
    @NotEmpty
    @Size(max = 250, message = "Você excedeu o  limite de 250 caracteres.")
    private String logradouro;
    @NotNull
    @Min(value = 1, message = "Número inválido")
    private Integer numero;
    private String complemento;
    @NotEmpty
    @NotNull
    @Size(max = 8, message = "cep incorreto(mais de 8 caracteres)")
    private String cep;
    @NotEmpty
    @NotNull
    @Size(max = 250, message = "Você excedeu o  limite de 250 caracteres.")
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;

}
