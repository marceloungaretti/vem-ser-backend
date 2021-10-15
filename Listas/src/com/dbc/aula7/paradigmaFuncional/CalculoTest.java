package com.dbc.aula7.paradigmaFuncional;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculoTest {

    @Test
    public void deveTestarSoma() {

        Calculo calculoSoma = (valor1, valor2) -> valor1 + valor2;
        int valor3 = calculoSoma.calcular(10, 15);

        assertEquals(valor3, 25);
    }


    @Test
    public void deveTestarMultiplicacao() {

        Calculo calculoMult = (valor1, valor2) -> valor1 * valor2;
        int valor4 = calculoMult.calcular(10, 15);

        assertEquals(valor4, 150);
    }
}
