package com.dbc.modulo2.L1eL2OrientadasAObjetos.Lista1.Exercicio1;

public class Apresentacao {
    private String nome;
    private int idade;
    private String cidade;
    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

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
