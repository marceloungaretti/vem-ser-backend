package com.dbc.L1eL2OrientadasAObjetos.Lista1.Exercicio4;

public class EstadoClass {
    Estado estado;

    public EstadoClass(Estado estado) {
        this.estado = estado;
    }

    public void getEstado() {
        switch (estado) {
            case RS:
                System.out.println("POSIÇÕES DAS CIDADES NO RANKING DE PIB POR MUNICÍPIOS DO BRASIL:\n Porto Alegre: 8ª \n Caxias do Sul: 40ª");
                break;

            case SP:
                System.out.println("POSIÇÕES DAS CIDADES NO RANKING DE PIB POR MUNICÍPIOS DO BRASIL:\n São Paulo(capital): 1ª \n Campinas: 11ª");
                break;

            case RJ:
                System.out.println("POSIÇÕES DAS CIDADES NO RANKING DE PIB POR MUNICÍPIOS DO BRASIL:\n Rio de Janeiro(capital): 2ª \n Niterói: 27ª");
                break;

            default:
                System.out.println("Você não digitou um dos 3 estados.");
                break;
        }
    }

}

