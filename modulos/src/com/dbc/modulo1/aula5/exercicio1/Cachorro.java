package com.dbc.modulo1.aula5.exercicio1;

public class Cachorro extends Animal {

    public Cachorro(String nome) {
        super(nome);
    }

    public String late() {
        return this.getNome() + " late";
    }

}
