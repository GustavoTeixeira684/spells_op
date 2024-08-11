package com.example.spellsop;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.content.Context;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.io.Console;

import com.example.spellsop.databinding.ActivityMainBinding;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Spells spellsFragment; // Supondo que você tenha uma referência ao fragmento

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Inclui a regra para poder trocar as telas
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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


//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });


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
//            files = assetManager.list("tecnicas");
            Tecnicas.setArquivos(assetManager.list("tecnicas"));


        } catch (Exception e) {
//            throw new RuntimeException(e);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(e.getMessage());
            AlertDialog alert = builder.create();
            alert.show();

        }

    }


}