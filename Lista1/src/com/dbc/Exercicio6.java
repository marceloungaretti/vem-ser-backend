package com.dbc;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira a palavra a ser traduzida: ");
        String palavra = scanner.nextLine();

        switch (palavra) {
            case "Cachorro":
                System.out.println("Dog");
                break;
            case "Dog":
                System.out.println("Cachorro");
                break;
            case "Tempo":
                System.out.println("Time");
                break;
            case "Time":
                System.out.println("Tempo");
                break;
            case "Amor":
                System.out.println("Love");
                break;
            case "Love":
                System.out.println("Amor");
                break;
            case "Cidade":
                System.out.println("City");
                break;
            case "City":
                System.out.println("Cidade");
                break;
            case "Feliz":
                System.out.println("Happy");
                break;
            case "Happy":
                System.out.println("Feliz");
                break;
            default:
                System.out.println("Esta palavra não é válida.");
        }
    }
}
