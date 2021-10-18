package com.dbc.modulo2.L1eL2OrientadasAObjetos.Lista1.Exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Apresentacao fulano = new Apresentacao();
        System.out.println("Digite seu nome: ");
        fulano.setNome(scanner.next());
        System.out.println("Digite a sua idade: ");
        fulano.setIdade(scanner.nextInt());
        System.out.println("Qual a sua cidade?");
        fulano.setCidade(scanner.next());
        System.out.println("Em qual estado fica a sua cidade?");
        fulano.setEstado(scanner.next());

        fulano.imprimirApresentacao();


    }
}
