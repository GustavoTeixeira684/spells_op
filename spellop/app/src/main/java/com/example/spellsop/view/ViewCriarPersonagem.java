package com.example.spellsop.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;
import com.example.spellsop.adapter.RecyclerAtaquesAdapter;
import com.example.spellsop.controller.CharacterController;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ViewCriarPersonagem extends AppCompatActivity {

    ImageButton btnFechar;
    AutoCompleteTextView txtProeficiencias;
    TextInputEditText txtAddNome, txtAddBonusAcerto, txtAddAlcance, txtAddDano;
    BottomSheetDialog bottomSheetDialog, bottomSheetDialogAtaques;
    RecyclerAtaquesAdapter ataquesAdapter;
    ArrayList<String> ataques;

    ImageButton imgBtnAddAtaque;
    Button btnInserir, btnCancelar;

    TextView labelAtletismo, labelAcrobacia, labelFurtividade, labelHistoria, labelInvestigacao, labelNatureza,
    labelSobrevivencia, labelAtuacao, labelEnganacao, labelIntimidacao, labelPersuasao, labelProvocacao, labelHaki, labelIntuicao,
    labelPercepcao, labelSobrenatural, labelSorte, labelPrestidigitacao;

    boolean selectedLabelAtletismo = false, selectedLabelAcrobacia = false, selectedLabelFurtividade = false, selectedLabelHistoria = false, selectedLabelInvestigacao = false,
            selectedLabelNatureza = false, selectedLabelSobrevivencia = false, selectedLabelAtuacao = false, selectedLabelEnganacao = false, selectedLabelIntimidacao = false, selectedLabelPersuasao = false, selectedLabelProvocacao = false,
            selectedLabelHaki = false, selectedLabelIntuicao = false, selectedLabelPercepcao = false, selectedLabelSobrenatural = false, selectedLabelSorte = false,
            selectedLabelPrestidigitacao = false;

    View viewProeficiencias, viewAtaques;



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

        RecyclerView recyclerViewAtaques = this.findViewById(R.id.recyclerViewAtaques);
        ataques = new ArrayList<>();
        ataquesAdapter = new RecyclerAtaquesAdapter(this, ataques);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewAtaques.setLayoutManager(layoutManager1);
        recyclerViewAtaques.setAdapter(ataquesAdapter);

        bottomSheetDialog = new BottomSheetDialog(ViewCriarPersonagem.this); // Instanciando um objeto BottomSheetDialog
        viewProeficiencias = LayoutInflater.from(ViewCriarPersonagem.this).inflate(R.layout.proeficiencias_bottom_sheet_layout, null, false);
        bottomSheetDialog.setContentView(viewProeficiencias);

        bottomSheetDialogAtaques = new BottomSheetDialog(ViewCriarPersonagem.this);
        viewAtaques = LayoutInflater.from(ViewCriarPersonagem.this).inflate(R.layout.ataques_bottom_sheet_layout, null, false);
        bottomSheetDialogAtaques.setContentView(viewAtaques);

        labelAtletismo = viewProeficiencias.findViewById(R.id.labelAtletismo);
        labelAcrobacia = viewProeficiencias.findViewById(R.id.labelAcrobacia);
        labelFurtividade = viewProeficiencias.findViewById(R.id.labelFurtividade);
        labelHistoria = viewProeficiencias.findViewById(R.id.labelHistoria);
        labelInvestigacao = viewProeficiencias.findViewById(R.id.labelInvestigacao);
        labelNatureza = viewProeficiencias.findViewById(R.id.labelNatureza);
        labelSobrevivencia = viewProeficiencias.findViewById(R.id.labelSobrevivencia);
        labelAtuacao = viewProeficiencias.findViewById(R.id.labelAtuacao);
        labelEnganacao = viewProeficiencias.findViewById(R.id.labelEnganacao);
        labelIntimidacao = viewProeficiencias.findViewById(R.id.labelIntimidacao);
        labelProvocacao = viewProeficiencias.findViewById(R.id.labelProvocacao);
        labelHaki = viewProeficiencias.findViewById(R.id.labelHaki);
        labelIntuicao = viewProeficiencias.findViewById(R.id.labelIntuicao);
        labelPercepcao = viewProeficiencias.findViewById(R.id.labelPercepcao);
        labelSobrenatural = viewProeficiencias.findViewById(R.id.labelSobrenatural);
        labelSorte = viewProeficiencias.findViewById(R.id.labelSorte);
        labelPrestidigitacao = viewProeficiencias.findViewById(R.id.labelPrestidigitacao);
        labelPersuasao = viewProeficiencias.findViewById(R.id.labelPersuasao);

        imgBtnAddAtaque = this.findViewById(R.id.imgBtnAddAtaque);
        btnCancelar = viewAtaques.findViewById(R.id.btnCancelar);
        btnInserir = viewAtaques.findViewById(R.id.btnInserir);
        txtAddNome = viewAtaques.findViewById(R.id.txtAddNome);
        txtAddAlcance = viewAtaques.findViewById(R.id.txtAddAlcance);
        txtAddBonusAcerto = viewAtaques.findViewById(R.id.txtAddBonusAcerto);
        txtAddDano = viewAtaques.findViewById(R.id.txtAddDano);

        this.setEventos();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setEventos(){

        btnInserir.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                if(!String.valueOf(txtAddNome.getText()).isEmpty() && !String.valueOf(txtAddAlcance.getText()).isEmpty() && !String.valueOf(txtAddDano.getText()).isEmpty() && !String.valueOf(txtAddBonusAcerto.getText()).isEmpty()){
                    ataques.add(String.valueOf(txtAddNome.getText()));
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(String.valueOf(txtAddNome.getText()));
                    temp.add(String.valueOf(txtAddAlcance.getText()));
                    temp.add(String.valueOf(txtAddBonusAcerto.getText()));
                    temp.add(String.valueOf(txtAddDano.getText()));
                    CharacterController.ataques.add(temp);
                    ataquesAdapter.notifyDataSetChanged();
                    btnCancelar.performClick();
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(ViewCriarPersonagem.this);
                    builder.setTitle("FILHO DA PUTA BURRO!");
                    builder.setMessage("Preenche todos os campos cacete!");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAddNome.setText("");
                txtAddAlcance.setText("");
                txtAddBonusAcerto.setText("");
                txtAddDano.setText("");
                bottomSheetDialogAtaques.cancel();
            }
        });

        imgBtnAddAtaque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialogAtaques.show();
            }
        });

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