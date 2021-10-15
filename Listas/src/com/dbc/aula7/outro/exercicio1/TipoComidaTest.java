package com.dbc.aula7.outro.exercicio1;

import org.junit.Test;

public class TipoComidaTest {
    @Test
    public void deveTestarEnum() {
        TipoComida tipoComida = TipoComida.JAPONESA;

        for(TipoComida tipo : TipoComida.values()) {
            System.out.println(tipo);
            System.out.println("ordinal: " + tipo.ordinal());
            System.out.println("descricao: " + tipo.getDescricao());
        }
    }
}
