package com.dbc.veiculoprodutorconsumidor.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "veiculo")
public class VeiculoEntity {
    @Id
    private String idVeiculo;
    private LocalDate dataLeitura;
    private Double velocidade;
    private Integer rotacao;
    private Boolean sensorFrenagem;
}