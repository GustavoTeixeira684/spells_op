package com.example.spellsop.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
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
    public TextView labelBuscar, labelQntEstiloCombate, labelQntGrau, labelQntRequisito, labelQntAlcance, labelQntDuracao, labelQntEnergia;
    private TextView labelLimparEstiloCombate, labelLimparGrau, labelLimparRequisito, labelLimparAlcance, labelLimparDuracao, labelLimparEnergia;
    ImageButton imgBtnVoltar, imgBtnEstiloCombate, imgBtnGrau, imgBtnRequisito, imgBtnAlcance, imgBtnDuracao, imgBtnEnergia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_filtro_spell);

        //Declarações
        imgBtnVoltar = findViewById(R.id.imgBtnVoltar);
        labelBuscar = findViewById(R.id.txtBuscar);
        labelQntEstiloCombate = findViewById(R.id.txtQntEstiloCombate);
        labelQntGrau = findViewById(R.id.txtQntGrau);
        labelQntRequisito = findViewById(R.id.txtQntRequisito);
        labelQntAlcance = findViewById(R.id.txtQntAlcance);
        labelQntDuracao = findViewById(R.id.txtQntDuracao);
        labelQntEnergia = findViewById(R.id.txtQntEnergia);
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
        labelLimparEstiloCombate = findViewById(R.id.labelLimparEstiloCombate);
        labelLimparGrau = findViewById(R.id.labelLimparGrau);
        labelLimparRequisito = findViewById(R.id.labelLimparRequisito);
        labelLimparAlcance = findViewById(R.id.labelLimparAlcance);
        labelLimparDuracao = findViewById(R.id.labelLimparDuracao);
        labelLimparEnergia = findViewById(R.id.labelLimparEnergia);

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
        labelLimparEstiloCombate.setVisibility(View.INVISIBLE);
        labelLimparGrau.setVisibility(View.INVISIBLE);
        labelLimparRequisito.setVisibility(View.INVISIBLE);
        labelLimparAlcance.setVisibility(View.INVISIBLE);
        labelLimparDuracao.setVisibility(View.INVISIBLE);
        labelLimparEnergia.setVisibility(View.INVISIBLE);

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
        // Volta
        labelBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // ***** Inicio Eventos que limpam as listas de filtros ***** //

        labelLimparEstiloCombate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsController.limparItensFiltro("estilo_combate", labelQntEstiloCombate, labelLimparEstiloCombate);
                recyclerEstiloCombate.setAdapter(recyclerEstiloCombateAdapter);
            }
        });

        labelLimparGrau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsController.limparItensFiltro("grau", labelQntGrau, labelLimparGrau);
                recyclerGrau.setAdapter(recyclerGrauAdapter);
            }
        });

        labelLimparRequisito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsController.limparItensFiltro("requisito", labelQntRequisito, labelLimparRequisito);
                recyclerRequisito.setAdapter(recyclerRequisitoAdapter);
            }
        });

        labelLimparAlcance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsController.limparItensFiltro("alcance", labelQntAlcance, labelLimparAlcance);
                recyclerAlcance.setAdapter(recyclerAlcanceAdapter);
            }
        });

        labelLimparDuracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsController.limparItensFiltro("duracao", labelQntDuracao, labelLimparDuracao);
                recyclerDuracao.setAdapter(recyclerDuracaoAdapter);
            }
        });

        labelLimparEnergia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsController.limparItensFiltro("energia", labelQntEnergia, labelLimparEnergia);
                recyclerEnergia.setAdapter(recyclerEnergiaAdapter);
            }
        });

        // ***** Fim Eventos que limpam as listas de filtros ***** //

        // ***** Inicio Eventos que habilitam as listas dos filtros ***** //
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
        // ***** Fim Eventos que habilitam as listas dos filtros ***** //

    }


    private void carregaObjetosFiltro() {

        ArrayList<ArrayList<String>> listaItensFiltro = SpellsController.returnFilters(); // Pega objetos para aparecer nos filtros

        //Estilo de Combate
        Collections.sort(listaItensFiltro.get(0));
        recyclerEstiloCombateAdapter = new RecyclerEstiloCombateAdapter(ViewFiltroSpell.this, listaItensFiltro.get(0), labelQntEstiloCombate, labelLimparEstiloCombate);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerEstiloCombate.setLayoutManager(layoutManager);
        recyclerEstiloCombate.setAdapter(recyclerEstiloCombateAdapter);


        // Grau
        Collections.sort(listaItensFiltro.get(1));
        recyclerGrauAdapter = new RecyclerGrauAdapter(ViewFiltroSpell.this, listaItensFiltro.get(1), labelQntGrau, labelLimparGrau);
        layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerGrau.setLayoutManager(layoutManager);
        recyclerGrau.setAdapter(recyclerGrauAdapter);

        // Requisito
        Collections.sort(listaItensFiltro.get(2));
        recyclerRequisitoAdapter = new RecyclerRequisitoAdapter(ViewFiltroSpell.this, listaItensFiltro.get(2), labelQntRequisito, labelLimparRequisito);
        layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerRequisito.setLayoutManager(layoutManager);
        recyclerRequisito.setAdapter(recyclerRequisitoAdapter);

        // Alcance
        Collections.sort(listaItensFiltro.get(3));
        recyclerAlcanceAdapter = new RecyclerAlcanceAdapter(ViewFiltroSpell.this, listaItensFiltro.get(3), labelQntAlcance, labelLimparAlcance);
        layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerAlcance.setLayoutManager(layoutManager);
        recyclerAlcance.setAdapter(recyclerAlcanceAdapter);

        // Duracao
        Collections.sort(listaItensFiltro.get(4));
        recyclerDuracaoAdapter = new RecyclerDuracaoAdapter(ViewFiltroSpell.this, listaItensFiltro.get(4), labelQntDuracao, labelLimparDuracao);
        layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerDuracao.setLayoutManager(layoutManager);
        recyclerDuracao.setAdapter(recyclerDuracaoAdapter);

        // Energia
        Collections.sort(listaItensFiltro.get(5));
        recyclerEnergiaAdapter = new RecyclerEnergiaAdapter(ViewFiltroSpell.this, listaItensFiltro.get(5), labelQntEnergia, labelLimparEnergia);
        layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerEnergia.setLayoutManager(layoutManager);
        recyclerEnergia.setAdapter(recyclerEnergiaAdapter);

    }


}

