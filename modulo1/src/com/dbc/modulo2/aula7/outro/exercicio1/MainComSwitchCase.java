package com.dbc.modulo2.aula7.outro.exercicio1;

import java.util.Scanner;

public class MainComSwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TipoComida japonesa = TipoComida.JAPONESA;
        TipoComida fastFood = TipoComida.FASTFOOD;
        TipoComida tradicional = TipoComida.TRADICIONAL;

        System.out.println("Escolha a sua comida.");
        System.out.println("1- " + japonesa);
        System.out.println("2- " + fastFood);
        System.out.println("3- " + tradicional);
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Sua comida " + japonesa.getDescricao());
                break;
            case 2:
                System.out.println("Sua comida " + fastFood.getDescricao());
                break;
            case 3:
                System.out.println("Sua comida " + tradicional.getDescricao());
                break;
            default:
                System.err.println("Opção inválida!");
                break;
        }
    }
}