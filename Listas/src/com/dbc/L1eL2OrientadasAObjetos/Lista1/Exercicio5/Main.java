package com.dbc.L1eL2OrientadasAObjetos.Lista1.Exercicio5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Usuario usuario = new Usuario();
        System.out.println("Insira o valor/hora: ");
        usuario.valorHora = scanner.nextDouble();
        System.out.println("Insira o número de horas trabalhadas: ");
        usuario.horasTrabalhadas = scanner.nextInt();
        usuario.salarioBase();


        System.out.println("Insira o número de horas extras (50%): ");
        usuario.horasExtras50 = scanner.nextInt();
        usuario.salarioExtra50();

        System.out.println("Insira o número de horas extras (100%): ");
        usuario.horasExtras100 = scanner.nextInt();
        usuario.salarioExtra100();

        usuario.salarioBruto();
    }
}
