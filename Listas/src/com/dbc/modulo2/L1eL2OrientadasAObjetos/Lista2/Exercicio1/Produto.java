package com.dbc.modulo2.L1eL2OrientadasAObjetos.Lista2.Exercicio1;

public class Produto {
    String nome;
    double valor;

    public Produto() {
    }

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void calcularTotal() {
        for (int i = 1; i <= 10; i++) {
            double valorComDesconto = valor - i * valor * 0.05;
            System.out.printf("%d x R$%.2f = R$%.2f %n", i, valor, valorComDesconto * i);
        }
    }
}
