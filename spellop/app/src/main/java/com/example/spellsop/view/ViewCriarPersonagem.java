package com.example.spellsop.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.spellsop.R;
import com.example.spellsop.controller.CharacterController;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;

public class ViewCriarPersonagem extends AppCompatActivity {

    ImageButton btnFechar;
    AutoCompleteTextView txtProeficiencias;
    BottomSheetDialog bottomSheetDialog;
    TextView labelAtletismo, labelAcrobacia, labelFurtividade, labelHistoria, labelInvestigacao, labelNatureza,
    labelSobrevivencia, labelAtuacao, labelEnganacao, labelIntimidacao, labelPersuasao, labelProvocacao, labelHaki, labelIntuicao,
    labelPercepcao, labelSobrenatural, labelSorte, labelPrestidigitacao;

    boolean selectedLabelAtletismo = false, selectedLabelAcrobacia = false, selectedLabelFurtividade = false, selectedLabelHistoria = false, selectedLabelInvestigacao = false,
            selectedLabelNatureza = false, selectedLabelSobrevivencia = false, selectedLabelAtuacao = false, selectedLabelEnganacao = false, selectedLabelIntimidacao = false, selectedLabelPersuasao = false, selectedLabelProvocacao = false,
            selectedLabelHaki = false, selectedLabelIntuicao = false, selectedLabelPercepcao = false, selectedLabelSobrenatural = false, selectedLabelSorte = false,
            selectedLabelPrestidigitacao = false;

