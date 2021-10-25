package com.dbc.modulo1.Aula3;

public class Main {
    public static void main(String[] args) {
        Pessoa PessoaX = new Pessoa();
        PessoaX.nome = "João";
        PessoaX.sobrenome = "Batista";
        PessoaX.idade = 22;
        PessoaX.whatsapp = "999999999";

        Pessoa PessoaY = new Pessoa();
        PessoaY.nome = "Mário";
        PessoaY.sobrenome = "Armário";
        PessoaY.idade = 13;
        PessoaY.whatsapp = "888888888";

        PessoaX.conversar(PessoaY);
        System.out.println(PessoaX.retornarNomeCompleto());
        System.out.println(PessoaX.ehMaiorDeIdade());
        PessoaX.mandarWhatsapp(PessoaY, "Bom dia");
    }
}
