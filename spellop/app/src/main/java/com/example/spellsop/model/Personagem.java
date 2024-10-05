package com.example.spellsop.model;

import static java.lang.Math.floor;

import android.graphics.Bitmap;
import android.util.Pair;

import java.util.ArrayList;

public class Personagem {

    private int id;
    private String nome;
    private String especie;
    private String antecedente;
//    private ArrayList<String> estiloCombate; INCLUIR NA PROXIMA VERSAO
    private String estiloCombate;
    private String profissao;
    private int nivel;
    private long experiencia;
    private int valorForca;
    private int modificadorForca;
    private int valorDestreza;
    private int modificadorDestreza;
    private int valorConstituicao;
    private int modificadorConstituicao;
    private int valorSabedoria;
    private int modificadorSabedoria;
    private int valorPresenca;
    private int modificadorPresenca;
    private int valorVontade;
    private int modificadorVontade;
    private ArrayList<String> proeficiencias;
    private int classeResistencia;
    private int valorProeficiencia;
    private int deslocamento;
    private int pvMax;
    private int pvAtual;
    private int pvTemp;
    private String dadosVida;
    private ArrayList<ArrayList<String>> ataques;
    private ArrayList<Tecnica> tecnicas;
    private int ppMax;
    private int ppAtual;
    private String individualidade;
    private String defeito;
    private String codigo_honra;
    private String habilidades_basicas;
    private String equipamentos;
    private String outros;
    private double cash;
    private String alcunha;
    private String sonho;
    private String caminho;
    private int qntTripulacao;
    private String cargo;
    private double altura;
    private double peso;
    private int idade;
    private String detalhesProfissao;
    private String detalhesTreinamentos;
    private String hakiObservacao;
    private String hakiArmamento;
    private String hakiRei;
    private String akumaNoMi;
    private Bitmap imagemPersonagem;

    /* GETTERS E SETTERS */

    public String getNome(){return this.nome;}
    public String getEstiloCombate(){return this.estiloCombate;}
    public String getEspecie(){return this.especie;}
    public int getNivel(){return this.nivel;}
    public Bitmap getImagemPersonagem(){return this.imagemPersonagem;}

    // CONSTRUTOR
    public Personagem(String nome, String especie, String antecedente, String estiloCombate, String profissao,
                      int nivel, long experiencia, int valorForca, int valorDestreza, int valorConstituicao,
                      int valorSabedoria, int valorPresenca, int valorVontade, ArrayList<String> proeficiencias,
                      int classeResistencia, int valorProeficiencia, int deslocamento, int pvMax, int pvAtual,
                      int pvTemp, String dadosVida, ArrayList<ArrayList<String>> ataques, ArrayList<Tecnica> tecnicas,
                      int ppMax, int ppAtual, String individualidade, String defeito, String codigo_honra, String habilidades_basicas,
                      String equipamentos, String outros, double cash, String alcunha, String sonho, String caminho,
                      int qntTripulacao, String cargo, double altura, double peso, int idade, String detalhesProfissao,
                      String detalhesTreinamentos, String hakiObservacao, String hakiArmamento, String hakiRei, String akumaNoMi, Bitmap imagemPersonagem){
        this.nome = nome;
        this.especie = especie;
        this.antecedente = antecedente;
        this.estiloCombate = estiloCombate;
        this.profissao = profissao;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.valorForca = valorForca;
        this.modificadorForca = calculaModificador(valorForca);
        this.valorDestreza = valorDestreza;
        this.modificadorDestreza = calculaModificador(valorDestreza);
        this.valorConstituicao = valorConstituicao;
        this.modificadorConstituicao = calculaModificador(valorConstituicao);
        this.valorSabedoria = valorSabedoria;
        this.modificadorSabedoria = calculaModificador(valorSabedoria);
        this.valorPresenca = valorPresenca;
        this.modificadorPresenca = calculaModificador(valorPresenca);
        this.valorVontade = valorVontade;
        this.modificadorVontade = calculaModificador(valorVontade);
        this.proeficiencias = proeficiencias;
        this.classeResistencia = classeResistencia;
        this.valorProeficiencia = valorProeficiencia;
        this.deslocamento = deslocamento;
        this.pvMax = pvMax;
        this.pvAtual = pvAtual;
        this.pvTemp = pvTemp;
        this.dadosVida = dadosVida;
        this.ataques = ataques;
        this.tecnicas = tecnicas;
        this.ppMax = ppMax;
        this.ppAtual = ppAtual;
        this.individualidade = individualidade;
        this.defeito = defeito;
        this.codigo_honra = codigo_honra;
        this.habilidades_basicas = habilidades_basicas;
        this.equipamentos = equipamentos;
        this.outros = outros;
        this.cash = cash;
        this.alcunha = alcunha;
        this.sonho = sonho;
        this.caminho = caminho;
        this.qntTripulacao = qntTripulacao;
        this.cargo = cargo;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.detalhesProfissao = detalhesProfissao;
        this.detalhesTreinamentos = detalhesTreinamentos;
        this.hakiObservacao = hakiObservacao;
        this.hakiArmamento = hakiArmamento;
        this.hakiRei = hakiRei;
        this.akumaNoMi = akumaNoMi;
        this.imagemPersonagem = imagemPersonagem;
    }

    private int calculaModificador(int valor){
        return (int) Math.floor((double)(valor - 10)/2);
    }

}
