package com.dbc.modulo2.L1eL2OrientadasAObjetos.Lista1.Exercicio3;

public class Pedido {
    private double valorDoPedido;
    private double valorPago;

    public double getValorDoPedido() {
        return valorDoPedido;
    }

    public void setValorDoPedido(double valorDoPedido) {
        this.valorDoPedido = valorDoPedido;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Pedido() {
    }

    public Pedido(double valorDoPedido, double valorPago) {
        this.valorDoPedido = valorDoPedido;
        this.valorPago = valorPago;
    }

    public double calcularTroco() {
        double troco = valorPago - valorDoPedido;
        return troco;
    }
}
