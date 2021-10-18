package com.dbc.modulo2.aula6;

import java.util.HashMap;
import java.util.Map;

public class Mapa {
    public static void main(String[] args) {
        //put(chave, valor)
        //remove(chave)
        //get(chave)

        Map<String, String> pessoasPorCPF = new HashMap<>();
        pessoasPorCPF.put("33244423212", "Jõao da Silva");
        pessoasPorCPF.put("33334576782", "Pedro José");
        pessoasPorCPF.put("33776884322", "Henrique de Souza");

        System.out.println(pessoasPorCPF);
        String valor = pessoasPorCPF.get("33334576782");
        System.out.println(valor);
        pessoasPorCPF.put("223232545478", "Marcelo Santos");
        System.out.println(pessoasPorCPF);
        pessoasPorCPF.remove("33244423212");
        System.out.println(pessoasPorCPF);


    }
}
