package com.dbc.Aula3;

public class Main {
    public static void main(String[] args) {
        Pessoa maicon = new Pessoa();
        maicon.nome = "Maicon";
        maicon.idade = 30;

        Pessoa guilherme = new Pessoa();
        guilherme.nome = "Guilherme";
        guilherme.idade = 22;

        maicon.diferencaIdade(guilherme);
        System.out.println(maicon.diferencaIdade(guilherme));



    }
}
