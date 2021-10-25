package com.dbc.modulo1.oo2_homework;

public class Contato {

    private String descricao;
    private String telefone;
    private int tipo;

    public Contato() {
    }

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }



    public void imprimirContato() {
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("Tipo:" + this.getTipo() + "\n");
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
