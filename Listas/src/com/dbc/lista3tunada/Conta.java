package com.dbc.lista3tunada;

public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    @Override
    public boolean sacar(double valor) {
        if (this.getSaldo() > valor) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (valor > 0 && conta.getSaldo() >= valor) {
            conta.depositar(valor);
            this.sacar(valor);
            return true;
        }
        return false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}