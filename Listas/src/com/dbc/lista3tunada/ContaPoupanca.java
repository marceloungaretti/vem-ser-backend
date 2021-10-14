package com.dbc.lista3tunada;

public class ContaPoupanca extends Conta implements Impressao{
    private final static double JUROS_MENSAL = 1.01;

    public void creditarTaxa() {
        double novoSaldo = getSaldo() * JUROS_MENSAL;
        setSaldo(novoSaldo);
    }

    public void imprimir() {
        getCliente().imprimirCliente();

        System.out.println("Agência: " + this.getAgencia()
                + " Conta: " + this.getNumeroConta()
                + " Saldo: " + this.getSaldo());
    }

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
}
