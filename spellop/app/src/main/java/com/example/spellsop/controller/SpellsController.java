package com.example.spellsop.controller;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.TextView;

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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SpellsController {

    private static ArrayList<Tecnica> tecnicas;
    private static Tecnica tecnica_view; // Tecnica usada para exibir os detalhes
    private static Map<String, String> estilos;
    private static Map<String, ArrayList<String>> filtros;
    public static int qntEstiloCombate = 0, qntGrau = 0, qntAlcance = 0, qntRequisito = 0, qntDuracao = 0, qntEnergia = 0;


    public static ArrayList<Tecnica> getTecnicas(){
        return tecnicas;
    }

    public static Tecnica getTecnica_view() {
        return tecnica_view;
    }

    public static void setTecnica_view(Tecnica tecnica_para_detalhe) {
        SpellsController.tecnica_view = tecnica_para_detalhe;
    }

    public static Map<String, ArrayList<String>> getFiltros(){ return filtros;}

    public static void carregaTecnicas(Context context, String[] caminho_arquivos) throws IOException {

        tecnicas = new ArrayList<>();

        AssetManager assetManager = context.getAssets();
        JSONObject jsonObject;
        JSONArray jsonArray;
        String conteudo_json;
        InputStream inputStream;
        int id, energia, grau;
        String titulo, descricao, duracao, alcance, requisito, dano, estilo;

        filtros = new HashMap<>(); // Inicia hashMap de filtros. É feito aqui pois a classe não tem contrutor e esse método é chamado assim que o programa inicia. Antes de a UI ser carregada para o usuário
        filtros.put("estilo_combate", new ArrayList<>());
        filtros.put("alcance", new ArrayList<>());
        filtros.put("requisito", new ArrayList<>());
        filtros.put("duracao", new ArrayList<>());
        filtros.put("grau", new ArrayList<>());
        filtros.put("energia", new ArrayList<>());

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

    // Métodos para ordenar tecnicas
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

    // Função para retornar todos os filtros possíveis da página de filtros
    public static ArrayList<ArrayList<String>> returnFilters(){

        ArrayList<ArrayList<String>> listaTodos = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for(Tecnica item : tecnicas){ // Insere tecnica de combate
            set.add(item.getEstilo());
        }
        listaTodos.add(new ArrayList<>(set));

        set.clear();

        for(Tecnica item : tecnicas){ // Insere Grau
            set.add(String.valueOf(item.getGrau()));
        }
        listaTodos.add(new ArrayList<>(set));

        set.clear();

        for(Tecnica item : tecnicas){ // Insere Requisito
            set.add(item.getRequisito());
        }
        listaTodos.add(new ArrayList<>(set));

        set.clear();

        for(Tecnica item : tecnicas){ // Insere Alcance
            set.add(item.getAlcance());
        }
        listaTodos.add(new ArrayList<>(set));

        set.clear();

        for(Tecnica item : tecnicas){ // Insere Duracao
            set.add(item.getDuracao());
        }
        listaTodos.add(new ArrayList<>(set));

        set.clear();

        for(Tecnica item : tecnicas){ // Insere Energia
            set.add(String.valueOf(item.getEnergia()));
        }
        listaTodos.add(new ArrayList<>(set));

        set.clear();

        return listaTodos;

    }

    // Função para atualizar as componentes da View e Filtros com base no que é selecionado nas recyclers View
    public static void atualizaItemFiltroInserido(String objeto, TextView componente, TextView componente_limpar, String item){
        if(Objects.equals(objeto, "estilo_combate")){
            qntEstiloCombate++;
            componente.setText(String.valueOf(qntEstiloCombate));
        }else if(Objects.equals(objeto, "requisito")){
            qntRequisito++;
            componente.setText(String.valueOf(qntRequisito));
        }else if(Objects.equals(objeto, "alcance")){
            qntAlcance++;
            componente.setText(String.valueOf(qntAlcance));
        }else if(Objects.equals(objeto, "duracao")){
            qntDuracao++;
            componente.setText(String.valueOf(qntDuracao));
        }else if(Objects.equals(objeto, "grau")){
            qntGrau++;
            componente.setText(String.valueOf(qntGrau));
        }else{
            qntEnergia++;
            componente.setText(String.valueOf(qntEnergia));
        }
        componente_limpar.setVisibility(TextView.VISIBLE);
        Objects.requireNonNull(filtros.get(objeto)).add(item);
    }

    public static void atualizaItemFiltroRemovido(String objeto, TextView componente, TextView componente_limpar, String item){
        if(Objects.equals(objeto, "estilo_combate")){
            qntEstiloCombate--;
            componente.setText(String.valueOf(qntEstiloCombate));
            if(qntEstiloCombate == 0){componente_limpar.setVisibility(TextView.INVISIBLE);}
        }else if(Objects.equals(objeto, "requisito")){
            qntRequisito--;
            componente.setText(String.valueOf(qntRequisito));
            if(qntRequisito == 0){componente_limpar.setVisibility(TextView.INVISIBLE);}
        }else if(Objects.equals(objeto, "alcance")){
            qntAlcance--;
            componente.setText(String.valueOf(qntAlcance));
            if(qntAlcance == 0){componente_limpar.setVisibility(TextView.INVISIBLE);}
        }else if(Objects.equals(objeto, "duracao")){
            qntDuracao--;
            componente.setText(String.valueOf(qntDuracao));
            if(qntDuracao == 0){componente_limpar.setVisibility(TextView.INVISIBLE);}
        }else if(Objects.equals(objeto, "grau")){
            qntGrau--;
            componente.setText(String.valueOf(qntGrau));
            if(qntGrau == 0){componente_limpar.setVisibility(TextView.INVISIBLE);}
        }else{
            qntEnergia--;
            componente.setText(String.valueOf(qntEnergia));
            if(qntEnergia == 0){componente_limpar.setVisibility(TextView.INVISIBLE);}
        }
        Objects.requireNonNull(filtros.get(objeto)).remove(item);
    }

    public static void limparItensFiltro(String objeto, TextView componente, TextView componente_limpar){
        if(Objects.equals(objeto, "estilo_combate")){
            qntEstiloCombate = 0;
            componente.setText(String.valueOf(qntEstiloCombate));
            componente_limpar.setVisibility(TextView.INVISIBLE);
        }else if(Objects.equals(objeto, "requisito")){
            qntRequisito = 0;
            componente.setText(String.valueOf(qntRequisito));
            componente_limpar.setVisibility(TextView.INVISIBLE);
        }else if(Objects.equals(objeto, "alcance")){
            qntAlcance = 0;
            componente.setText(String.valueOf(qntAlcance));
            componente_limpar.setVisibility(TextView.INVISIBLE);
        }else if(Objects.equals(objeto, "duracao")){
            qntDuracao = 0;
            componente.setText(String.valueOf(qntDuracao));
            componente_limpar.setVisibility(TextView.INVISIBLE);
        }else if(Objects.equals(objeto, "grau")){
            qntGrau = 0;
            componente.setText(String.valueOf(qntGrau));
            componente_limpar.setVisibility(TextView.INVISIBLE);
        }else{
            qntEnergia = 0;
            componente.setText(String.valueOf(qntEnergia));
            componente_limpar.setVisibility(TextView.INVISIBLE);
        }
        Objects.requireNonNull(filtros.get(objeto)).clear();
    }

    public static void atualizaFiltrosSelecionados(String objeto, TextView componente, TextView componente_limpar){
        if(Objects.equals(objeto, "estilo_combate")){
            componente.setText(String.valueOf(qntEstiloCombate));
        }else if(Objects.equals(objeto, "requisito")){
            componente.setText(String.valueOf(qntRequisito));
        }else if(Objects.equals(objeto, "alcance")){
            componente.setText(String.valueOf(qntAlcance));
        }else if(Objects.equals(objeto, "duracao")){
            componente.setText(String.valueOf(qntDuracao));
        }else if(Objects.equals(objeto, "grau")){
            componente.setText(String.valueOf(qntGrau));
        }else{
            componente.setText(String.valueOf(qntEnergia));
        }
        componente_limpar.setVisibility(TextView.VISIBLE);
    }

}
