package com.dbc.modulo2.aula5.exercicio2;

public abstract class VeiculoComMotor implements Motor, Veiculo {
    private int potencia;
    private int quilometragem;
    private String modelo;


    @Override
    public int getPotencia() {
        return 0;
    }

    @Override
    public int getQuilometragem() {
        return 0;
    }

    @Override
    public String getNome() {
        return null;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
