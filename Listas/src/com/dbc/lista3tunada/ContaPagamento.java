package com.dbc.lista3tunada;

public class ContaPagamento extends Conta implements Impressao{
    private final static double TAXA_SAQUE = 4.25;

    public void imprimir() {
        getCliente().imprimirCliente();

        System.out.println("Agência: " + this.getAgencia()
                + " Conta: " + this.getNumeroConta()
                + " Saldo: " + this.getSaldo());
    }

    @Override
    public boolean sacar(double valor) {
        if (this.getSaldo() > valor + TAXA_SAQUE) {
            setSaldo(getSaldo() - valor - TAXA_SAQUE);
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
