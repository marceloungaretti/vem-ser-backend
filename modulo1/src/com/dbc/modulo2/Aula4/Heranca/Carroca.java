package com.dbc.modulo2.Aula4.Heranca;

public class Carroca extends Veiculo{
    private int quantidadeDeCavalos;
    private int velocidadeMaxima;

    public Carroca(String nome, int quilometragem) {
        super(nome, quilometragem);
    }

    public int getQuantidadeDeCavalos() {
        return quantidadeDeCavalos;
    }

    public void setQuantidadeDeCavalos(int quantidadeDeCavalos) {
        this.quantidadeDeCavalos = quantidadeDeCavalos;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}
