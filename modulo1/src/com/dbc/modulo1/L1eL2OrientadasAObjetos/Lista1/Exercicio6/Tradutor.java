package com.dbc.modulo2.L1eL2OrientadasAObjetos.Lista1.Exercicio6;

public class Tradutor {
    String palavra;

    public Tradutor(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public void traduzir() {
        switch (palavra) {
            case "Cachorro" -> System.out.println("Dog");
            case "Dog" -> System.out.println("Cachorro");
            case "Tempo" -> System.out.println("Time");
            case "Time" -> System.out.println("Tempo");
            case "Amor" -> System.out.println("Love");
            case "Love" -> System.out.println("Amor");
            case "Cidade" -> System.out.println("City");
            case "City" -> System.out.println("Cidade");
            case "Feliz" -> System.out.println("Happy");
            case "Happy" -> System.out.println("Feliz");
            default -> System.out.println("Esta palavra não é válida.");
        }
    }


}
