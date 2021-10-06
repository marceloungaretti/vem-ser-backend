package com.dbc;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o valor/hora: ");
        double valorHora = scanner.nextDouble();
        System.out.println("Insira o número de horas trabalhadas: ");
        int horaTrabalhadas = scanner.nextInt();
        double salarioBase = horaTrabalhadas * valorHora;

        System.out.println("Insira o número de horas extras: ");
        int horasExtras = scanner.nextInt();

        double valorExtra = horasExtras * valorHora * 2;

        double salarioBruto = salarioBase + valorExtra;

        System.out.println("Seu salário bruto é de R$ " + salarioBruto);
    }
}
