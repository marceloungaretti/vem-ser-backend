package com.dbc.modulo1.L1eL2OrientadasAObjetos.Lista1.Exercicio2;

public class Avaliador {
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double media;

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public double calcularMedia() {
        this.media = (nota1 + nota2 + nota3 + nota4) / 4;
        return this.media;
    }

    public void imprimirResultado() {
        calcularMedia();
        if (media <= 10 && media >= 7) {
            System.out.println("Sua média foi " + media + ". Você foi APROVADO!");
        } else if (media <= 6.9 && media >= 5.1) {
            System.out.println("Sua média foi " + media + ". Você está em EXAME.");
        } else {
            System.out.println("Sua média foi " + media + ". Você está REPROVADO.");
        }
    }

}
