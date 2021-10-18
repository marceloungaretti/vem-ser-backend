package com.dbc.modulo2.L1eL2OrientadasAObjetos.Lista1.Exercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Avaliador avaliador = new Avaliador();
        System.out.println("Digite a PRIMEIRA nota: ");
        avaliador.setNota1(scanner.nextDouble());
        System.out.println("Digite a SEGUNDA nota: ");
        avaliador.setNota2(scanner.nextDouble());
        System.out.println("Digite a TERCEIRA nota: ");
        avaliador.setNota3(scanner.nextDouble());
        System.out.println("Digite a QUARTA nota: ");
        avaliador.setNota4(scanner.nextDouble());

        avaliador.imprimirResultado();
    }
}
