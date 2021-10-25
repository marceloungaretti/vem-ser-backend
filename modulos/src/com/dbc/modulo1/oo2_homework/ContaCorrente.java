package com.dbc.modulo1.oo2_homework;

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

        System.out.println("CONTA CORRENTE- "
                + "Agência: " + this.getAgencia()
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


    public double retornarSaldoComChequeEspecial() {
        return (getSaldo() + chequeEspecial);
    }
}
