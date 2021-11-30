package com.dbc.veiculoprodutorconsumidor.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VeiculoDTO {
    private LocalDate dataLeitura;
    private Double velocidade;
    private Integer rotacao;
    private Boolean sensorFrenagem;
}