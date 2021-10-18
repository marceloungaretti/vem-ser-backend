package com.dbc.modulo2.Lista2;

import java.util.Scanner;

public class ExercicioAula3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos números serão usados?");
        int numeros = scanner.nextInt();
        int[] valores = new int[numeros];
        int sum = 0;
        for (int valor : valores) {
            System.out.println("Digite um valor: ");
            valores[valor] = scanner.nextInt();
            sum = sum + valores[valor];
        }
        System.out.println("SOMA DOS VALORES: " + sum + "\nMÉDIA: " + sum / numeros);
    }
}
