package com.dbc.Aula3;

public class Pessoa {
    String nome;
    int idade;

    public void conversar(Pessoa pessoa, String mensagem) {
        System.out.println(nome + " conversou" + mensagem + " com " + pessoa.nome);
    }

    public int diferencaIdade(Pessoa pessoa) {
        int diferenca = this.idade - pessoa.idade;
        return diferenca;
    }




}
