package com.dbc.produtorconsumidor.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AlunoDTO {
    private String nome;
    private LocalDate dataNascimento;
    private List<Integer> notas;
}
