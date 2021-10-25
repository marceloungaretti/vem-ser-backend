package com.dbc.modulo1.L1eL2OrientadasAObjetos.Lista2.Exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto produto = new Produto();

        System.out.println("Digite o nome do produto: ");
        produto.nome = scanner.next();
        System.out.println("Digite o valor do produto: ");
        produto.valor = scanner.nextDouble();

        System.out.println(produto.nome);
        produto.calcularTotal();

    }
}