    View view;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_criar_personagem);

        btnFechar = this.findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Instancia componentes de layout



        // Select Box Especies
        String[] stringArrayEspecies = getResources().getStringArray(R.array.especies);
        ArrayAdapter<String> adapterEspecies= new ArrayAdapter<>(ViewCriarPersonagem.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, stringArrayEspecies);
        AutoCompleteTextView txtEspecies = this.findViewById(R.id.txtEspecie);
        txtEspecies.setAdapter(adapterEspecies);

        String[] stringArrayEstiloCombate = getResources().getStringArray(R.array.estiloCombate);
        ArrayAdapter<String> adapterEstiloCombate= new ArrayAdapter<>(ViewCriarPersonagem.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, stringArrayEstiloCombate);
        AutoCompleteTextView txtEstiloCombate = this.findViewById(R.id.txtEstilo);
        txtEstiloCombate.setAdapter(adapterEstiloCombate);

        String[] stringArrayProfissoes = getResources().getStringArray(R.array.profissoes);
        ArrayAdapter<String> adapterProfissoes= new ArrayAdapter<>(ViewCriarPersonagem.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, stringArrayProfissoes);
        AutoCompleteTextView txtProfissao = this.findViewById(R.id.txtProfissao);
        txtProfissao.setAdapter(adapterProfissoes);


        txtProeficiencias = findViewById(R.id.txtProeficiencias);
        CharacterController.txtProeficienciaCadastro = this.txtProeficiencias; // Passa referência para que a seleção seja atualizada em tempo real
        bottomSheetDialog = new BottomSheetDialog(ViewCriarPersonagem.this); // Instanciando um objeto BottomSheetDialog
        view = LayoutInflater.from(ViewCriarPersonagem.this).inflate(R.layout.proeficiencias_bottom_sheet_layout, null, false);
        bottomSheetDialog.setContentView(view);

        labelAtletismo = view.findViewById(R.id.labelAtletismo);
        labelAcrobacia = view.findViewById(R.id.labelAcrobacia);
        labelFurtividade = view.findViewById(R.id.labelFurtividade);
        labelHistoria = view.findViewById(R.id.labelHistoria);
        labelInvestigacao = view.findViewById(R.id.labelInvestigacao);
        labelNatureza = view.findViewById(R.id.labelNatureza);
        labelSobrevivencia = view.findViewById(R.id.labelSobrevivencia);
        labelAtuacao = view.findViewById(R.id.labelAtuacao);
        labelEnganacao = view.findViewById(R.id.labelEnganacao);
        labelIntimidacao = view.findViewById(R.id.labelIntimidacao);
        labelProvocacao = view.findViewById(R.id.labelProvocacao);
        labelHaki = view.findViewById(R.id.labelHaki);
        labelIntuicao = view.findViewById(R.id.labelIntuicao);
        labelPercepcao = view.findViewById(R.id.labelPercepcao);
        labelSobrenatural = view.findViewById(R.id.labelSobrenatural);
        labelSorte = view.findViewById(R.id.labelSorte);
        labelPrestidigitacao = view.findViewById(R.id.labelPrestidigitacao);
        labelPersuasao = view.findViewById(R.id.labelPersuasao);

        this.setEventos();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setEventos(){

        txtProeficiencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // O método performClick garante acessibilidade
                bottomSheetDialog.show();
            }
        });

        txtProeficiencias.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                txtProeficiencias.performClick();
                return false;
            }
        });

        labelAtletismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("joj","joj");
                if(!selectedLabelAtletismo){
                    CharacterController.setSelectedProeficiencia((String)labelAtletismo.getText());
                    labelAtletismo.setTextColor(getColor(R.color.golden));
                    selectedLabelAtletismo = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelAtletismo.getText());
                    labelAtletismo.setTextColor(getColor(R.color.black));
                    selectedLabelAtletismo = false;
                }
            }
        });

        labelAcrobacia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelAcrobacia){
                    CharacterController.setSelectedProeficiencia((String)labelAcrobacia.getText());
                    labelAcrobacia.setTextColor(getColor(R.color.golden));
                    selectedLabelAcrobacia = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelAcrobacia.getText());
                    labelAcrobacia.setTextColor(getColor(R.color.black));
                    selectedLabelAcrobacia = false;
                }
            }
        });

        labelFurtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelFurtividade){
                    CharacterController.setSelectedProeficiencia((String)labelFurtividade.getText());
                    labelFurtividade.setTextColor(getColor(R.color.golden));
                    selectedLabelFurtividade = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelFurtividade.getText());
                    labelFurtividade.setTextColor(getColor(R.color.black));
                    selectedLabelFurtividade = false;
                }
            }
        });

        labelHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelHistoria){
                    CharacterController.setSelectedProeficiencia((String)labelHistoria.getText());
                    labelHistoria.setTextColor(getColor(R.color.golden));
                    selectedLabelHistoria = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelHistoria.getText());
                    labelHistoria.setTextColor(getColor(R.color.black));
                    selectedLabelHistoria = false;
                }
            }
        });

        labelInvestigacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelInvestigacao){
                    CharacterController.setSelectedProeficiencia((String)labelInvestigacao.getText());
                    labelInvestigacao.setTextColor(getColor(R.color.golden));
                    selectedLabelInvestigacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelInvestigacao.getText());
                    labelInvestigacao.setTextColor(getColor(R.color.black));
                    selectedLabelInvestigacao = false;
                }
            }
        });

        labelNatureza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelNatureza){
                    CharacterController.setSelectedProeficiencia((String)labelNatureza.getText());
                    labelNatureza.setTextColor(getColor(R.color.golden));
                    selectedLabelNatureza = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelNatureza.getText());
                    labelNatureza.setTextColor(getColor(R.color.black));
                    selectedLabelNatureza = false;
                }
            }
        });

        labelSobrevivencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelSobrevivencia){
                    CharacterController.setSelectedProeficiencia((String)labelSobrevivencia.getText());
                    labelSobrevivencia.setTextColor(getColor(R.color.golden));
                    selectedLabelSobrevivencia = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelSobrevivencia.getText());
                    labelSobrevivencia.setTextColor(getColor(R.color.black));
                    selectedLabelSobrevivencia = false;
                }
            }
        });

        labelAtuacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelAtuacao){
                    CharacterController.setSelectedProeficiencia((String)labelAtuacao.getText());
                    labelAtuacao.setTextColor(getColor(R.color.golden));
                    selectedLabelAtuacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelAtuacao.getText());
                    labelAtuacao.setTextColor(getColor(R.color.black));
                    selectedLabelAtuacao = false;
                }
            }
        });

        labelEnganacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelEnganacao){
                    CharacterController.setSelectedProeficiencia((String)labelEnganacao.getText());
                    labelEnganacao.setTextColor(getColor(R.color.golden));
                    selectedLabelEnganacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelEnganacao.getText());
                    labelEnganacao.setTextColor(getColor(R.color.black));
                    selectedLabelEnganacao = false;
                }
            }
        });

        labelIntimidacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelIntimidacao){
                    CharacterController.setSelectedProeficiencia((String)labelIntimidacao.getText());
                    labelIntimidacao.setTextColor(getColor(R.color.golden));
                    selectedLabelIntimidacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelIntimidacao.getText());
                    labelIntimidacao.setTextColor(getColor(R.color.black));
                    selectedLabelIntimidacao = false;
                }
            }
        });

        labelProvocacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelProvocacao){
                    CharacterController.setSelectedProeficiencia((String)labelProvocacao.getText());
                    labelProvocacao.setTextColor(getColor(R.color.golden));
                    selectedLabelProvocacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelProvocacao.getText());
                    labelProvocacao.setTextColor(getColor(R.color.black));
                    selectedLabelProvocacao = false;
                }
            }
        });

        labelHaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelHaki){
                    CharacterController.setSelectedProeficiencia((String)labelHaki.getText());
                    labelHaki.setTextColor(getColor(R.color.golden));
                    selectedLabelHaki = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelHaki.getText());
                    labelHaki.setTextColor(getColor(R.color.black));
                    selectedLabelHaki = false;
                }
            }
        });

        labelIntuicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelIntuicao){
                    CharacterController.setSelectedProeficiencia((String)labelIntuicao.getText());
                    labelIntuicao.setTextColor(getColor(R.color.golden));
                    selectedLabelIntuicao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelIntuicao.getText());
                    labelIntuicao.setTextColor(getColor(R.color.black));
                    selectedLabelIntuicao = false;
                }
            }
        });

        labelPercepcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelPercepcao){
                    CharacterController.setSelectedProeficiencia((String)labelPercepcao.getText());
                    labelPercepcao.setTextColor(getColor(R.color.golden));
                    selectedLabelPercepcao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelPercepcao.getText());
                    labelPercepcao.setTextColor(getColor(R.color.black));
                    selectedLabelPercepcao = false;
                }
            }
        });

        labelSobrenatural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelSobrenatural){
                    CharacterController.setSelectedProeficiencia((String)labelSobrenatural.getText());
                    labelSobrenatural.setTextColor(getColor(R.color.golden));
                    selectedLabelSobrenatural = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelSobrenatural.getText());
                    labelSobrenatural.setTextColor(getColor(R.color.black));
                    selectedLabelSobrenatural = false;
                }
            }
        });

        labelSorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelSorte){
                    CharacterController.setSelectedProeficiencia((String)labelSorte.getText());
                    labelSorte.setTextColor(getColor(R.color.golden));
                    selectedLabelSorte = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelSorte.getText());
                    labelSorte.setTextColor(getColor(R.color.black));
                    selectedLabelSorte = false;
                }
            }
        });

        labelPrestidigitacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelPrestidigitacao){
                    CharacterController.setSelectedProeficiencia((String)labelPrestidigitacao.getText());
                    labelPrestidigitacao.setTextColor(getColor(R.color.golden));
                    selectedLabelPrestidigitacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelPrestidigitacao.getText());
                    labelPrestidigitacao.setTextColor(getColor(R.color.black));
                    selectedLabelPrestidigitacao = false;
                }
            }
        });

        labelPersuasao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelPersuasao){
                    CharacterController.setSelectedProeficiencia((String)labelPersuasao.getText());
                    labelPersuasao.setTextColor(getColor(R.color.golden));
                    selectedLabelPersuasao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelPersuasao.getText());
                    labelPersuasao.setTextColor(getColor(R.color.black));
                    selectedLabelPersuasao = false;
                }
            }
        });

    }

}