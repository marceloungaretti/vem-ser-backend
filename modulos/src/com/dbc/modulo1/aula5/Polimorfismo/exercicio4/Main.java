package com.dbc.modulo1.aula5.Polimorfismo.exercicio4;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        OperacaoMatematica soma = new Soma();
        soma.calcula(a, b);

        OperacaoMatematica subtracao = new Subtracao();
        subtracao.calcula(a, b);

        OperacaoMatematica mult = new Multiplicacao();
        mult.calcula(a, b);

        OperacaoMatematica divisao = new Divisao();
        divisao.calcula(a, b);
    }
}
