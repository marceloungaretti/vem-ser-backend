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
    }
}
