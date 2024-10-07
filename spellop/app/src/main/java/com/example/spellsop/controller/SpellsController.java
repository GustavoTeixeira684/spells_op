package com.example.spellsop.controller;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.TextView;

import com.example.spellsop.adapter.RecyclerSpellsAdapter;
import com.example.spellsop.model.Tecnica;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class SpellsController {

    private static ArrayList<Tecnica> tecnicas;
    private static Map<String, ArrayList<String>> filtros;
    private static HashSet<Tecnica> tecnicas_filtradas;
    private static int qntEstiloCombate = 0, qntGrau = 0, qntAlcance = 0, qntRequisito = 0, qntDuracao = 0, qntEnergia = 0;
    private static boolean temFiltro = false;
    private static RecyclerSpellsAdapter adapter;

    // ***** GETTERS E SETTERS ***** //

    public static void setAdapter(RecyclerSpellsAdapter adapt) {adapter = adapt;}
    public static RecyclerSpellsAdapter getAdapter() {return adapter;}
    public static int getQntEstiloCombate(){return qntEstiloCombate;}
    public static int getQntGrau(){return qntGrau;}
    public static int getQntAlcance(){return qntAlcance;}
    public static int getQntRequisito(){return qntRequisito;}
    public static int getQntDuracao(){return qntDuracao;}
    public static int getQntEnergia(){return qntEnergia;}
    public static ArrayList<Tecnica> getTecnicas(){
        return ordenaTecnicasPorGrau(0, tecnicas_filtradas.size(), new ArrayList<>(tecnicas_filtradas));
    }
    public static int getQuantidadeTecnicasFiltradas() {return tecnicas_filtradas.size();}
    public static Map<String, ArrayList<String>> getFiltros(){ return filtros;}

    // ***** FIM GETTERS E SETTERS ***** //

    public static ArrayList<Tecnica> getTecnicasDoEstilo(String estiloCombate){

        ArrayList<Tecnica> retorno = new ArrayList<>();
        for(Tecnica item : tecnicas){
            if(item.getEstilo().equals(estiloCombate)){
                retorno.add(item);
            }
        }

        return retorno;
    }

    public static void carregaTecnicas(Context context, String[] caminho_arquivos) {

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

        Map<String, String> estilos = new HashMap<>();
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
        tecnicas_filtradas = new HashSet<>(tecnicas);

    }

    private static String convertStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
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

    public static ArrayList<Tecnica> ordenaTecnicasPorGrau(int primeiro, int ultimo, ArrayList<Tecnica> est){

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
        insereItensFiltro(objeto, item);
        adapter.listaCompleta();
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
        removeItensFiltro(objeto);
        adapter.listaCompleta();
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

        limpaItensFiltro(objeto);
        adapter.listaCompleta();

    }

    // Método para inserir filtros
    private static void insereItensFiltro(String objeto, String valor){
        // Limpa pois quando não tem nenhum filtro mostra todos os valores
        if(!temFiltro){
            tecnicas_filtradas.clear();
            temFiltro = true;
        }
        ArrayList<Tecnica> lista_temporaria = new ArrayList<>();

        // Pegar os itens que não atendem mais ao filtro
        for(Tecnica item : tecnicas_filtradas){
            if(passivelManter(item)){
                lista_temporaria.add(item);
            }
        }

        // Retirar os itens que não atendem mais ao filtro
        for(Tecnica item : lista_temporaria){
            tecnicas_filtradas.remove(item);
        }

        // Limpa para incluir o valores novos
        lista_temporaria.clear();

        // Adicionar os itens que fazem parte do filtro em especifico (Passo necessário para reduzir os itens que serão submetidos às analises mais pesadas
        for(Tecnica item : tecnicas){
            if(normalizado(valor).equals(normalizado(item.getAtributoTecnica(objeto)))){
                lista_temporaria.add(item);
            }
        }

        // Aplica os filtros "mais pesados" em baixo nivel para a amostra que está na variavel lista_temporaria
        for(Tecnica item : lista_temporaria){
            if(passivelInsert(item, objeto)){
                tecnicas_filtradas.add(item);
            }
        }
        lista_temporaria.clear();

    }

    // PARA O ESTILO DE COMBATE DEVE ESTAR FUNCIONANDO. MAS REESCREVER PARA EVITAR TANTA REDUNDANCIA DE CODIGO
    public static void removeItensFiltro(String objeto){
        if(countTotalItensFiltro() == 0){
            tecnicas_filtradas = new HashSet<>(tecnicas);
            temFiltro = false;
        }else{
            if(Objects.requireNonNull(filtros.get(objeto)).isEmpty()){
                // O que frazer se não tiver mais nenhum filtro da categoria
                for(Tecnica item : tecnicas){
                    if(passivelInsert(item, objeto)){
                        tecnicas_filtradas.add(item);
                    }
                }
            }else{
                // O que fazer se ainda houver algum filtro nessa categoria
                ArrayList<Tecnica> lista_temporaria = new ArrayList<>();
                for(Tecnica item : tecnicas_filtradas){
                    if(passivelManter(item)){
                        lista_temporaria.add(item);

                    }
                }
                for(Tecnica item : lista_temporaria){
                    tecnicas_filtradas.remove(item);
                }
                lista_temporaria.clear();
            }
        }
    }

    private static void limpaItensFiltro(String objeto){
        ArrayList<String> lista_excuir = new ArrayList<>(Objects.requireNonNull(filtros.get(objeto)));

        for(String valor : lista_excuir){
            Objects.requireNonNull(filtros.get(objeto)).remove(valor);
            removeItensFiltro(objeto);
        }

    }

    // Método para ver se podemos manter o objeto no filtro
    private static boolean passivelManter(Tecnica item){
        boolean possui;

        // Captura chaves
        for(String chave : filtros.keySet()){
            if(!Objects.requireNonNull(filtros.get(chave)).isEmpty()){
                possui = false;
                for(String valor : Objects.requireNonNull(filtros.get(chave))){
                    if(normalizado(item.getAtributoTecnica(chave)).equals(normalizado(valor))){
                        possui = true;
                        break;
                    }
                }
                if(!possui){
                    return true;
                }
            }
        }
        return false;
    }

    // Método para ver se podemos inserir o item na lista
    private static boolean passivelInsert(Tecnica item, String objeto){
        boolean possui;

        // Captura as outras chaves
        for(String chave : filtros.keySet()){
            if(!chave.equals(objeto) && !Objects.requireNonNull(filtros.get(chave)).isEmpty()){
                possui = false;
                for(String valor : Objects.requireNonNull(filtros.get(chave))){
                    if(normalizado(item.getAtributoTecnica(chave)).equals(normalizado(valor))){
                        possui = true;
                        break;
                    }
                }
                if(!possui){
                    return false;
                }
            }
        }
        return true;
    }

    // Função para trazer o total de quantidade dos itens selecionados para o filtro
    private static int countTotalItensFiltro(){
        int quantidade = 0;
        for(String chave : filtros.keySet()){
            quantidade += Objects.requireNonNull(filtros.get(chave)).size();
        }
        return quantidade;
    }

    private static String normalizado(String valor){
        return Normalizer.normalize(valor, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();
    }

    public static Tecnica buscaTecnicaEstiloCombate(int id, String estilo){
        for(Tecnica tecnica : tecnicas){
            if(tecnica.getEstilo().equals(estilo) && tecnica.getId() == id){
                return tecnica;
            }
        }
        return null;
    }

}
