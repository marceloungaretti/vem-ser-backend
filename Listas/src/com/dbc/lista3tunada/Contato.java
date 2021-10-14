package com.dbc.lista3tunada;

public class Contato {

    String descricao;
    String telefone;
    int tipo;

    public Contato() {
    }

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }



    public void imprimirContato() {
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Tipo:" + this.tipo + "\n");
    }
}
