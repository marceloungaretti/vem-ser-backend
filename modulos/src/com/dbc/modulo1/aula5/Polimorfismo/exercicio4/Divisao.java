package com.dbc.modulo1.aula5.Polimorfismo.exercicio4;

public class Divisao implements OperacaoMatematica{
    @Override
    public int calcula(int a, int b) {
        System.out.printf("%d / %d = ", a, b);
        System.out.println(a / b);
        return a / b;
    }
}
