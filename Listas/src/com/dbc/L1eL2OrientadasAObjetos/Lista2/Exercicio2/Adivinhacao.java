package com.dbc.L1eL2OrientadasAObjetos.Lista2.Exercicio2;

import java.util.Scanner;

public class Adivinhacao {
    int numero;
    int adivinha;

    public Adivinhacao() {
    }

    public Adivinhacao(int numero, int adivinha) {
        this.numero = numero;
        this.adivinha = adivinha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAdivinha() {
        return adivinha;
    }

    public void setAdivinha(int adivinha) {
        this.adivinha = adivinha;
    }

    public void comparar() {
        Scanner scanner = new Scanner(System.in);
        while(numero != adivinha) {

            if (numero > adivinha) {
                System.out.println("Errado. Tente um número maior.");
            } else {
                System.out.println("Errado. Tente um número menor.");
            }
            System.out.println("Adivinhe o número: ");
            adivinha = scanner.nextInt();
        }
        System.out.print("VOCÊ ACERTOU!");
    }
}
