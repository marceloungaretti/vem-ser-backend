package com.dbc.modulo2.Lista2;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um número: ");
        int numero = scanner.nextInt();

        System.out.println("Adivinhe o número: ");
        int adivinha = scanner.nextInt();

        while(numero != adivinha) {

            if (numero > adivinha) {
                System.out.println("Errado. Tente um número maior.");
            } else {
                System.out.println("Errado. Tente um número menor.");
            }
            System.out.println("Adivinhe o número: ");
            adivinha = scanner.nextInt();
        }
        System.out.print("VOCÊ ACERTOU!");
    }
}
