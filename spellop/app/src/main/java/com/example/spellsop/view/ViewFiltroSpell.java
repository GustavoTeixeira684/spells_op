package com.example.spellsop.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;
import com.example.spellsop.adapter.RecyclerAlcanceAdapter;
import com.example.spellsop.adapter.RecyclerDuracaoAdapter;
import com.example.spellsop.adapter.RecyclerEnergiaAdapter;
import com.example.spellsop.adapter.RecyclerEstiloCombateAdapter;
import com.example.spellsop.adapter.RecyclerGrauAdapter;
import com.example.spellsop.adapter.RecyclerRequisitoAdapter;
import com.example.spellsop.controller.SpellsController;

import java.util.ArrayList;
import java.util.Collections;

public class ViewFiltroSpell extends AppCompatActivity {

    // Adapters
    private RecyclerEstiloCombateAdapter recyclerEstiloCombateAdapter;
    private RecyclerEnergiaAdapter recyclerEnergiaAdapter;
    private RecyclerDuracaoAdapter recyclerDuracaoAdapter;
    private RecyclerGrauAdapter recyclerGrauAdapter;
    private RecyclerAlcanceAdapter recyclerAlcanceAdapter;
    private RecyclerRequisitoAdapter recyclerRequisitoAdapter;

    // Objetos do layout
    RecyclerView recyclerEstiloCombate, recyclerGrau, recyclerRequisito, recyclerAlcance, recyclerDuracao, recyclerEnergia;
    TextView txtBuscar, txtQntEstiloCombate, txtQntGrau, txtQntRequisito, txtQntAlcance, txtQntDuracao, txtQntEnergia;
    ImageButton imgBtnVoltar, imgBtnEstiloCombate, imgBtnGrau, imgBtnRequisito, imgBtnAlcance, imgBtnDuracao, imgBtnEnergia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_filtro_spell);

        //Declarações
        imgBtnVoltar = findViewById(R.id.imgBtnVoltar);
        txtBuscar = findViewById(R.id.txtBuscar);
        txtQntEstiloCombate = findViewById(R.id.txtQntEstiloCombate);
        txtQntGrau = findViewById(R.id.txtQntGrau);
        txtQntRequisito = findViewById(R.id.txtQntRequisito);
        txtQntAlcance = findViewById(R.id.txtQntAlcance);
        txtQntDuracao = findViewById(R.id.txtQntDuracao);
        txtQntEnergia = findViewById(R.id.txtQntEnergia);
        recyclerEstiloCombate = findViewById(R.id.recyclerEstiloCombate);
        recyclerGrau = findViewById(R.id.recyclerGrau);
        recyclerRequisito = findViewById(R.id.recyclerRequisito);
        recyclerAlcance = findViewById(R.id.recyclerAlcance);
        recyclerDuracao = findViewById(R.id.recyclerDuracao);
        recyclerEnergia = findViewById(R.id.recyclerEnergia);
        imgBtnEstiloCombate = findViewById(R.id.imgBtnEstiloCombate);
        imgBtnGrau = findViewById(R.id.imgBtnGrau);
        imgBtnRequisito = findViewById(R.id.imgBtnRequisito);
        imgBtnAlcance = findViewById(R.id.imgBtnAlcance);
        imgBtnDuracao = findViewById(R.id.imgBtnDuracao);
        imgBtnEnergia = findViewById(R.id.imgBtnEnergia);

        this.setEstadoInicialComponentes();
        this.carregaObjetosFiltro();
        this.setEventos();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Filtros), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void setEstadoInicialComponentes(){

        recyclerEstiloCombate.setVisibility(View.GONE);
        recyclerAlcance.setVisibility(View.GONE);
        recyclerRequisito.setVisibility(View.GONE);
        recyclerDuracao.setVisibility(View.GONE);
        recyclerEnergia.setVisibility(View.GONE);
        recyclerGrau.setVisibility(View.GONE);

    }

     // Método para centralizar os eventos
    private void setEventos(){


        //Voltar
        imgBtnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgBtnEstiloCombate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recyclerEstiloCombate.getVisibility() == View.GONE){
                    recyclerEstiloCombate.setVisibility(View.VISIBLE);
                }else{
                    recyclerEstiloCombate.setVisibility(View.GONE);
                }
            }
        });

        imgBtnGrau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recyclerGrau.getVisibility() == View.GONE){
                    recyclerGrau.setVisibility(View.VISIBLE);
                }else{
                    recyclerGrau.setVisibility(View.GONE);
                }
            }
        });

        imgBtnRequisito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recyclerRequisito.getVisibility() == View.GONE){
                    recyclerRequisito.setVisibility(View.VISIBLE);
                }else{
                    recyclerRequisito.setVisibility(View.GONE);
                }
            }
        });

        imgBtnDuracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recyclerDuracao.getVisibility() == View.GONE){
                    recyclerDuracao.setVisibility(View.VISIBLE);
                }else{
                    recyclerDuracao.setVisibility(View.GONE);
                }
            }
        });

        imgBtnEnergia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recyclerEnergia.getVisibility() == View.GONE){
                    recyclerEnergia.setVisibility(View.VISIBLE);
                }else{
                    recyclerEnergia.setVisibility(View.GONE);
                }
            }
        });

        imgBtnAlcance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recyclerAlcance.getVisibility() == View.GONE){
                    recyclerAlcance.setVisibility(View.VISIBLE);
                }else{
                    recyclerAlcance.setVisibility(View.GONE);
                }
            }
        });

    }


    private void carregaObjetosFiltro() {

        ArrayList<ArrayList<String>> listaItensFiltro = SpellsController.returnFilters(); // Pega objetos para aparecer nos filtros

        //Estilo de Combate
        Collections.sort(listaItensFiltro.get(0));
        recyclerEstiloCombateAdapter = new RecyclerEstiloCombateAdapter(ViewFiltroSpell.this, listaItensFiltro.get(0));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerEstiloCombate.setLayoutManager(layoutManager);
        recyclerEstiloCombate.setAdapter(recyclerEstiloCombateAdapter);

        // Grau
        Collections.sort(listaItensFiltro.get(1));
        recyclerGrauAdapter = new RecyclerGrauAdapter(ViewFiltroSpell.this, listaItensFiltro.get(1));
        layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerGrau.setLayoutManager(layoutManager);
        recyclerGrau.setAdapter(recyclerGrauAdapter);

        // Requisito
        Collections.sort(listaItensFiltro.get(2));
        recyclerRequisitoAdapter = new RecyclerRequisitoAdapter(ViewFiltroSpell.this, listaItensFiltro.get(2));
        layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerRequisito.setLayoutManager(layoutManager);
        recyclerRequisito.setAdapter(recyclerRequisitoAdapter);

        // Alcance
        Collections.sort(listaItensFiltro.get(3));
        recyclerAlcanceAdapter = new RecyclerAlcanceAdapter(ViewFiltroSpell.this, listaItensFiltro.get(3));
        layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerAlcance.setLayoutManager(layoutManager);
        recyclerAlcance.setAdapter(recyclerAlcanceAdapter);

        // Duracao
        Collections.sort(listaItensFiltro.get(4));
        recyclerDuracaoAdapter = new RecyclerDuracaoAdapter(ViewFiltroSpell.this, listaItensFiltro.get(4));
        layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerDuracao.setLayoutManager(layoutManager);
        recyclerDuracao.setAdapter(recyclerDuracaoAdapter);

        // Energia
        Collections.sort(listaItensFiltro.get(5));
        recyclerEnergiaAdapter = new RecyclerEnergiaAdapter(ViewFiltroSpell.this, listaItensFiltro.get(5));
        layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerEnergia.setLayoutManager(layoutManager);
        recyclerEnergia.setAdapter(recyclerEnergiaAdapter);



    }
}

