package com.dbc.modulo2.L1eL2OrientadasAObjetos.Lista2.Exercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Adivinhacao tentativa = new Adivinhacao();

        System.out.println("Escolha um número: ");
        tentativa.numero = scanner.nextInt();

        System.out.println("Adivinhe o número: ");
        tentativa.adivinha = scanner.nextInt();

        tentativa.comparar();


    }
}
