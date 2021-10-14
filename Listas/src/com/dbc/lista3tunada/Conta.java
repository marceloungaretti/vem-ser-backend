package com.dbc.lista3tunada;

public abstract class Conta implements Movimentacao{
    Cliente cliente;
    String numeroConta;
    String agencia;
    double saldo;

    private Cliente getCliente() {
        return cliente;
    }

    private  void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private  String getNumeroConta() {
        return numeroConta;
    }

    private  void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    private  String getAgencia() {
        return agencia;
    }

    private  void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    private  double getSaldo() {
        return saldo;
    }

    private  void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    @Override
    public boolean sacar(double valor) {
        return false;
    }

    @Override
    public boolean depositar(double valor) {
        return false;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        return false;
    }
}
