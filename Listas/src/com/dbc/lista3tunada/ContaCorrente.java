package com.dbc.lista3tunada;

public class ContaCorrente extends Conta implements Impressao{
    private double chequeEspecial;

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimir() {
        getCliente().imprimirCliente();

        System.out.println("Agência: " + this.getAgencia()
                + " Conta: " + this.getNumeroConta()
                + " Saldo: " + this.getSaldo()
                + " Limite Cheque Especial: " + this.getChequeEspecial() + "\n");
    }

    @Override
    public boolean sacar (double valor) {
        if (this.retornarSaldoComChequeEspecial() >= valor) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar (double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            return true;
        }
        return false;
    }

    public double retornarSaldoComChequeEspecial() {
        return (getSaldo() + chequeEspecial);
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
}