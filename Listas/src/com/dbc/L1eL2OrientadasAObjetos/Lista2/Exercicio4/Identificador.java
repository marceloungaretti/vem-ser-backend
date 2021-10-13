package com.dbc.L1eL2OrientadasAObjetos.Lista2.Exercicio4;

import java.util.Scanner;

public class Identificador {

    public static void identificar() {
        Scanner scanner = new Scanner(System.in);
        int valor = 3;
        int[] valores = new int[valor];
        for (int i = 0; i < valor; i++) {
            System.out.println("Digite um valor: ");
            valores[i] = scanner.nextInt();
        }
        if (valores[0] < valores[1] && valores[0] < valores[2]) {
            System.out.print("A posição do menor número digitado é a PRIMEIRA, ou seja, [0]");

        } else if (valores[1] < valores[0] && valores[1] < valores[2]) {
            System.out.print("A posição do menor número digitado é a SEGUNDA, ou seja, [1]");

        } else if (valores[2] < valores[0] && valores[2] < valores[1]) {
            System.out.print("A posição do menor número digitado é a TERCEIRA, ou seja, [2]");
        } else {
            System.out.print("Não foi possível encontrar um ÚNICO menor número");
        }
    }
}
