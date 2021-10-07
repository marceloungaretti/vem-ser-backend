package com.dbc.Lista3;

public class ExercicioDeAula {

    public static void main(String[] args) {
        String[] valores = {"01234", "5680.8", "670.2"};
        Integer valor1 = Integer.parseInt(valores[0]);
        System.out.println(valor1);

        Double salario = Double.parseDouble(valores[1]);
        System.out.println(salario);

        Double desconto = Double.parseDouble(valores[2]);
        System.out.println(desconto);

        Double valorFinal = salario - desconto;
        System.out.println(valorFinal);
    }
}



