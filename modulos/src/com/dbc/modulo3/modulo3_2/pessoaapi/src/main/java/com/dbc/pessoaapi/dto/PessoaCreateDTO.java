package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Data
public class PessoaCreateDTO {
        @NotEmpty
        @NotBlank
        @ToString.Exclude
        @ApiModelProperty(value = "Nome")
        private String nome;

        @NotNull
        @ApiModelProperty(value = "Data de Nascimento")
        private LocalDate dataNascimento;

        @Size(max = 11, min = 11, message = "cpf deve conter 11 caracteres")
        @NotNull
        @ApiModelProperty(value = "CPF")
        private String cpf;

        @NotNull
        @ApiModelProperty(value = "Email")
        private String email;

        @ApiModelProperty(value = "Endereços")
        private Set<EnderecoEntity> enderecos;
}
