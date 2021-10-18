package com.dbc.modulo2.Aula4.Exercicio1;

public class Carro {

    private String modelo;
    private int quilometragem;

    public Carro() {
        System.out.println("Criou");
    }

    public Carro(String modelo) {
        this.modelo = modelo;
        System.out.println("Criou com modelo: " + modelo);
    }

    public Carro(String modelo, int quilometragem) {
        this.modelo = modelo;
        this.quilometragem = quilometragem;
        System.out.println("Criou com modelo e quilometragem: " + modelo + " - " + quilometragem + "km");
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public int getQuilometragem() {
        return quilometragem;
    }


}
