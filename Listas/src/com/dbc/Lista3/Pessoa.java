package com.dbc.Lista3;

public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    String whatsapp;

    public void conversar(Pessoa pessoa) {
        System.out.println(nome + " conversou com " + pessoa.nome);
    }

    public String retornarNomeCompleto() {
        return nome + " " + sobrenome;
    }

    public boolean ehMaiorDeIdade() {
        return this.idade >= 18;
    }

    public void mandarWhatsapp(Pessoa pessoa, String mensagem) {
        System.out.println(nome + " enviou: " + mensagem + " para " + pessoa.nome);
    }

}
