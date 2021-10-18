package com.dbc.modulo2.Aula4.Heranca;

public abstract class Veiculo {
    private int quilometragem;
    private String nome;


    public Veiculo(String nome, int quilometragem) {
        super();
    }

    public Veiculo() {

    }


    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
