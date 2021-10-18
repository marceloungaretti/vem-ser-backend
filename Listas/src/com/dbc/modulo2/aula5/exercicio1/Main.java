package com.dbc.modulo2.aula5.exercicio1;

public class Main {
    public static void main(String[] args) {
        Cachorro dog = new Cachorro("Pyke");
        Gato cat = new Gato("Yumi");
        System.out.println(dog.late());
        System.out.println(cat.mia());
        System.out.println(cat.caminha());

    }
}
