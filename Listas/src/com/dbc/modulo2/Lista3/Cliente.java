package com.dbc.modulo2.Lista3;

public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public Cliente() {
    }

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {
        for(Contato item : this.contatos) {
            item.imprimirContato();
        }
    }

    public void imprimirEnderecos() {
        for(Endereco endereco : this.enderecos) {
            endereco.imprimirEndereco();
        }
    }

    public void imprimirCliente() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF:" + this.cpf + "\n");
        this.imprimirContatos();
        this.imprimirEnderecos();
    }
}
