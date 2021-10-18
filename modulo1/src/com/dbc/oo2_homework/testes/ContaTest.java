package com.dbc.oo2_homework.testes;

import com.dbc.oo2_homework.ContaCorrente;
import com.dbc.oo2_homework.ContaPagamento;
import com.dbc.oo2_homework.ContaPoupanca;
import org.junit.Test;

import static org.junit.Assert.*;


public class ContaTest {
    ContaCorrente contaCorrenteJeremias = new ContaCorrente();
    ContaPoupanca contaPoupancaJose = new ContaPoupanca();
    ContaPagamento contaPagamentoJuvenal = new ContaPagamento();

    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        //arrange

        contaCorrenteJeremias.setSaldo(1000);
        contaCorrenteJeremias.setChequeEspecial(1000);
        //act
        boolean sacar = contaCorrenteJeremias.sacar(150);
        double saldo = contaCorrenteJeremias.getSaldo();
        //assert
        assertTrue(sacar);
        assertEquals(850, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        contaCorrenteJeremias.setSaldo(1000);
        contaCorrenteJeremias.setChequeEspecial(1000);

        boolean sacar = contaCorrenteJeremias.sacar(2100);
        double saldo = contaCorrenteJeremias.getSaldo();

        assertFalse(sacar);
        assertEquals(1000, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        contaPoupancaJose.setSaldo(1000);

        boolean sacar = contaPoupancaJose.sacar(200);
        double saldo = contaPoupancaJose.getSaldo();

        assertTrue(sacar);
        assertEquals(800, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {
        contaPoupancaJose.setSaldo(500);

        boolean sacar = contaPoupancaJose.sacar(600);

        assertFalse(sacar);
    }

    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso() {
        contaPagamentoJuvenal.setSaldo(1000);

        boolean sacar = contaPagamentoJuvenal.sacar(500);
        double saldo = contaPagamentoJuvenal.getSaldo();

        assertTrue(sacar);
        assertEquals(495.75, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo() {
        contaPagamentoJuvenal.setSaldo(200);

        boolean sacar = contaPagamentoJuvenal.sacar(300);

        assertFalse(sacar);
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso() {
        contaCorrenteJeremias.setSaldo(1000);
        contaPoupancaJose.setSaldo(1000);

        boolean transferir = contaCorrenteJeremias.transferir(contaPoupancaJose, 500);
        double saldoJeremias = contaCorrenteJeremias.getSaldo();
        double saldoJose = contaPoupancaJose.getSaldo();

        assertTrue(transferir);
        assertEquals(saldoJeremias, 500, 0);
        assertEquals(saldoJose, 1500, 0);
    }

    @Test
    public void deveTestarTransferenciaSemSaldo() {
        contaCorrenteJeremias.setSaldo(200);
        contaPoupancaJose.setSaldo(500);

        boolean transferir = contaCorrenteJeremias.transferir(contaPoupancaJose, 1000);
        double saldoJeremias = contaCorrenteJeremias.getSaldo();
        double saldoJose = contaPoupancaJose.getSaldo();

        assertFalse(transferir);
        assertEquals(saldoJeremias, 200, 0);
        assertEquals(saldoJose, 500, 0);
    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso(){
        contaCorrenteJeremias.setSaldo(500);

        boolean depositar = contaCorrenteJeremias.depositar(200);
        double saldo = contaCorrenteJeremias.getSaldo();

        assertTrue(depositar);
        assertEquals(saldo, 700, 0);
    }

    @Test
    public void deveTestarDepositoNegativo() {
        contaCorrenteJeremias.setSaldo(1000);

        boolean depositar = contaCorrenteJeremias.depositar(-150);
        double saldo = contaCorrenteJeremias.getSaldo();

        assertFalse(depositar);
        assertEquals(saldo, 1000, 0);
    }




}
