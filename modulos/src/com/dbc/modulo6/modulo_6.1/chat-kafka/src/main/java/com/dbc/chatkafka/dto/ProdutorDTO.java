package com.dbc.chatkafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutorDTO {
    private String usuario;
    private String mensagem;
    private LocalDateTime dataCriacao;
}
