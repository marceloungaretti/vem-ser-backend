package com.dbc.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProfessorPK implements Serializable {

    @Column(name = "id_professor")
    private Integer idProfessor;

    @Column(name = "id_universidade")
    private Integer idUniversidade;

}
