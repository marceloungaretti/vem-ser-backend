package com.dbc.Lista2;

import java.util.Scanner;

public class Tema8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[5][4];

        for(int linha=0; linha<5; linha++)
        {
            for(int coluna=0; coluna<4; coluna++)
            {
                System.out.printf("%dª linha, %dª coluna = ", linha+1, coluna+1);
                matriz[linha][coluna] = scanner.nextInt();
            }

        }
        System.out.printf(String.valueOf(matriz[0][0]), matriz[0][1], matriz[0][2], "%n");
        System.out.printf(String.valueOf(matriz[1][0]), matriz[1][1], matriz[1][2], "%n");
        System.out.printf(String.valueOf(matriz[2][0]), matriz[2][1], matriz[2][2], "%n");
        System.out.printf(String.valueOf(matriz[3][0]), matriz[3][1], matriz[3][2], "%n");
        System.out.printf(String.valueOf(matriz[4][0]), matriz[4][1], matriz[4][2]);
    }
}
