package com.dbc.oo2_homework;

import org.junit.Test;

import static org.junit.Assert.*;


public class ContaTest {

    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        //arrange
        ContaCorrente contaCorrenteJeremias = new ContaCorrente();
        contaCorrenteJeremias.setSaldo(1000);
        contaCorrenteJeremias.setChequeEspecial(1000);
        //act
        boolean sacar = contaCorrenteJeremias.sacar(150);
        double saldo = contaCorrenteJeremias.getSaldo();
        //assert
        assertTrue(sacar);
        assertEquals(850, saldo, 0);


    }
}
