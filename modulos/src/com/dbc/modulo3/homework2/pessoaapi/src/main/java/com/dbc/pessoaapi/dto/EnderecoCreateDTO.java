package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoEndereco;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {

    @ApiModelProperty(value = "ID do endereço")
    private Integer idEndereco;
    @NotNull
    @ApiModelProperty(value = "ID da pessoa")
    private Integer idPessoa;
    @NotNull
    @ApiModelProperty(value = "Tipo de Endereço")
    private TipoEndereco tipo;
    @NotEmpty
    @Size(max = 250, message = "Você excedeu o  limite de 250 caracteres.")
    @ApiModelProperty(value = "Logradouro")
    private String logradouro;
    @NotNull
    @Min(value = 1, message = "Número inválido")
    @ApiModelProperty(value = "Número")
    private Integer numero;
    @ApiModelProperty(value = "Complemento")
    private String complemento;
    @NotEmpty
    @NotNull
    @Size(max = 8, message = "cep incorreto(mais de 8 caracteres)")
    @ApiModelProperty(value = "CEP")
    private String cep;
    @NotEmpty
    @NotNull
    @Size(max = 250, message = "Você excedeu o  limite de 250 caracteres.")
    @ApiModelProperty(value = "Cidade")
    private String cidade;
    @NotNull
    @ApiModelProperty(value = "Estado")
    private String estado;
    @NotNull
    @ApiModelProperty(value = "País")
    private String pais;
}
