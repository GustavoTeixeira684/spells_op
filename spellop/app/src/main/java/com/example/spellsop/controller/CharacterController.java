package com.example.spellsop.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Pair;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;

import com.example.spellsop.model.Personagem;
import com.example.spellsop.model.Tecnica;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CharacterController {

    private static ArrayList<Personagem> personagens;
    private static ArrayList<Pair<String, String>> especies;
    private static ArrayList<String> proeficiencias;
    public static ArrayList<ArrayList<String>> ataques;
    @SuppressLint("StaticFieldLeak")
    public static AutoCompleteTextView txtProeficienciaCadastro;

    // GETTERS E SETTERS
    public static ArrayList<Personagem> getPersonagens(){
        return personagens;
    }
    public static ArrayList<Pair<String, String>> getEspecies(){ return especies;}
    public static ArrayList<String> getProeficiencias(){return proeficiencias;}

    public static void carregaPersonagens(Context context) throws IOException, JSONException {

        personagens = new ArrayList<>();
        especies = getListaEspecies();
        proeficiencias = new ArrayList<>();
        ataques = new ArrayList<>();
        File diretorio = new File(context.getFilesDir(), "personagens");
        File diretorioJson = new File(context.getFilesDir(), "personagens/json");
        File diretorioImagens = new File(context.getFilesDir(), "personagens/imagens");
        File arquivo_personagem = null;
        FileInputStream inputStream;
        BufferedReader bufferedReader;
        StringBuilder stringBuilder;
        String linha;
        ArrayList<String> arquivos_personagens = new ArrayList<>();


        if(!diretorio.exists() || !diretorio.isDirectory()){ // Cria o diretório caso seja a primeira vez do usuário e ele ainda não exista
            diretorio.mkdir();
            diretorioJson.mkdir();
            diretorioImagens.mkdir();
        }else{ // Caso o diretório ja exista, lê todos os personagens do usuário
            String[] arquivos = diretorioJson.list();
            assert arquivos != null;
            // Garante que está lendo apenas os json (Para caso o usuário tenha root no celular e seja um cabaço
            for(String arquivo : arquivos){
                if(arquivo.toLowerCase().contains(".json")){
                    arquivos_personagens.add(arquivo);
                }
            }

            for(String arquivo : arquivos_personagens){
                arquivo_personagem = new File(context.getFilesDir(), "personagens/json/"+arquivo);
                inputStream = new FileInputStream(arquivo_personagem);
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                stringBuilder = new StringBuilder();
                while((linha = bufferedReader.readLine()) != null){
                    stringBuilder.append(linha);
                }
                bufferedReader.close();
                inputStream.close();
                inserePersonagemNaClasse(stringBuilder.toString(), context);

            }

        }

    }

    private static void inserePersonagemNaClasse(String arquivo, Context context) throws JSONException {

        JSONObject jsonObject = new JSONObject(arquivo);
        JSONObject jsonTemp;
        JSONArray jsonArray;
        String nome, especie, antecedente, estiloCombate, profissao, dadosVida, individualidade, defeito, codigoHonra, habilidadesBasicas, equipamentos, outros, alcunha, sonho, caminho, cargo, detalhesProfissao, detalhesTreinamento, hakiObservacao, hakiArmamento, hakiRei, akumaNoMi, nomeImagem;
        int nivel, experiencia, valorForca, valorDestreza, valorConstituicao, valorSabedoria, valorPresenca, valorVontade, classeResistencia, valorProeficiencia, deslocamento, pvMax, pvAtual, pvTemp, ppMax, ppAtual, qntTripulacao, idade;
        double cash, altura, peso;
        ArrayList<String> proeficiencias, ataques_temp;
        ArrayList<Tecnica> tecnicas;
        ArrayList<ArrayList<String>> ataques;
        Bitmap imagemPersonagem = null;

        Map<String, String> estilos = getStringStringMap();

        nome = jsonObject.getString("nome");
        especie = jsonObject.getString("especie");
        antecedente = jsonObject.getString("antecedente");
//        estiloCombate = jsonObject.getString("estilocombate");
        estiloCombate = estilos.get(jsonObject.getString("estilocombate")); // Usado para padronização
        profissao = jsonObject.getString("profissao");
        nivel = Integer.parseInt(jsonObject.getString("nivel"));
        experiencia = Integer.parseInt(jsonObject.getString("experiencia"));
        valorForca = Integer.parseInt(jsonObject.getString("valorforca"));
        valorDestreza = Integer.parseInt(jsonObject.getString("valordestreza"));
        valorConstituicao = Integer.parseInt(jsonObject.getString("valorconstituicao"));
        valorSabedoria = Integer.parseInt(jsonObject.getString("valorsabedoria"));
        valorPresenca = Integer.parseInt(jsonObject.getString("valorpresenca"));
        valorVontade = Integer.parseInt(jsonObject.getString("valorvontade"));
        jsonArray = jsonObject.getJSONArray("proeficiencias");
        proeficiencias = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            proeficiencias.add(jsonArray.getString(i));
        }
        classeResistencia = Integer.parseInt(jsonObject.getString("classeresistencia"));
        valorProeficiencia = Integer.parseInt(jsonObject.getString("proeficiencia"));
        deslocamento = Integer.parseInt(jsonObject.getString("deslocamento"));
        pvMax = Integer.parseInt(jsonObject.getString("pvmax"));
        pvAtual = Integer.parseInt(jsonObject.getString("pvatual"));
        pvTemp = Integer.parseInt(jsonObject.getString("pvtemp"));
        dadosVida = jsonObject.getString("dadosvida");

        jsonArray = jsonObject.getJSONArray("ataques");
        ataques = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            jsonTemp = jsonArray.getJSONObject(i);
            ataques_temp = new ArrayList<>();
            ataques_temp.add(jsonTemp.getString("nome"));
            ataques_temp.add(jsonTemp.getString("bonusacerto"));
            ataques_temp.add(jsonTemp.getString("alcance"));
            ataques_temp.add(jsonTemp.getString("dano"));
            ataques.add(ataques_temp);
        }

        jsonArray = jsonObject.getJSONArray("tecnicas");
        tecnicas = new ArrayList<>();
        Tecnica temp;
        for(int i = 0; i < jsonArray.length(); i++){
            temp = SpellsController.buscaTecnicaEstiloCombate(Integer.parseInt(jsonArray.getString(i)), estiloCombate);
            if(temp != null){
                tecnicas.add(temp);
                temp = null;
            }
        }
        ppMax = Integer.parseInt(jsonObject.getString("ppmax"));
        ppAtual = Integer.parseInt(jsonObject.getString("ppatual"));
        individualidade = jsonObject.getString("individualidade");
        defeito = jsonObject.getString("defeito");
        codigoHonra = jsonObject.getString("codigohonra");
        habilidadesBasicas = jsonObject.getString("habilidadesbasicas");
        equipamentos = jsonObject.getString("equipamentos");
        outros = jsonObject.getString("outros");
        cash = Double.parseDouble(jsonObject.getString("cash"));
        alcunha = jsonObject.getString("alcunha");
        sonho = jsonObject.getString("sonho");
        caminho = jsonObject.getString("caminho");
        qntTripulacao = Integer.parseInt(jsonObject.getString("qnttripulacao"));
        cargo = jsonObject.getString("cargo");
        altura = Double.parseDouble(jsonObject.getString("altura"));
        peso = Double.parseDouble(jsonObject.getString("peso"));
        idade = Integer.parseInt(jsonObject.getString("idade"));
        detalhesProfissao = jsonObject.getString("detalhesprofissao");
        detalhesTreinamento = jsonObject.getString("detalhestreinamento");
        hakiObservacao = jsonObject.getString("hakiobservacao");
        hakiArmamento = jsonObject.getString("hakiarmamento");
        hakiRei = jsonObject.getString("hakirei");
        akumaNoMi = jsonObject.getString("akumanomi");
        nomeImagem = jsonObject.getString("imagem");

        // Lendo imagem
