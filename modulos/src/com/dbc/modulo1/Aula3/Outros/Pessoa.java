package com.dbc.modulo1.Aula3.Outros;

public class Pessoa {
    String nome;
    int idade;

    public void conversar(Pessoa pessoa, String mensagem) {
        System.out.println(nome + " conversou" + mensagem + " com " + pessoa.nome);
    }

    public int diferencaIdade(Pessoa pessoa) {
        return this.idade - pessoa.idade;
    }
}
