package com.dbc.modulo2.aula7.outro.exercicio1;

public enum TipoComida {
    JAPONESA("Japonesa: R$ 50"),
    FASTFOOD("Fast Food: R$ 30"),
    TRADICIONAL("Tradicional: R$ 20");

    private String descricao;

    TipoComida(String descricao) {
        this.descricao = descricao;
    }

    TipoComida(){}

    public String getDescricao() {
        return this.descricao;
    }
}
