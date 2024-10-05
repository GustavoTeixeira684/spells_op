package com.example.spellsop.view;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.spellsop.R;
import com.example.spellsop.controller.SpellsController;
import com.example.spellsop.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Spells spellsFragment; // Supondo que você tenha uma referência ao fragmento

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inclui a regra para poder trocar as telas
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getTechniques();

        this.replaceFragment(new Spells());
        binding.bottomNavigationViewMain.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.spells_option) {
                replaceFragment(new Spells());
            } else if (item.getItemId() == R.id.character_option) {
                replaceFragment(new Character());
            } else if (item.getItemId() == R.id.settings_option) {
                replaceFragment(new Settings());
            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_main, fragment)
                .commit();
    }

    private void getTechniques() {

        // Carrega as técnicas na memória
        AssetManager assetManager = getAssets();

        String[] files = new String[0];
        try {
            String[] tecnicas_padrao = assetManager.list("tecnicas");
            for(int i = 0; i < Objects.requireNonNull(tecnicas_padrao).length; i++) {
               tecnicas_padrao[i] = "tecnicas/"+tecnicas_padrao[i];
            }
            SpellsController.carregaTecnicas(MainActivity.this, Objects.requireNonNull(tecnicas_padrao));

            funcaoTestaLeituraPersonagem(assetManager); // Executa função para apenas testar se o programa está lendo o json do personagem


        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(e.getMessage());
            AlertDialog alert = builder.create();
            alert.show();

        }

    }

    // Função criada apenas para testar se o programa está lendo o json do personagem
    private void funcaoTestaLeituraPersonagem(AssetManager assetManager) throws IOException {

        String[] arquivos = assetManager.list("");
        String template_personagem = "";
        boolean diretorioCriado = false;
        for(int i = 0; i < Objects.requireNonNull(arquivos).length; i++){
            if(arquivos[i].contains(".json")){
                template_personagem = arquivos[i];
            }
        }

        // Transfere para o armazenamento local
        File diretorio = new File(MainActivity.this.getFilesDir(), "personagens");
        if(!diretorio.exists() || !diretorio.isDirectory()){
            diretorioCriado = diretorio.mkdir();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(template_personagem), StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line+"\n");
            }
            Log.d("AIIINN PAPAI",stringBuilder.toString());
            bufferedReader.close();
            File arquivo = new File(MainActivity.this.getFilesDir(), diretorio.getName()+"/oscar_d_alho.json");
            FileOutputStream fos = new FileOutputStream(arquivo);
            OutputStreamWriter out = new OutputStreamWriter(fos);
            out.write(stringBuilder.toString());
            out.close();
            fos.close();
        }

    }

}