package com.dbc.modulo2.Lista3;

public class Main {
    public static void main(String[] args) {

        var enderecoGenerico = new Endereco();
        enderecoGenerico.cep = "9090900";
        enderecoGenerico.cidade = "Rio de Janeiro";
        enderecoGenerico.estado = "RJ";
        enderecoGenerico.logradouro = "Rua das Galinhas";
        enderecoGenerico.numero = 12;
        enderecoGenerico.complemento = "Casa";
        enderecoGenerico.pais = "BRA";
        enderecoGenerico.tipo = 1;

        var contatoGenerico = new Contato();
        contatoGenerico.descricao = "Celular";
        contatoGenerico.telefone = "55-989990005";
        contatoGenerico.tipo = 1;

        var joao = new Cliente();
        joao.nome = "João Batista";
        joao.cpf = "123456789-10";
        joao.enderecos[0] = enderecoGenerico;
        joao.contatos[0] = contatoGenerico;
        joao.enderecos[1] = enderecoGenerico;
        joao.contatos[1] = contatoGenerico;

        var pedro = new Cliente();
        pedro.nome = "Pedro Cardoso";
        pedro.cpf = "123456789-11";
        pedro.enderecos[0] = enderecoGenerico;
        pedro.contatos[0] = contatoGenerico;
        pedro.enderecos[1] = enderecoGenerico;
        pedro.contatos[1] = contatoGenerico;

        var maicon = new Cliente("Maicon", "2313123123", new Contato[442124], new Endereco[2]);

        var contaJoao = new ContaCorrente();
        contaJoao.cliente = joao;
        contaJoao.agencia = 123;
        contaJoao.numeroConta = "12112";
        contaJoao.saldo = 450;
        contaJoao.chequeEspecial = 1000;

        var contaPedro = new ContaCorrente();
        contaPedro.cliente = pedro;
        contaPedro.agencia = 124;
        contaPedro.numeroConta = "998988";
        contaPedro.saldo = 200;
        contaPedro.chequeEspecial = 500;


        contaJoao.depositar(100);

        contaPedro.cliente = pedro;

        contaJoao.transferir(contaPedro, 50);
        contaJoao.imprimirContaCorrente();
        contaPedro.imprimirContaCorrente();

    }
}
