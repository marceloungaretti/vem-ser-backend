package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PessoaDTO {
    private Integer idPessoa;
    @NotEmpty
    @NotBlank
    @ToString.Exclude
    @ApiModelProperty(value = "Nome")
    private String nome;

    @NotNull
    @ApiModelProperty(value = "Data de Nascimento")
    private LocalDate dataNascimento;

    @ApiModelProperty(value = "Email")
    private String email;

    private DadosPessoaisDTO dadosPessoaisDTO;
}
