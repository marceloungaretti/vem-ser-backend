package com.dbc.aula6;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    public static void main(String[] args) {
        Queue<String> minhaFila = new LinkedList<>();
        minhaFila.add("Bruno");
        minhaFila.add("Camile");
        minhaFila.add("Maicon");

        minhaFila.poll();
        System.out.println(minhaFila);
        System.out.println(minhaFila.size());
    }
}
