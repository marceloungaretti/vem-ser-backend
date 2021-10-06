package com.dbc.Lista1;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o valor total do pedido: ");
        int valorDoPedido = scanner.nextInt();
        System.out.println("Insira o valor pago pelo cliente: ");
        int valorPago = scanner.nextInt();
        int troco = valorPago - valorDoPedido;

        if (valorPago < valorDoPedido) {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido”");
        }
        if (valorPago == valorDoPedido) {
            System.out.println("Obrigado! Volte Sempre!");
        }
        if (valorPago > valorDoPedido) {
            System.out.println("Seu troco é de " + troco + " reais. Obrigado pela preferência!");
        }
    }
}
