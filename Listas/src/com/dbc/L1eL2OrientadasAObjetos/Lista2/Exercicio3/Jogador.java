package com.dbc.L1eL2OrientadasAObjetos.Lista2.Exercicio3;

public class Jogador {
    String nome;
    double altura;
    int idade;
    double peso;
    String nomeMaisVelho;
    double maiorPeso;
    String nomeMaisPesado;
    int maiorIdade;
    double alturaMaiorJogador;

    public Jogador() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNomeMaisVelho() {
        return nomeMaisVelho;
    }

    public void setNomeMaisVelho(String nomeMaisVelho) {
        this.nomeMaisVelho = nomeMaisVelho;
    }

    public void calculaMaiorJogador(double altura) {
        if (this.alturaMaiorJogador < altura) {
            this.alturaMaiorJogador = altura;

        }
        this.alturaMaiorJogador = alturaMaiorJogador;
        System.out.printf("Altura do maior jogador: %.2f %n", this.alturaMaiorJogador);
    }

    public void calculaMaisVelho(String nome, int maiorIdade) {
        if (idade > maiorIdade) {
            this.maiorIdade = idade;
            this.nomeMaisVelho = nome;
        }
        System.out.printf("Jogador mais velho: %s %n", this.nomeMaisVelho);
    }

    public String calculaMaisPesado(String nome) {
        if (peso > maiorPeso) {
            maiorPeso = peso;
            this.nomeMaisPesado = nome;
        }
        System.out.printf("Jogador mais pesado: %s %n", this.nomeMaisPesado);
        return nomeMaisPesado;
    }

    public double calculaMediaAltura(double somaAltura, int jogadoresCadastrados) {
        double mediaAltura = somaAltura / jogadoresCadastrados;
        System.out.printf("Média das alturas: %.2f %n", mediaAltura);
        return mediaAltura;
    }




}
