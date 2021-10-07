package com.dbc.Lista2;

import java.util.Scanner;

public class Tema5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int valor = 20;
        int[] valores = new int[valor];

        for (int i = 0; i < valor; i++) {
            System.out.println("Digite um valor: ");
            valores[i] = scanner.nextInt();
        }
        for (int i = valores.length; i > 0; i--) {
            System.out.println(valores[i - 1]);
        }
    }
}
