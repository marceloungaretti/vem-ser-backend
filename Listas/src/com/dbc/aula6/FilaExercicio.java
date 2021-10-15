package com.dbc.aula6;

import java.util.LinkedList;
import java.util.Queue;

public class FilaExercicio {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.add("A");
        fila.add("B");
        fila.add("C");
        fila.add("D");
        fila.add("E");
        System.out.println(fila);
        fila.poll();
        fila.poll();
        System.out.println(fila);
        fila.poll();
        System.out.println(fila);
        fila.add("F");
        fila.add("G");
        fila.add("H");
        System.out.println(fila);
        fila.poll();
        fila.poll();
        fila.poll();
        System.out.println(fila);


    }
}
