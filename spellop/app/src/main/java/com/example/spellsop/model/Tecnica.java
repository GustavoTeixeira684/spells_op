package com.example.spellsop.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tecnica implements Parcelable {

    private int id;
    private String titulo;
    private String descricao;
    private int energia;
    private String duracao;
    private String alcance;
    private String requisito;
    private String dano;
    private int grau;
    private String estilo;


    public Tecnica(int id, String titulo, String descricao, int energia, String duracao, String alcance, String requisito, String dano, int grau, String estilo){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.energia = energia;
        this.duracao = duracao;
        this.alcance = alcance;
        this.requisito = requisito;
        this.dano = dano;
        this.grau = grau;
        this.estilo = estilo;

    }

    protected Tecnica(Parcel in) {
        id = in.readInt();
        titulo = in.readString();
        descricao = in.readString();
        energia = in.readInt();
        duracao = in.readString();
        alcance = in.readString();
        requisito = in.readString();
        dano = in.readString();
        grau = in.readInt();
        estilo = in.readString();
    }

    public static final Creator<Tecnica> CREATOR = new Creator<Tecnica>() {
        @Override
        public Tecnica createFromParcel(Parcel in) {
            return new Tecnica(in);
        }

        @Override
        public Tecnica[] newArray(int size) {
            return new Tecnica[size];
        }
    };

    public String getEstilo() {return this.estilo;}

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

    public String getAtributoTecnica(String objeto){
        switch(objeto){
            case "estilo_combate": return this.estilo;
            case "duracao": return this.duracao;
            case "alcance": return this.alcance;
            case "requisito": return this.requisito;
            case "grau": return String.valueOf(this.grau);
            default: return String.valueOf(this.energia); // Energia
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(titulo);
        dest.writeString(descricao);
        dest.writeInt(energia);
        dest.writeString(duracao);
        dest.writeString(alcance);
        dest.writeString(requisito);
        dest.writeString(dano);
        dest.writeInt(grau);
        dest.writeString(estilo);
    }
}
