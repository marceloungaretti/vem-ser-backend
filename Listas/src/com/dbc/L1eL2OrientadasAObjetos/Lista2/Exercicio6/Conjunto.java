package com.dbc.L1eL2OrientadasAObjetos.Lista2.Exercicio6;

import java.util.Scanner;

public class Conjunto {

    public void buscar() {
        Scanner scanner = new Scanner(System.in);
        int[] valores = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.printf("Digite um número a ser buscado: ");
        int numero = scanner.nextInt();

        try {
            for (int i = 0; i < valores.length; i++) {
                if (numero == valores[i]) {
                    System.out.printf("Este número se encontra no vetor na posição %d", i + 1);
                }
            }
        } catch (Exception err) {
            System.out.print("asdasdas");
        }
    }
}
