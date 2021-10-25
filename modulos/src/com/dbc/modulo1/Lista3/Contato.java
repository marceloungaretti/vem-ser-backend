package com.dbc.modulo1.Lista3;

public class Contato {

    String descricao;
    String telefone;
    int tipo;


    public void imprimirContato() {
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Tipo:" + this.tipo + "\n");
    }
}
