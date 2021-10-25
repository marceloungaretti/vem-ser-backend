package com.dbc.modulo1.L1eL2OrientadasAObjetos.Lista1.Exercicio3;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            Pedido pedido = new Pedido();
            System.out.println("Insira o valor total do pedido: ");
            pedido.setValorDoPedido(scanner.nextInt());
            System.out.println("Insira o valor pago pelo cliente: ");
            pedido.setValorPago(scanner.nextInt());
            pedido.calcularTroco();

            if (pedido.getValorPago() < pedido.getValorDoPedido()) {
                System.out.println("O valor pago deve ser maior ou igual ao valor consumido.");
            }
            if (pedido.getValorPago() == pedido.getValorDoPedido()) {
                System.out.println("Obrigado! Volte Sempre!");
            }
            if (pedido.getValorPago() > pedido.getValorDoPedido()) {
                System.out.println("Seu troco é de " +  pedido.calcularTroco() + " reais. Obrigado pela preferência!");
            }

    }
}
