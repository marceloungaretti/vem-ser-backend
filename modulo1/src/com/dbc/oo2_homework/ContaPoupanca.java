package com.dbc.oo2_homework;

public class ContaPoupanca extends Conta implements Impressao{
    private final static double JUROS_MENSAL = 1.01;

    public void creditarTaxa() {
        double novoSaldo = getSaldo() * JUROS_MENSAL;
        setSaldo(novoSaldo);
    }

    public void imprimir() {
        getCliente().imprimirCliente();

        System.out.println("CONTA POUPANÇA- "
                +"Agência: " + this.getAgencia()
                + " Conta: " + this.getNumeroConta()
                + " Saldo: " + this.getSaldo());
    }
}
