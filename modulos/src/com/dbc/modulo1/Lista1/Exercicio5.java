package com.dbc.modulo1.Lista1;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o valor/hora: ");
        double valorHora = scanner.nextDouble();
        System.out.println("Insira o número de horas trabalhadas: ");
        int horaTrabalhadas = scanner.nextInt();
        double salarioBase = horaTrabalhadas * valorHora;

        System.out.println("Insira o número de horas extras (100%): ");
        int horasExtras = scanner.nextInt();
        double valorExtra = horasExtras * valorHora * 2;

        System.out.println("Insira o número de horas extras (50%): ");
        int horasExtras50 = scanner.nextInt();
        double valorExtra2 = horasExtras50 * valorHora * 1.5;

        double salarioBruto = salarioBase + valorExtra + valorExtra2;
        System.out.println("Seu salário bruto é de R$ " + salarioBruto);
    }
}
