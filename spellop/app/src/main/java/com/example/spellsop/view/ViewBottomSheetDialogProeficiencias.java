package com.example.spellsop.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.spellsop.R;
import com.example.spellsop.controller.CharacterController;

public class ViewBottomSheetDialogProeficiencias extends AppCompatActivity {

    private TextView labelAtletismo, labelAcrobacia, labelFurtividade, labelHistoria, labelInvestigacao, labelNatureza,
    labelSobrevivencia, labelAtuacao, labelEnganacao, labelIntimidacao, labelPersuasao, labelProvocacao, labelHaki, labelIntuicao,
    labelPercepcao, labelSobrenatural, labelSorte, labelPrestidigitacao;

    private boolean selectedLabelAtletismo = false, selectedLabelAcrobacia = false, selectedLabelFurtividade = false, selectedLabelHistoria = false, selectedLabelInvestigacao = false,
    selectedLabelNatureza = false, selectedLabelSobrevivencia = false, selectedLabelAtuacao = false, selectedLabelEnganacao = false, selectedLabelIntimidacao = false, selectedLabelPersuasao = false, selectedLabelProvocacao = false,
    selectedLabelHaki = false, selectedLabelIntuicao = false, selectedLabelPercepcao = false, selectedLabelSobrenatural = false, selectedLabelSorte = false,
    selectedLabelPrestidigitacao = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        labelAtletismo = this.findViewById(R.id.labelAtletismo);
        labelAcrobacia = this.findViewById(R.id.labelAcrobacia);
        labelFurtividade = this.findViewById(R.id.labelFurtividade);
        labelHistoria = this.findViewById(R.id.labelHistoria);
        labelInvestigacao = this.findViewById(R.id.labelInvestigacao);
        labelNatureza = this.findViewById(R.id.labelNatureza);
        labelSobrevivencia = this.findViewById(R.id.labelSobrevivencia);
        labelAtuacao = this.findViewById(R.id.labelAtuacao);
        labelEnganacao = this.findViewById(R.id.labelEnganacao);
        labelIntimidacao = this.findViewById(R.id.labelIntimidacao);
        labelProvocacao = this.findViewById(R.id.labelProvocacao);
        labelHaki = this.findViewById(R.id.labelHaki);
        labelIntuicao = this.findViewById(R.id.labelIntuicao);
        labelPercepcao = this.findViewById(R.id.labelPercepcao);
        labelSobrenatural = this.findViewById(R.id.labelSobrenatural);
        labelSorte = this.findViewById(R.id.labelSorte);
        labelPrestidigitacao = this.findViewById(R.id.labelPrestidigitacao);
        labelPersuasao = this.findViewById(R.id.labelPersuasao);




        setContentView(R.layout.activity_view_bottom_sheet_dialog_proeficiencias);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setEventos(){

        labelAtletismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelAtletismo){
                    CharacterController.setSelectedProeficiencia((String)labelAtletismo.getText());
                    selectedLabelAtletismo = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelAtletismo.getText());
                    selectedLabelAtletismo = false;
                }
            }
        });

        labelAcrobacia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelAcrobacia){
                    CharacterController.setSelectedProeficiencia((String)labelAcrobacia.getText());
                    selectedLabelAcrobacia = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelAcrobacia.getText());
                    selectedLabelAcrobacia = false;
                }
            }
        });

        labelFurtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelFurtividade){
                    CharacterController.setSelectedProeficiencia((String)labelFurtividade.getText());
                    selectedLabelFurtividade = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelFurtividade.getText());
                    selectedLabelFurtividade = false;
                }
            }
        });

        labelHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelHistoria){
                    CharacterController.setSelectedProeficiencia((String)labelHistoria.getText());
                    selectedLabelHistoria = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelHistoria.getText());
                    selectedLabelHistoria = false;
                }
            }
        });

        labelInvestigacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelInvestigacao){
                    CharacterController.setSelectedProeficiencia((String)labelInvestigacao.getText());
                    selectedLabelInvestigacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelInvestigacao.getText());
                    selectedLabelInvestigacao = false;
                }
            }
        });

        labelNatureza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelNatureza){
                    CharacterController.setSelectedProeficiencia((String)labelNatureza.getText());
                    selectedLabelNatureza = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelNatureza.getText());
                    selectedLabelNatureza = false;
                }
            }
        });

        labelSobrevivencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelSobrevivencia){
                    CharacterController.setSelectedProeficiencia((String)labelSobrevivencia.getText());
                    selectedLabelSobrevivencia = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelSobrevivencia.getText());
                    selectedLabelSobrevivencia = false;
                }
            }
        });

        labelAtuacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelAtuacao){
                    CharacterController.setSelectedProeficiencia((String)labelAtuacao.getText());
                    selectedLabelAtuacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelAtuacao.getText());
                    selectedLabelAtuacao = false;
                }
            }
        });

        labelEnganacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelEnganacao){
                    CharacterController.setSelectedProeficiencia((String)labelEnganacao.getText());
                    selectedLabelEnganacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelEnganacao.getText());
                    selectedLabelEnganacao = false;
                }
            }
        });

        labelIntimidacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelIntimidacao){
                    CharacterController.setSelectedProeficiencia((String)labelIntimidacao.getText());
                    selectedLabelIntimidacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelIntimidacao.getText());
                    selectedLabelIntimidacao = false;
                }
            }
        });

        labelProvocacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelProvocacao){
                    CharacterController.setSelectedProeficiencia((String)labelProvocacao.getText());
                    selectedLabelProvocacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelProvocacao.getText());
                    selectedLabelProvocacao = false;
                }
            }
        });

        labelHaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelHaki){
                    CharacterController.setSelectedProeficiencia((String)labelHaki.getText());
                    selectedLabelHaki = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelHaki.getText());
                    selectedLabelHaki = false;
                }
            }
        });

        labelIntuicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelIntuicao){
                    CharacterController.setSelectedProeficiencia((String)labelIntuicao.getText());
                    selectedLabelIntuicao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelIntuicao.getText());
                    selectedLabelIntuicao = false;
                }
            }
        });

        labelPercepcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelPercepcao){
                    CharacterController.setSelectedProeficiencia((String)labelPercepcao.getText());
                    selectedLabelPercepcao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelPercepcao.getText());
                    selectedLabelPercepcao = false;
                }
            }
        });

        labelSobrenatural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelSobrenatural){
                    CharacterController.setSelectedProeficiencia((String)labelSobrenatural.getText());
                    selectedLabelSobrenatural = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelSobrenatural.getText());
                    selectedLabelSobrenatural = false;
                }
            }
        });

        labelSorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelSorte){
                    CharacterController.setSelectedProeficiencia((String)labelSorte.getText());
                    selectedLabelSorte = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelSorte.getText());
                    selectedLabelSorte = false;
                }
            }
        });

        labelPrestidigitacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelPrestidigitacao){
                    CharacterController.setSelectedProeficiencia((String)labelPrestidigitacao.getText());
                    selectedLabelPrestidigitacao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelPrestidigitacao.getText());
                    selectedLabelPrestidigitacao = false;
                }
            }
        });

        labelPersuasao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedLabelPersuasao){
                    CharacterController.setSelectedProeficiencia((String)labelPersuasao.getText());
                    selectedLabelPersuasao = true;
                }else{
                    CharacterController.removeSelectedProeficiencia((String)labelPersuasao.getText());
                    selectedLabelPersuasao = false;
                }
            }
        });

    }

}