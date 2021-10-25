package com.dbc.modulo1.oo2_homework;

public interface Movimentacao {
    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(Conta conta, double valor);


}
