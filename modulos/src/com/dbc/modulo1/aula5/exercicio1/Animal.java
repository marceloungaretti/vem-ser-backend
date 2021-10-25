package com.dbc.modulo1.aula5.exercicio1;

public abstract class Animal {
    private String nome;
    private String raca;

    public Animal() {
    }

    public Animal(String nome) {
        this.nome = nome;
    }

    public String caminha() {
        return this.nome + " caminha";
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        return this.nome = nome;
    }

}