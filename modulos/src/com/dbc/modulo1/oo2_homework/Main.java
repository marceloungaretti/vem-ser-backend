package com.dbc.modulo1.oo2_homework;

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

        Contato contatogenerico = new Contato("99999990", "celular", 1);
        Contato contatogenerico2222 = new Contato("9999991", "celular", 1);

        Cliente joao = new Cliente();
        joao.setNome("Jõao");
        joao.setCpf("123456789-10");
        joao.getEnderecos()[0] = enderecoGenerico;
        joao.getEnderecos()[1] = enderecoGenerico2;
        joao.setContatos(contatogenerico);
        joao.setContatos(contatogenerico2222);

        var pedro = new Cliente();
        pedro.setNome("Pedro");
        pedro.setCpf("123456789-11");
        pedro.getEnderecos()[0] = enderecoGenerico;
        pedro.getEnderecos()[1] = enderecoGenerico2;
        pedro.setContatos(contatogenerico);
        pedro.setContatos(contatogenerico2222);

        //-------------------------------------------------------------------------

        var contaCorrenteJoao = new ContaCorrente();
        contaCorrenteJoao.setCliente(joao);
        contaCorrenteJoao.setAgencia("123");
        contaCorrenteJoao.setNumeroConta("121122");
        contaCorrenteJoao.setSaldo(1000);
        contaCorrenteJoao.setChequeEspecial(200);

        var contaPagamentoJoao = new ContaPagamento();
        contaPagamentoJoao.setCliente(joao);
        contaPagamentoJoao.setAgencia("123");
        contaPagamentoJoao.setNumeroConta("121123");
        contaPagamentoJoao.setSaldo(1000);

        var contaPedro = new ContaPoupanca();
        contaPedro.setCliente(pedro);
        contaPedro.setAgencia("124");
        contaPedro.setNumeroConta("989988");
        contaPedro.setSaldo(1000);

        contaCorrenteJoao.imprimir();
        contaPagamentoJoao.imprimir();
        contaPedro.imprimir();
        contaCorrenteJoao.sacar(200);
        contaPagamentoJoao.transferir(contaPedro, 50);
        contaPedro.depositar(50);
        System.out.println("------------------------------------------------");
        contaCorrenteJoao.imprimir();
        contaPagamentoJoao.imprimir();
        contaPedro.imprimir();


    }
}
