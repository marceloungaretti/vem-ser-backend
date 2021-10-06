package com.dbc.Lista2;

import java.util.Objects;
import java.util.Scanner;

public class ExercicioAula4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma palavra (digite 'fim' para finalizar o programa): ");
        String palavra = scanner.next();

        while(!Objects.equals(palavra, "fim")) {
            System.out.println(palavra);
            System.out.println("Digite uma palavra('fim' para finalizar): ");

            palavra = scanner.next();
        }
        System.out.println("Programa finalizado.");
    }
}
