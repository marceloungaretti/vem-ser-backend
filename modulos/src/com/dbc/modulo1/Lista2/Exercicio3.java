package com.dbc.modulo1.Lista2;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jogadoresCadastrados = 0;
        String nome = null;
        String nomeMaisVelho = null;
        double altura = 0;
        double alturaMaiorJogador = 0;
        double somaAltura = 0;
        int idade = 0;
        int maiorIdade = 0;
        double peso = 0;
        double maiorPeso = 0;
        String nomeMaisPesado = null;

        do {
            if(jogadoresCadastrados == 0) {
                System.out.printf("Preencha os dados do jogador: %n");
                System.out.printf("Nome: %n");
                nome = scanner.nextLine();
            }

            System.out.println("Altura: ");
            altura = scanner.nextDouble();
            System.out.println("Idade: ");
            idade = scanner.nextInt();
            System.out.println("Peso: ");
            peso = scanner.nextDouble();
            scanner.nextLine();

            jogadoresCadastrados++;
            somaAltura += altura;

            if (altura > alturaMaiorJogador) {
                alturaMaiorJogador = altura;
            }

            if (idade > maiorIdade) {
                maiorIdade = idade;
                nomeMaisVelho = nome;
            }

            if (peso > maiorPeso) {
                maiorPeso = peso;
                nomeMaisPesado = nome;
            }
            System.out.printf("Preencha os dados do jogador: %n");
            System.out.print("Nome: ");
            nome = scanner.nextLine();

        } while(!nome.equalsIgnoreCase("Sair"));

        double mediaAltura = somaAltura / jogadoresCadastrados;

        System.out.printf("Quantidade de jogadores: %d%n", jogadoresCadastrados);
        System.out.printf("Altura do maior jogador: %.2f %n", alturaMaiorJogador);
        System.out.printf("Jogador mais velho: %s %n", nomeMaisVelho);
        System.out.printf("Jogador mais pesado: %s %n", nomeMaisPesado);
        System.out.printf("Média das alturas: %.2f %n", mediaAltura);
    }
}

