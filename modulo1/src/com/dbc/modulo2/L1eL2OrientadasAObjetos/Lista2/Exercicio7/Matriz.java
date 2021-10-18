package com.dbc.modulo2.L1eL2OrientadasAObjetos.Lista2.Exercicio7;

import java.util.Scanner;

public class Matriz {

    public void contagemMaiorQue10() {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        int contagem = 0;

        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                System.out.printf("%dª linha, %dª coluna = ", linha + 1, coluna + 1);
                matriz[linha][coluna] = scanner.nextInt();
            }
        }

        //contagem > 10
        for (int linha = 0; linha < 4; linha++)
            for (int coluna = 0; coluna < 4; coluna++)
                if (matriz[linha][coluna] > 10)
                    contagem++;


        System.out.printf("\n\n Existem na matriz %d números maiores que 10.", contagem);

    }
}
