package com.dbc.modulo1.Aula4.Heranca;

public class Barco extends Veiculo{
    private int maxPassageiros;
    private int velocidadeMaxima;
    private String materialCasco;

    public Barco(String nome, int quilometragem) {
        super(nome, quilometragem);
    }

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public String getMaterialCasco() {
        return materialCasco;
    }

    public void setMaterialCasco(String materialCasco) {
        this.materialCasco = materialCasco;
    }
}
