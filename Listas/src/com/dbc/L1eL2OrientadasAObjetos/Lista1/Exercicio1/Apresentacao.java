package com.dbc.L1eL2OrientadasAObjetos.Lista1.Exercicio1;

public class Apresentacao {
    String nome;
    int idade;
    String cidade;
    String estado;

    public Apresentacao() {
    }

    public Apresentacao(String nome, int idade, String cidade, String estado) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
    }

    public void imprimirApresentacao() {
        System.out.println("Olá. Seu nome é " + this.nome
                + ", você tem " + this.idade
                + " anos, é da cidade de " + this.cidade
                + ", situada no estado de " + this.estado);

    }



}
