package com.dbc.pessoaapi.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {
    @Test
    public void testLombok() {
        var pessoa = new PessoaEntity();
        pessoa.setNome("Maicon");
        pessoa.setIdPessoa(1);
        pessoa.setDataNascimento(LocalDate.of(1991,9,8));
        pessoa.setCpf("13245678910");
        System.out.println(pessoa);
        assertEquals("Maicon", pessoa.getNome());
    }
}