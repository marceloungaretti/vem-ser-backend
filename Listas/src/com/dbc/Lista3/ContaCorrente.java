package com.dbc.Lista3;

public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    public void imprimirContaCorrente() {
        cliente.imprimirCliente();

        System.out.println("Agência: " + this.agencia
                + " Conta: " + this.numeroConta
                + " Saldo: " + this.saldo
                + " Limite Cheque Especial: " + this.chequeEspecial + "\n");
    }

    public boolean sacar (double valor) {
        if (this.retornarSaldoComChequeEspecial() >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean depositar (double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    public double retornarSaldoComChequeEspecial() {
        return (saldo + chequeEspecial);
    }

    public boolean transferir(ContaCorrente contaDestino, double valor) {
        if (valor > 0 && this.saldo >= valor) {
            contaDestino.depositar(valor);
            this.sacar(valor);
            return true;
        }
        return false;
    }
}
