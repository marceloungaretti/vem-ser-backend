package com.dbc.modulo2.aula7.enums;

public enum TipoCarro {
    SEDAN("Sedan"),
    ESPORTIVO("Esportivo"),
    HATCH("Hatch"),
    SUV("Suv");

    private String descricao;

    TipoCarro(String descricao) {
        this.descricao = descricao;
    }

    TipoCarro(){}

    public String getDescricao() {
        return this.descricao;
    }
}