//        File diretorioImagem = new File(context.getFilesDir(), "personagens/imagens");
        File arquivoImagem = new File(context.getFilesDir(), "personagens/imagens/"+nomeImagem);
        if(arquivoImagem.exists()){
            imagemPersonagem = BitmapFactory.decodeFile(arquivoImagem.getAbsolutePath());
        }

        // Insere personagem
        personagens.add(
                new Personagem(nome, especie, antecedente, estiloCombate,profissao,
                        nivel, experiencia, valorForca, valorDestreza, valorConstituicao,
                        valorSabedoria, valorPresenca, valorVontade, proeficiencias,
                        classeResistencia, valorProeficiencia, deslocamento, pvMax, pvAtual,
                        pvTemp, dadosVida, ataques, tecnicas, ppMax, ppAtual, individualidade,
                        defeito, codigoHonra, habilidadesBasicas, equipamentos, outros, cash,
                        alcunha, sonho, caminho, qntTripulacao, cargo, altura, peso, idade,
                        detalhesProfissao, detalhesTreinamento, hakiObservacao, hakiArmamento,
                        hakiRei, akumaNoMi, imagemPersonagem)
        );

    }

    private static @NonNull ArrayList<Pair<String, String>> getListaEspecies(){
        ArrayList<Pair<String, String>> especies = new ArrayList<>();
        especies.add(new Pair<>("anao", "Anão"));
        especies.add(new Pair<>("celestial", "Celestial"));
        especies.add(new Pair<>("gigante", "Gigante"));
        especies.add(new Pair<>("homem_peixe", "Homem-Peixe"));
        especies.add(new Pair<>("humano", "Humano"));
        especies.add(new Pair<>("kuja", "Kuja"));
        especies.add(new Pair<>("lunariano", "Lunariano"));
        especies.add(new Pair<>("meio_homem_pexe", "Meio Homem-Peixe"));
        especies.add(new Pair<>("mink", "Mink"));
        especies.add(new Pair<>("sireno", "Sireno"));
        return especies;
    }

    private static @NonNull Map<String, String> getStringStringMap() {
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
        return estilos;
    }

    public static void setSelectedProeficiencia(String proeficiencia){
        proeficiencias.add(normalizado(proeficiencia));
        atualizaProeficienciasCadastro();
    }

    public static void removeSelectedProeficiencia(String proeficiencia){
        proeficiencias.remove(normalizado(proeficiencia));
        atualizaProeficienciasCadastro();
    }

    private static void atualizaProeficienciasCadastro(){
        txtProeficienciaCadastro.setText(listToString(proeficiencias));
    }

    private static String listToString(ArrayList<String> lista){
        StringBuilder retorno = new StringBuilder();
        for(String item : lista){
            retorno.append(item).append(";");
        }
        return retorno.toString();
    }

    private static String normalizado(String valor){
        return Normalizer.normalize(valor, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();
    }

}
