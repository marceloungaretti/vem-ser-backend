package com.dbc.modulo1.L1eL2OrientadasAObjetos.Lista1.Exercicio6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Insira a palavra a ser traduzida: ");
        String palavra = scanner.nextLine();
        Tradutor tradutor = new Tradutor(palavra);

        tradutor.traduzir();
    }
}
