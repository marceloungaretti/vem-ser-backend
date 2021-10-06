package com.dbc.Lista2;

public class ExercicioAula {
    public static void main(String[] args) {
        int [][] matrizNumeros = new int[2][2];
        matrizNumeros[0][0] = 10;
        matrizNumeros[0][1] = 20;
        matrizNumeros[1][0] = 1;
        matrizNumeros[1][1] = 2;

        int SQ1 = matrizNumeros[0][0];
        int SQ2 = matrizNumeros[0][1];
        int SQ3 = matrizNumeros[1][0];
        int SQ4 = matrizNumeros[1][1];

        int soma = SQ1 + SQ2 + SQ3 + SQ4;
        int somaLinha1 = SQ1 + SQ2;
        int somaLinha2 = SQ3 + SQ4;


        System.out.println("Soma de todos os valores: " + soma);
        System.out.println("Soma da linha 1: " + somaLinha1);
        System.out.println("Soma da linha 2: " + somaLinha2);
        System.out.println("LINHA 1 - LINHA 2 = " + (somaLinha1 - somaLinha2));
    }
}
