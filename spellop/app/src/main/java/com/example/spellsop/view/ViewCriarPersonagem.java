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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.spellsop.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;

public class ViewCriarPersonagem extends AppCompatActivity {

    ImageButton btnFechar;
    AutoCompleteTextView txtProeficiencias;
    BottomSheetDialog bottomSheetDialog;
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
        bottomSheetDialog = new BottomSheetDialog(ViewCriarPersonagem.this); // Instanciando um objeto BottomSheetDialog
        view = LayoutInflater.from(ViewCriarPersonagem.this).inflate(R.layout.activity_view_bottom_sheet_dialog_proeficiencias, null, false);
        bottomSheetDialog.setContentView(view);

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

    }

}