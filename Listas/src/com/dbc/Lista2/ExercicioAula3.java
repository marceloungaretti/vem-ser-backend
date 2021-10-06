package com.dbc.Lista2;

import java.util.Arrays;
import java.util.Scanner;

public class ExercicioAula3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeros = 3;
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
