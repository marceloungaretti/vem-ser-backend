package com.dbc.modulo1.aula5.exercicio1;

public class Gato extends Animal{

    public Gato(String nome) {
        super(nome);
    }

    public String mia() {
        return this.getNome() + " mia";
    }
}
