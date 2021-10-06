package com.dbc.Lista1;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a PRIMEIRA nota: ");
        double nota1 = scanner.nextDouble();
        System.out.println("Digite a SEGUNDA nota: ");
        double nota2 = scanner.nextDouble();
        System.out.println("Digite a TERCEIRA nota: ");
        double nota3 = scanner.nextDouble();
        System.out.println("Digite a QUARTA nota: ");
        double nota4 = scanner.nextDouble();

        double media = (nota1 + nota2 + nota3 + nota4) / 4;

        if (media <=10 && media >= 7) {
            System.out.println("Sua média foi " + media + ". Você foi APROVADO!");
        } else if (media <=6.9 && media >= 5.1) {
            System.out.println("Sua média foi " + media + ". Você está em EXAME.");
        } else {
            System.out.println("Sua média foi " + media + ". Você está REPROVADO.");
        }
    }
}
