package com.dbc.modulo1.Aula4.Heranca;

public class Carro extends Veiculo{
    private String modeloMotor;
    private int potencia;
    private int velocidadeMaxima;

    public Carro(String nome, int quilometragem) {
        super(nome, quilometragem);
    }

    public Carro() {
        super();
    }


    public String getModeloMotor() {
        return modeloMotor;
    }

    public void setModeloMotor(String modeloMotor) {
        this.modeloMotor = modeloMotor;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}
