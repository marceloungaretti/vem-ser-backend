package com.dbc;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a PRIMEIRA nota: ");
        float nota1 = scanner.nextInt();
        System.out.println("Digite a SEGUNDA nota: ");
        float nota2 = scanner.nextInt();
        System.out.println("Digite a TERCEIRA nota: ");
        float nota3 = scanner.nextInt();
        System.out.println("Digite a QUARTA nota: ");
        float nota4 = scanner.nextInt();

        float media = (nota1 + nota2 + nota3 + nota4) / 4;

        if (media <=10 && media >= 7) {
            System.out.println("Sua média foi " + media + ". Você foi APROVADO!");
        } else if (media <=6.9 && media >= 5.1) {
            System.out.println("Sua média foi " + media + ". Você está em EXAME.");
        } else {
            System.out.println("Sua média foi " + media + ". Você está REPROVADO.");
        }
    }
}
