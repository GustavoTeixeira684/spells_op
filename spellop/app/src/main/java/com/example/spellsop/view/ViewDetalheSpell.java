package com.example.spellsop.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.spellsop.R;
import com.example.spellsop.controller.SpellsController;
import com.example.spellsop.model.Tecnica;

import java.util.Objects;

public class ViewDetalheSpell extends AppCompatActivity {

    ImageButton imgBtnVoltar;
    TextView txtGrau, txtEnergia, txtRequisito, txtAlcance, txtDuracao, txtClasse, txtDano, txtTitulo, txtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_detalhe_spell);

        // Declarações
        imgBtnVoltar = findViewById(R.id.imgBtnVoltar);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtGrau = findViewById(R.id.txtGrau);
        txtEnergia = findViewById(R.id.txtEnergia);
        txtRequisito = findViewById(R.id.txtRequisito);
        txtAlcance = findViewById(R.id.txtAlcance);
        txtDuracao = findViewById(R.id.txtDuracao);
        txtClasse = findViewById(R.id.txtClasse);
        txtDano = findViewById(R.id.txtDano);
        txtDescricao = findViewById(R.id.txtDescricao);
        Tecnica tecnica = Objects.requireNonNull(getIntent().getExtras()).getParcelable("detalhe_tecnica");


        txtTitulo.setText(tecnica.getTitulo());
        txtGrau.setText(String.valueOf(tecnica.getGrau()) + "º Grau");
        txtEnergia.setText("Pontos de Energia: " + String.valueOf(tecnica.getEnergia()));
        txtRequisito.setText("Requisito: " + tecnica.getRequisito());
        txtAlcance.setText("Alcance: " + tecnica.getAlcance());
        txtDuracao.setText("Duração: " + tecnica.getDuracao());
        txtClasse.setText("Estilo de Combate: " + tecnica.getEstilo());
        txtDano.setText("Dano: " + tecnica.getDano());
        txtDescricao.setText("Descrição: " + tecnica.getDescricao());


        // Botões
        imgBtnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}