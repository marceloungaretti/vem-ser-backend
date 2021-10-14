package com.dbc.aula6;

import org.junit.Test;

import static org.junit.Assert.*;

public class MeuTest {

    @Test
    public void deveTestarSeONumeroEhParComSucesso() {
        //setup (arrange)
        int valor = 11;

        //act
        boolean ehpar = valor % 2 == 0;

        //assert
        assertFalse(ehpar);
    }

    @Test
    public void deveTestarValorIgual() {
        Integer idade = 30;
        String porExtenso = "Maicon tem " + idade + " anos.";

        assertEquals(Integer.valueOf(30), idade);
        assertEquals("Maicon tem 30 anos.", porExtenso);
    }
}