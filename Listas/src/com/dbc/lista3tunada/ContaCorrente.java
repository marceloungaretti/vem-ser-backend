package com.dbc.lista3tunada;

public class ContaCorrente extends Conta{
    double chequeEspecial;

    public void imprimirContaCorrente() {
        cliente.imprimirCliente();

        System.out.println("Agência: " + this.agencia
                + " Conta: " + this.numeroConta
                + " Saldo: " + this.saldo
                + " Limite Cheque Especial: " + this.chequeEspecial + "\n");
    }

    @Override
    public boolean sacar (double valor) {
        if (this.retornarSaldoComChequeEspecial() >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
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

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (valor > 0 && this.saldo >= valor) {
            conta.depositar(valor);
            this.sacar(valor);
            return true;
        }
        return false;
    }
}
