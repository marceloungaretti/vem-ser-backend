package com.dbc.Aula4;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private String whatsapp;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }


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
