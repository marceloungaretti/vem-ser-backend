package com.dbc.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {
    @NotNull
    private String usuario;
    @NotNull
    private String senha;

}
