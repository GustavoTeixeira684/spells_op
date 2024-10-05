package com.example.spellsop.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.spellsop.R;
import com.example.spellsop.adapter.RecyclerCharactersAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Character#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Character extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerCharactersAdapter charactersAdapter;
    private ImageButton imgBtnAdd;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Character() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Character.
     */
    // TODO: Rename and change types and number of parameters
    public static Character newInstance(String param1, String param2) {
        Character fragment = new Character();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerCharacters);
        charactersAdapter = new RecyclerCharactersAdapter(getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(charactersAdapter);

        // Instanciando objetos de layoyut
        imgBtnAdd = view.findViewById(R.id.imgBtnAdd);
        imgBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ViewCriarPersonagem.class);
//                intent.putExtra("detalhe_tecnica",item);
                startActivity(intent);
            }
        });


        return view;
    }
}