package com.dbc.modulo1.oo2_homework;

public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente() {
    }

    public Cliente(String nome, String cpf, Contato contatos, Endereco enderecos) {
        this.setNome(nome);
        this.setCpf(cpf);
        Contato c = contatos;
        Endereco e = enderecos;
    }

    public void imprimirContatos() {
        for(Contato item : this.contatos) {
            item.imprimirContato();
        }
    }

    public void imprimirEnderecos() {
        for(Endereco endereco : this.enderecos) {
            endereco.imprimirEndereco(enderecos);
        }
    }

    public void imprimirCliente() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF:" + this.cpf + "\n");
        this.imprimirContatos();
        this.imprimirEnderecos();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato contatos) {
        if (this.contatos[0] == null) {
            this.contatos[0] = contatos;
        }
        this.contatos[1] = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco enderecos) {
        if (this.enderecos[0] == null) {
        this.enderecos[0] = enderecos;
        }
        this.enderecos[1] = enderecos;
    }
}
