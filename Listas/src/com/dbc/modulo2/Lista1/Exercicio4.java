package com.dbc.modulo2.Lista1;

import java.util.Objects;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha seu estado: RS, SP ou RJ?");
        String estado = scanner.next();

        if (Objects.equals(estado, "RS")) {
            System.out.println("POSIÇÕES DAS CIDADES NO RANKING DE PIB POR MUNICÍPIOS DO BRASIL:\n Porto Alegre: 8ª \n Caxias do Sul: 40ª");
        } else if (Objects.equals(estado, "SP")) {
            System.out.println("POSIÇÕES DAS CIDADES NO RANKING DE PIB POR MUNICÍPIOS DO BRASIL:\n São Paulo(capital): 1ª \n Campinas: 11ª");
        } else if (Objects.equals(estado, "RJ")) {
            System.out.println("POSIÇÕES DAS CIDADES NO RANKING DE PIB POR MUNICÍPIOS DO BRASIL:\n Rio de Janeiro(capital): 2ª \n Niterói: 27ª");
        } else {
            System.out.println("Você não digitou um dos 3 estados.");
        }
    }
}
