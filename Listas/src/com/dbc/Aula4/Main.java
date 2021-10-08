package com.dbc.Aula4;

public class Main {
    public static void main(String[] args) {
        Pessoa PessoaX = new Pessoa();
        PessoaX.setNome("João");
        PessoaX.setSobrenome("Batista");
        PessoaX.setIdade(22);
        PessoaX.setWhatsapp("999999999");

        Pessoa PessoaY = new Pessoa();
        PessoaY.setNome("Mário");
        PessoaY.setSobrenome("Armário");
        PessoaY.setIdade(13);
        PessoaY.setWhatsapp("888888888");

        PessoaX.conversar(PessoaY);
        System.out.println(PessoaX.retornarNomeCompleto());
        System.out.println(PessoaX.ehMaiorDeIdade());
        PessoaX.mandarWhatsapp(PessoaY, "Bom dia");
    }
}
