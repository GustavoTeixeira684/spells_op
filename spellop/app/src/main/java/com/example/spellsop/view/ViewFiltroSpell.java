package com.example.spellsop.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.spellsop.R;
import com.example.spellsop.controller.SpellsController;

import java.util.ArrayList;

public class ViewFiltroSpell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_filtro_spell);

        //Declarações
        ImageButton imgBtnVoltar = findViewById(R.id.imgBtnVoltar);
        TextView txtBuscar = findViewById(R.id.txtBuscar);
        TextView txtQntEstiloCombate = findViewById(R.id.txtQntEstiloCombate);
        TextView txtQntGrau = findViewById(R.id.txtQntGrau);
        TextView txtQntRequisito = findViewById(R.id.txtQntRequisito);
        TextView txtQntAlcance = findViewById(R.id.txtQntAlcance);
        TextView txtQntDuracao = findViewById(R.id.txtQntDuracao);
        TextView txtQntEnergia = findViewById(R.id.txtQntEnergia);
        carregaSpinners();


        // Funções
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


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Filtros), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void carregaSpinners() {

        Spinner spinnerEstiloCombate = findViewById(R.id.spinnerEstiloCombate);
        Spinner spinnerGrau = findViewById(R.id.spinnerGrau);
        Spinner spinnerRequisito = findViewById(R.id.spinnerRequisito);
        Spinner spinnerAlcance = findViewById(R.id.spinnerAlcance);
        Spinner spinnerDuracao = findViewById(R.id.spinnerDuracao);
        Spinner spinnerEnergia = findViewById(R.id.spinnerEnergia);
        ArrayList<ArrayList<String>> listaFiltros = SpellsController.returnFilters();

        ArrayAdapter<String> estiloCombateDistintos = new ArrayAdapter<>(ViewFiltroSpell.this, android.R.layout.select_dialog_multichoice, listaFiltros.get(0));
        estiloCombateDistintos.setDropDownViewResource(android.R.layout.select_dialog_multichoice);
        spinnerEstiloCombate.setAdapter(estiloCombateDistintos);

//        ArrayAdapter<String> grauDistintos = new ArrayAdapter<>(ViewFiltroSpell.this, android.R.layout.list_content, listaFiltros.get(1));
//        grauDistintos.setDropDownViewResource(android.R.layout.list_content);
//        spinnerGrau.setAdapter(grauDistintos);
//
//        ArrayAdapter<String> requisitoDistintos = new ArrayAdapter<>(ViewFiltroSpell.this, android.R.layout.expandable_list_content, listaFiltros.get(2));
//        requisitoDistintos.setDropDownViewResource(android.R.layout.expandable_list_content);
//        spinnerRequisito.setAdapter(requisitoDistintos);
//
//        ArrayAdapter<String> alcanceDistintos = new ArrayAdapter<>(ViewFiltroSpell.this, android.R.layout.browser_link_context_header, listaFiltros.get(3));
//        alcanceDistintos.setDropDownViewResource(android.R.layout.browser_link_context_header);
//        spinnerAlcance.setAdapter(alcanceDistintos);
//
//        ArrayAdapter<String> duracaoDistintos = new ArrayAdapter<>(ViewFiltroSpell.this, android.R.layout.select_dialog_item, listaFiltros.get(4));
//        duracaoDistintos.setDropDownViewResource(android.R.layout.select_dialog_item);
//        spinnerDuracao.setAdapter(duracaoDistintos);
//
//        ArrayAdapter<String> energiaDistintos = new ArrayAdapter<>(ViewFiltroSpell.this, android.R.layout.select_dialog_multichoice, listaFiltros.get(5));
//        energiaDistintos.setDropDownViewResource(android.R.layout.select_dialog_multichoice);
//        spinnerEnergia.setAdapter(energiaDistintos);

    }
}