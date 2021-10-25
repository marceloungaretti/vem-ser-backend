package com.dbc.modulo1.Aula4.Heranca;

public class Main {
    public static void main(String[] args) {
        Veiculo mustang = new Carro();
        mustang.getNome();
        mustang.getQuilometragem();
        Carro mustangCast = (Carro) mustang;
        ((Carro) mustang).getModeloMotor();
        mustangCast.getVelocidadeMaxima();
        ((Carro) mustang).getPotencia();

        Carro mustang2 = new Carro();
        mustang2.getNome();
        mustang2.getQuilometragem();
        mustang2.getModeloMotor();
        mustang2.getVelocidadeMaxima();
        mustang2.getPotencia();

    }
}
