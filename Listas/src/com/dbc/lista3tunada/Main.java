package com.dbc.lista3tunada;

public class Main {
    public static void main(String[] args) {

        Endereco enderecoGenerico = new Endereco(1,
                "Rua das Galinhas",
                12,
                "Casa",
                "9090900",
                "Rio de Janeiro",
                "RJ",
                "Brasil");

        Endereco enderecoGenerico2 = new Endereco(1,
                "Rua dos Patos",
                12,
                "Casa",
                "9090900",
                "Rio de Janeiro",
                "RJ",
                "Brasil");

        Contato contatogenerico = new Contato();
        Contato contatogenerico2222 = new Contato();

        Cliente joao = new Cliente();
        joao.setNome("Jõao");
        joao.setCpf("123456789-10");
        joao.setEnderecos(enderecoGenerico);
        joao.setEnderecos(enderecoGenerico2);
        joao.setContatos(contatogenerico);
        joao.setContatos(contatogenerico2222);
        joao.imprimirEnderecos();
        joao.imprimirContatos();

        var pedro = new Cliente();
        pedro.setNome("Pedro");
        pedro.setCpf("123456789-11");
        pedro.setEnderecos(enderecoGenerico);
        pedro.setEnderecos(enderecoGenerico2);
        pedro.setContatos(contatogenerico);
        pedro.setContatos(contatogenerico2222);
        pedro.imprimirEnderecos();
        pedro.imprimirContatos();

        //-------------------------------------------------------------------------

        var contaJoao = new ContaCorrente();
        contaJoao.cliente = joao;
        contaJoao.agencia = "123";
        contaJoao.numeroConta = "12112";
        contaJoao.saldo = 450;
        contaJoao.chequeEspecial = 1000;

        var contaPedro = new ContaCorrente();
        contaPedro.cliente = pedro;
        contaPedro.agencia = "124";
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
