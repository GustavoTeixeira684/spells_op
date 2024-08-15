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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellsController {

    private static ArrayList<Tecnica> tecnicas;
    private static Tecnica tecnica_view;
    private static Map<String, String> estilos;

    public static ArrayList<Tecnica> getTecnicas(){
        return tecnicas;
    }

    public static Tecnica getTecnica_view() {
        return tecnica_view;
    }

    public static void setTecnica_view(Tecnica tecnica_para_detalhe) {
        SpellsController.tecnica_view = tecnica_para_detalhe;
    }

    public static void carregaTecnicas(Context context, String[] caminho_arquivos) throws IOException {

        tecnicas = new ArrayList<Tecnica>();
        List<String> conteudoJson = new ArrayList<>();
        AssetManager assetManager = context.getAssets();
        JSONObject jsonObject;
        JSONArray jsonArray;
        String conteudo_json;
        InputStream inputStream;
        int id, energia, grau;
        String titulo, descricao, duracao, alcance, requisito, dano, estilo;

        estilos = new HashMap<>();
        estilos.put("arqueiro","Arqueiro");
        estilos.put("carateca_homem_peixe","Carateca Homem-Peixe");
        estilos.put("ciborgue","Ciborgue");
        estilos.put("combatente","Combatente");
        estilos.put("estilingueiro","Estilingueiro");
        estilos.put("guerreiro_oni","Guerreiro Oni");
        estilos.put("guerrilheiro","Guerrilheiro");
        estilos.put("hasshoken","Hasshoken");
        estilos.put("lutador","Lutador");
        estilos.put("ninja","Ninja");
        estilos.put("okama_kenpo","Okama Kenpo");
        estilos.put("rokushiki","Rokushiki");
        estilos.put("ryusoken","Ryusoken");
        estilos.put("sulong","Sulong");
        estilos.put("espadachim","Espadachim");

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
                    estilo = estilos.get(arquivo.replace("tecnicas/","").replace(".json",""));
                    tecnicas.add(new Tecnica(id, titulo, descricao, energia, duracao, alcance, requisito, dano, grau, estilo));
                }

            }catch (IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        }
        tecnicas = ordenaTecnicasPorGrau();

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

    private static ArrayList<Tecnica> ordenaTecnicasPorGrau(){
        return ordenaTecnicasPorGrau(0, tecnicas.size(), tecnicas);
    }

    private static ArrayList<Tecnica> ordenaTecnicasPorGrau(int primeiro, int ultimo, ArrayList<Tecnica> est){

        if(primeiro < ultimo-1) {
            ArrayList<Tecnica> temp = new ArrayList<>();
            ArrayList<Tecnica> temp1;
            ArrayList<Tecnica> temp2;
            int meio = ((int) Math.floor(primeiro + (double) (ultimo - primeiro) / 2));
            int i = 0, j = 0;

            temp1 = ordenaTecnicasPorGrau(primeiro, meio, est);
            temp2 = ordenaTecnicasPorGrau(meio, ultimo, est);

            while (i < temp1.size() && j < temp2.size()) {
                if (temp1.get(i).getGrau() <= temp2.get(j).getGrau()) {
                    temp.add(temp1.get(i));
                    i++;
                } else {
                    temp.add(temp2.get(j));
                    j++;
                }
            }
            while (i < temp1.size()) {
                temp.add(temp1.get(i));
                i++;
            }
            while (j < temp2.size()) {
                temp.add(temp2.get(j));
                j++;
            }
            temp1 = null;
            temp2 = null;
            return temp;
        }
        ArrayList<Tecnica> singleElement = new ArrayList<>();
        singleElement.add(est.get(primeiro));
        return singleElement;
    }
}
