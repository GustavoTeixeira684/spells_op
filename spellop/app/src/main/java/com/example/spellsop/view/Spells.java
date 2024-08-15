package com.example.spellsop.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import com.example.spellsop.R;
import com.example.spellsop.adapter.RecyclerSpellsAdapter;
import com.example.spellsop.controller.SpellsController;
import com.example.spellsop.model.Tecnica;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Spells#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Spells extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerSpellsAdapter spellsAdapter;

    // private attributes
    private int tipo_busca;

    public Spells() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Spells.
     */
    // TODO: Rename and change types and number of parameters
    public static Spells newInstance(String param1, String param2) {
        Spells fragment = new Spells();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_spells, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.lista_tecnicas);
        spellsAdapter = new RecyclerSpellsAdapter(getContext(), SpellsController.getTecnicas());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(spellsAdapter);

        // Declarações
        SearchView txtPesquisaSpell = view.findViewById(R.id.txtPesquisaSpell);
        Spinner spinner = view.findViewById(R.id.spinner);
        ArrayList<String> itens_busca = new ArrayList<>();
        itens_busca.add("Busca por Nome");
        itens_busca.add("Busca por Estilo de Combate");
        itens_busca.add("Busca por Requisito");
        itens_busca.add("Busca por Descrição");
        ArrayAdapter<String> modo_busca = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, itens_busca);
        modo_busca.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(modo_busca);
        tipo_busca = 0;


        // Funcões
        txtPesquisaSpell.clearFocus();
        txtPesquisaSpell.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(!newText.isEmpty()){
                    pesquisar(newText);
                }else{
                    spellsAdapter.listaCompleta();
                }

                return true;
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipo_busca = (int) spinner.getSelectedItemId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    private void pesquisar(String newText) {

        ArrayList<Tecnica> listaFiltrada = new ArrayList<>();
        switch(tipo_busca){
            case 0: // Por nome/titulo
                for(Tecnica item : spellsAdapter.getItens()){
                    if(item.getTitulo().toLowerCase().contains(newText.toLowerCase())){
                        listaFiltrada.add(item);
                    }
                }
                break;
            case 1: // Por estilo de combate
                for(Tecnica item : spellsAdapter.getItens()){
                    if(item.getEstilo().toLowerCase().contains(newText.toLowerCase())){
                        listaFiltrada.add(item);
                    }
                }
                break;
            case 2: // Por requisito
                for(Tecnica item : spellsAdapter.getItens()){
                    if(item.getRequisito().toLowerCase().contains(newText.toLowerCase())){
                        listaFiltrada.add(item);
                    }
                }
                break;
            default: // Por descrição
                String descricao, texto;
                for(Tecnica item : spellsAdapter.getItens()){
                    // Normalizando e tirando ascentos
                    descricao = Normalizer.normalize(item.getDescricao(), Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();
                    texto = Normalizer.normalize(newText, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();
                    if(descricao.contains(texto)){
                        listaFiltrada.add(item);
                    }
                }
                break;
        }
        spellsAdapter.setListaFiltrada(listaFiltrada);

    }

}