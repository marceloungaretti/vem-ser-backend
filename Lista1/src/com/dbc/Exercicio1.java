package com.dbc;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = scanner.next();
        System.out.println("Digite a sua idade: ");
        int idade = scanner.nextInt();
        System.out.println("Qual a sua cidade?");
        String cidade = scanner.next();
        System.out.println("Em qual estado fica a sua cidade?");
        String estado = scanner.next();

        System.out.println("Olá! Seu nome é "
                + nome + ", você tem "
                + idade + " anos, é da cidade de "
                + cidade + ", situada no estado de " + estado);
    }
}
