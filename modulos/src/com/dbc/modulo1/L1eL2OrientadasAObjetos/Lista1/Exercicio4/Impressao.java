package com.dbc.modulo1.L1eL2OrientadasAObjetos.Lista1.Exercicio4;

import java.util.Scanner;

public class Impressao {

    public static void imprimeEstado() {
        Scanner scanner = new Scanner(System.in);
        Estado estado = Estado.valueOf(scanner.next());
        switch (estado) {
            case RS -> System.out.println("POSIÇÕES DAS CIDADES NO RANKING DE PIB POR MUNICÍPIOS DO BRASIL:\n Porto Alegre: 8ª \n Caxias do Sul: 40ª");
            case SP -> System.out.println("POSIÇÕES DAS CIDADES NO RANKING DE PIB POR MUNICÍPIOS DO BRASIL:\n São Paulo(capital): 1ª \n Campinas: 11ª");
            case RJ -> System.out.println("POSIÇÕES DAS CIDADES NO RANKING DE PIB POR MUNICÍPIOS DO BRASIL:\n Rio de Janeiro(capital): 2ª \n Niterói: 27ª");
            default -> System.out.println("Você não digitou um dos 3 estados.");
        }
    }
    public static void usandoEnum(){
        Estado RS = Estado.RS;
        Estado SP = Estado.SP;
        Estado RJ = Estado.RJ;

        imprimeEstado();
    }
}
