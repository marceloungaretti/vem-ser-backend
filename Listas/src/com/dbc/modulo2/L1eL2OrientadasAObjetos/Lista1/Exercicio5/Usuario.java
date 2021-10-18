package com.dbc.modulo2.L1eL2OrientadasAObjetos.Lista1.Exercicio5;

public class Usuario {
    double valorHora;
    int horasTrabalhadas;
    int horasExtras50;
    int horasExtras100;

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getHorasExtras50() {
        return horasExtras50;
    }

    public void setHorasExtras50(int horasExtras50) {
        this.horasExtras50 = horasExtras50;
    }

    public int getHorasExtras100() {
        return horasExtras100;
    }

    public void setHorasExtras100(int horasExtras100) {
        this.horasExtras100 = horasExtras100;
    }

    public Usuario() {
    }

    public Usuario(double valorHora, int horasTrabalhadas, int horasExtras50, int horasExtras100) {
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.horasExtras50 = horasExtras50;
        this.horasExtras100 = horasExtras100;
    }

    public double salarioBase() {
        return horasTrabalhadas * valorHora;
    }

    public double salarioExtra50() {
        return horasExtras50 * valorHora * 1.5;
    }

    public double salarioExtra100() {
        return horasExtras100 * valorHora * 2;
    }

    public void salarioBruto() {
        double salarioBruto = salarioBase() + salarioExtra100() + salarioExtra50();
        System.out.println("Seu salário bruto é de R$ " + salarioBruto);
    }


}
