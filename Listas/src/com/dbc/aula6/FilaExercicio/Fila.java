package com.dbc.aula6.FilaExercicio;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Fila {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> minhaFila = new LinkedList<>();
        int senha = 1;

        do {
            System.out.println("Digite um nome para entrar, ou SAIR para encerrar: ");
            Pessoa x = new Pessoa();
            x.setNome(scanner.nextLine());
            x.setSenha(senha);
            senha++;


            if (!x.getNome().equalsIgnoreCase("SAIR")) {
                minhaFila.add(x.getNome());
            }
        } while (scanner.nextLine().equalsIgnoreCase("SAIR"));

        minhaFila.add("Bruno");
        minhaFila.add("David");
        minhaFila.add("Maicon");
        minhaFila.add("Bianca");
        minhaFila.add("Marcelo");

    }

}
