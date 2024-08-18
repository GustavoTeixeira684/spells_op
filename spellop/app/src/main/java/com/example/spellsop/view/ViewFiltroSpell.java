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
import com.example.spellsop.adapter.RecyclerEstiloCombateAdapter;
import com.example.spellsop.controller.SpellsController;

import java.util.ArrayList;
import java.util.Collections;

public class ViewFiltroSpell extends AppCompatActivity {

    private RecyclerEstiloCombateAdapter recyclerEstiloCombateAdapter;
    RecyclerView recyclerEstiloCombate;
    TextView txtBuscar, txtQntEstiloCombate, txtQntGrau, txtQntRequisito, txtQntAlcance, txtQntDuracao, txtQntEnergia;
    ImageButton imgBtnVoltar, imgBtnEstiloCombate;


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
        imgBtnEstiloCombate = findViewById(R.id.imgBtnEstiloCombate);

        this.setEstadoInicialComponentes();
        this.carregaSpinners();
        this.setEventos();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Filtros), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void setEstadoInicialComponentes(){

        recyclerEstiloCombate.setVisibility(View.GONE);

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

    }


    private void carregaSpinners() {

        ArrayList<ArrayList<String>> listaItensFiltro = SpellsController.returnFilters();
        Collections.sort(listaItensFiltro.get(0));
        recyclerEstiloCombateAdapter = new RecyclerEstiloCombateAdapter(ViewFiltroSpell.this, listaItensFiltro.get(0));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewFiltroSpell.this, LinearLayoutManager.VERTICAL, false);
        recyclerEstiloCombate.setLayoutManager(layoutManager);
        recyclerEstiloCombate.setAdapter(recyclerEstiloCombateAdapter);



    }
}

