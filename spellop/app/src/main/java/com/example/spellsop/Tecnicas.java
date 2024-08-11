package com.example.spellsop;

import java.util.HashMap;

public class Tecnicas {

    private static HashMap<String, Tecnica> map_tecnicas = new HashMap<>();
    private static String[] arquivos;

    public static void setArquivos(String[] arquivo){
        arquivos = arquivo;
    }

    public static String[] getArquivos(){
        return arquivos;
    }

    public static boolean fillByJson(){

        try{
            //String[] files = assetManager.list()

        }catch (Exception e){
            return false;
        }
        return true;
    }


}
