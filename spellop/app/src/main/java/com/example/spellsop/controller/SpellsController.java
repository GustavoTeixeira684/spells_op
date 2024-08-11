package com.example.spellsop.controller;

public class SpellsController {

    private static String[] lista_tecnicas;

    public static String[] getLista_tecnicas() {
        return lista_tecnicas;
    }

    public static void setLista_tecnicas(String[] arquivos){
        lista_tecnicas = arquivos;
    }

}
