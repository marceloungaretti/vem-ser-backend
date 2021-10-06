package com.dbc.Lista2;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[3];
        System.out.println("Digite o PRIMEIRO número: ");
        numeros[0] = scanner.nextInt();
        System.out.println("Digite o SEGUNDO número: ");
        numeros[1] = scanner.nextInt();
        System.out.println("Digite o TERCEIRO número: ");
        numeros[2] = scanner.nextInt();

        int soma = numeros[0] + numeros[1] + numeros[2];
        float media = soma / 3;
        System.out.println("Soma:" + soma);
        System.out.println("Média:" + media);
    }
}
