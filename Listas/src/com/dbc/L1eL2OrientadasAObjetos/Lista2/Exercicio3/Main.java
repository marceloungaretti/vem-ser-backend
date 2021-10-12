package com.dbc.L1eL2OrientadasAObjetos.Lista2.Exercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jogadoresCadastrados = 0;
        double somaAltura = 0;
        int maiorIdade = 0;

        Jogador jogador = new Jogador();

        do {

            if(jogadoresCadastrados == 0) {
                System.out.printf("Preencha os dados do jogador: %n");
                System.out.printf("Nome: %n");
                jogador.nome = scanner.nextLine();
            }

            System.out.println("Altura: ");
            jogador.altura = scanner.nextDouble();
            System.out.println("Idade: ");
            jogador.idade = scanner.nextInt();
            System.out.println("Peso: ");
            jogador.peso = scanner.nextDouble();
            scanner.nextLine();

            jogadoresCadastrados++;
            somaAltura += jogador.altura;

            System.out.printf("Preencha os dados do jogador: %n");
            System.out.print("Nome: ");
            jogador.nome = scanner.nextLine();

        } while(!jogador.nome.equalsIgnoreCase("Sair"));

        System.out.printf("Quantidade de jogadores: %d%n", jogadoresCadastrados);
        jogador.calculaMaiorJogador(jogador.altura);
        jogador.calculaMaisVelho(jogador.nome,  maiorIdade);
        jogador.calculaMaisPesado(jogador.nome);
        jogador.calculaMediaAltura(somaAltura, jogadoresCadastrados);


    }
}
