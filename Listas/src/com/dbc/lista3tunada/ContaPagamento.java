package com.dbc.lista3tunada;

public class ContaPagamento extends Conta implements Impressao{
    private final static double TAXA_SAQUE = 4.25;

    public void imprimir() {
        getCliente().imprimirCliente();

        System.out.println("CONTA PAGAMENTO- "
                + "Agência: " + this.getAgencia()
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
}
