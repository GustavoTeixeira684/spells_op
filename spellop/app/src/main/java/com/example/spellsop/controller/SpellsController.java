package com.example.spellsop.controller;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.spellsop.model.Tecnica;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SpellsController {

    private static ArrayList<Tecnica> tecnicas;
    public static ArrayList<Tecnica> getTecnicas(){
        return tecnicas;
    }
    private static Tecnica tecnica_view;



    public static void carregaTecnicas(Context context, String[] caminho_arquivos) throws IOException {

        tecnicas = new ArrayList<Tecnica>();
        List<String> conteudoJson = new ArrayList<>();
        AssetManager assetManager = context.getAssets();
        JSONObject jsonObject;
        JSONArray jsonArray;
        String conteudo_json;
        InputStream inputStream;
        int id, energia, grau;
        String titulo, descricao, duracao, alcance, requisito, dano;

        for(String arquivo : caminho_arquivos){

            try{

                inputStream = assetManager.open(arquivo);
                conteudo_json = convertStreamToString(inputStream);
                jsonArray = new JSONArray(conteudo_json);

                for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                    id = jsonObject.getInt("id");
                    titulo = jsonObject.getString("titulo");
                    descricao = jsonObject.getString("descricao");
                    energia = jsonObject.getInt("energia");
                    duracao = jsonObject.getString("duracao");
                    alcance = jsonObject.getString("alcance");
                    requisito = jsonObject.getString("requisito");
                    dano = jsonObject.getString("dano");
                    grau = jsonObject.getInt("grau");

                    tecnicas.add(new Tecnica(id, titulo, descricao, energia, duracao, alcance, requisito, dano, grau, arquivo.replace("tecnicas/","").replace(".json","")));
                    Log.d("",arquivo);

                }

            }catch (IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private static String convertStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }


    public static Tecnica getTecnica_view() {
        return tecnica_view;
    }

    public static void setTecnica_view(Tecnica tecnica_para_detalhe) {
        SpellsController.tecnica_view = tecnica_para_detalhe;
    }
}
