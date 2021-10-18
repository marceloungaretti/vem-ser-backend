package com.dbc.modulo2.aula7.outro.exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um tipo de comida");
        TipoComida tipo = TipoComida.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Você escolheu " + tipo.getDescricao());
    }
}
