package com.example.spellsop;

public class Tecnica {

    private int id;
    private String titulo;
    private String descricao;
    private int energia;
    private String duracao;
    private String alcance;
    private String requisito;
    private String dano;
    private int grau;

    public Tecnica(int id, String titulo, String descricao, int energia, String duracao, String alcance, String requisito, String dano, int grau){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.energia = energia;
        this.duracao = duracao;
        this.alcance = alcance;
        this.requisito = requisito;
        this.dano = dano;
        this.grau = grau;
    }

    public int getId(){
        return this.id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getEnergia(){
        return this.energia;
    }

    public String getDuracao(){
        return this.duracao;
    }

    public String getAlcance(){
        return this.alcance;
    }

    public String getRequisito(){
        return this.requisito;
    }

    public String getDano(){
        return this.dano;
    }

    public int getGrau(){
        return this.grau;
    }

}
