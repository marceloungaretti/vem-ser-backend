package com.dbc.modulo1.aula6;

import java.util.Scanner;
import java.util.Stack;

public class Pilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ADD, POP e SIZE
        Stack<Integer> pilha = new Stack<>();
        int numero;
        int i = 0;
        while (i <= 15) {
            System.out.println("Adicione um número: ");
            numero = scanner.nextInt();

            if (numero % 2 == 0) {
                pilha.add(numero);
                i++;
            } else {
                if (pilha.size() > 0)
                pilha.pop();
                i++;
            }
        }
        while(!pilha.isEmpty()){
            Integer valor = pilha.pop();
            System.out.println(valor);
        }
    }
}