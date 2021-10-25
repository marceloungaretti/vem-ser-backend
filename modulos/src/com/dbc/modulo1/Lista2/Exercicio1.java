package com.dbc.modulo1.Lista2;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.next();
        System.out.println("Digite o valor do produto: ");
        double valor = scanner.nextDouble();

        System.out.println(nome);

        for (int i = 1; i <= 10; i++) {
            double valorComDesconto = valor - i * valor * 0.05;
            System.out.printf("%d x R$%.2f = R$%.2f %n", i, valor, valorComDesconto * i);
        }
    }
}
