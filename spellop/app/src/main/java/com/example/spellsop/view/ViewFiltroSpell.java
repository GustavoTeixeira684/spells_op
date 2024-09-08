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
import java.util.Map;
import java.util.Objects;

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
    public TextView labelBuscar, labelQntEstiloCombate, labelQntGrau, labelQntRequisito, labelQntAlcance, labelQntDuracao, labelQntEnergia, labelQntTecnicas;
    private TextView labelLimparEstiloCombate, labelLimparGrau, labelLimparRequisito, labelLimparAlcance, labelLimparDuracao, labelLimparEnergia, labelLimparTudo;
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
        labelLimparTudo = findViewById(R.id.labelLimparTudo);
        labelQntTecnicas = findViewById(R.id.labelQntTecnicas);

        this.setEstadoInicialComponentes();
        this.carregaObjetosFiltro();
        this.setEventos();
        this.iniciaValoresJaEstabelecidos();

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
        labelQntEstiloCombate.setText(String.valueOf(SpellsController.getQntEstiloCombate()));
        labelQntGrau.setText(String.valueOf(SpellsController.getQntGrau()));
        labelQntRequisito.setText(String.valueOf(SpellsController.getQntRequisito()));
        labelQntAlcance.setText(String.valueOf(SpellsController.getQntAlcance()));
        labelQntDuracao.setText(String.valueOf(SpellsController.getQntDuracao()));
        labelQntEnergia.setText(String.valueOf(SpellsController.getQntEnergia()));
        labelLimparEstiloCombate.setVisibility(labelQntEstiloCombate.getText().equals("0") ? View.INVISIBLE : View.VISIBLE);
        labelLimparGrau.setVisibility(labelQntGrau.getText().equals("0") ? View.INVISIBLE : View.VISIBLE);
        labelLimparRequisito.setVisibility(labelQntRequisito.getText().equals("0") ? View.INVISIBLE : View.VISIBLE);
        labelLimparAlcance.setVisibility(labelQntAlcance.getText().equals("0") ? View.INVISIBLE : View.VISIBLE);
        labelLimparDuracao.setVisibility(labelQntDuracao.getText().equals("0") ? View.INVISIBLE : View.VISIBLE);
        labelLimparEnergia.setVisibility(labelQntEnergia.getText().equals("0") ? View.INVISIBLE : View.VISIBLE);
        atualizaQntTecnicasFiltradas();
        setLabelLimpaTudo();

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
                atualizaQntTecnicasFiltradas();
            }
        });

        labelLimparGrau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsController.limparItensFiltro("grau", labelQntGrau, labelLimparGrau);
                recyclerGrau.setAdapter(recyclerGrauAdapter);
                atualizaQntTecnicasFiltradas();
            }
        });

        labelLimparRequisito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsController.limparItensFiltro("requisito", labelQntRequisito, labelLimparRequisito);
                recyclerRequisito.setAdapter(recyclerRequisitoAdapter);
                atualizaQntTecnicasFiltradas();
            }
        });

        labelLimparAlcance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsController.limparItensFiltro("alcance", labelQntAlcance, labelLimparAlcance);
                recyclerAlcance.setAdapter(recyclerAlcanceAdapter);
                atualizaQntTecnicasFiltradas();
            }
        });

        labelLimparDuracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsController.limparItensFiltro("duracao", labelQntDuracao, labelLimparDuracao);
                recyclerDuracao.setAdapter(recyclerDuracaoAdapter);
                atualizaQntTecnicasFiltradas();
            }
        });

        labelLimparEnergia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsController.limparItensFiltro("energia", labelQntEnergia, labelLimparEnergia);
                recyclerEnergia.setAdapter(recyclerEnergiaAdapter);
                atualizaQntTecnicasFiltradas();
            }
        });

        labelLimparTudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                labelLimparEstiloCombate.performClick();
                labelLimparGrau.performClick();
                labelLimparRequisito.performClick();
                labelLimparEnergia.performClick();
                labelLimparDuracao.performClick();
                labelLimparAlcance.performClick();
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
                setLabelLimpaTudo();
                atualizaQntTecnicasFiltradas();
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
                setLabelLimpaTudo();
                atualizaQntTecnicasFiltradas();
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
                setLabelLimpaTudo();
                atualizaQntTecnicasFiltradas();
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
                setLabelLimpaTudo();
                atualizaQntTecnicasFiltradas();
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
                setLabelLimpaTudo();
                atualizaQntTecnicasFiltradas();
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
                setLabelLimpaTudo();
                atualizaQntTecnicasFiltradas();
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

    private void iniciaValoresJaEstabelecidos(){

        Map<String, ArrayList<String>> filtrosDefinidos = SpellsController.getFiltros();

        // Carrega os valores
        for(String chave : filtrosDefinidos.keySet()){
            for(String item : Objects.requireNonNull(filtrosDefinidos.get(chave))){



            }
        }

    }

    private void setLabelLimpaTudo(){

        int quantidade_filtros = Integer.parseInt(String.join(labelQntEstiloCombate.getText() , labelQntDuracao.getText() , labelQntEnergia.getText() , labelQntAlcance.getText() ,  labelQntRequisito.getText() ,  labelQntGrau.getText()));
        if(quantidade_filtros == 0){
            labelLimparTudo.setVisibility(View.GONE);
        }else{
            labelLimparTudo.setVisibility(View.VISIBLE);
        }

    }

    private void atualizaQntTecnicasFiltradas(){
        labelQntTecnicas.setText(String.valueOf(SpellsController.getQuantidadeTecnicasFiltradas()) + " Técnicas");
    }

}

