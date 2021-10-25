package com.dbc.modulo1.aula7.enums;

import org.junit.Test;

public class TipoCarroTest {

    @Test
    public void deveTestarEnum() {
        TipoCarro tipoCarro = TipoCarro.SEDAN;
        System.out.println(tipoCarro);

        for(TipoCarro tipo : TipoCarro.values()) {
            System.out.println(tipo);
            System.out.println("ordinal: " + tipo.ordinal());
            System.out.println("descricao: " + tipo.getDescricao());
        }
    }
}
