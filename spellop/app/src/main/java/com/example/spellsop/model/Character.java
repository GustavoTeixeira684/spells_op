package com.example.spellsop.model;

import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Character {

    private int id;
    private String nome;
    private String especie;
    private String antecedente;
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
    private HashMap<String, Integer> habilidades;
    private int classeResistencia;
    private int proeficiencia;
    private float deslocamento;
    private int pvMax;
    private int pvAtual;
    private int pvTemp;
    private String dadosVida;
    private ArrayList<Pair<String, String>> ataques;
    private ArrayList<Tecnica> tecnicas;
    private int ppMax;
    private int ppAtual;
    private String individualidade;
    private String defeito;
    private String codigo_honra;
    private String habilidade_basicas;
    private String equipamentos;
    private String outros;
    private double cash;
    private String alcunha;
    private String sonho;
    private String caminho;
    private int qntTripulacao;
    private String cargo;
    private String altura;
    private String peso;
    private int idade;
    private String detalhesProfissao;
    private String detalhesTreinamentos;
    private String hakiObservacao;
    private String hakiArmamento;
    private String hakiRei;
    private String akumaNoMi;

    public Character(String nome, String especie, String estiloCombate){
        this.nome = nome;
        this.especie = especie;
        this.estiloCombate = estiloCombate;
    }


}
