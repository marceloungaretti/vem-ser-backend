package com.dbc.L1eL2OrientadasAObjetos.Lista1.Exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Apresentacao fulano = new Apresentacao();
        System.out.println("Digite seu nome: ");
        fulano.nome = scanner.next();
        System.out.println("Digite a sua idade: ");
        fulano.idade = scanner.nextInt();
        System.out.println("Qual a sua cidade?");
        fulano.cidade = scanner.next();
        System.out.println("Em qual estado fica a sua cidade?");
        fulano.estado = scanner.next();

        fulano.imprimirApresentacao();


    }
}
