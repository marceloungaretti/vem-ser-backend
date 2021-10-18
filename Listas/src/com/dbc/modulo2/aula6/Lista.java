package com.dbc.modulo2.aula6;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listaDeNomes = new ArrayList<>();
        String nome;

        do {
            System.out.println("Digite um nome para ser adicionado, ou SAIR para encerrar: ");
            nome = scanner.nextLine();
            if (!nome.equalsIgnoreCase("SAIR")) {
                listaDeNomes.add(nome);
            }
        } while (!nome.equalsIgnoreCase("SAIR"));

        System.out.println(listaDeNomes);
        System.out.println(listaDeNomes.get(listaDeNomes.size() - 2));
        System.out.println(listaDeNomes.get(0));
        System.out.println(listaDeNomes.remove(listaDeNomes.size() - 1) + " foi removido");
        System.out.println(listaDeNomes);
        System.out.println(listaDeNomes.size());

    }


}
