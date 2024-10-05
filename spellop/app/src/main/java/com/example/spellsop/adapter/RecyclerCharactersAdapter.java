package com.example.spellsop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;
import com.example.spellsop.controller.CharacterController;
import com.example.spellsop.model.Personagem;
import com.example.spellsop.viewHolder.RecyclerCharactersViewHolder;

import java.util.ArrayList;

public class RecyclerCharactersAdapter extends RecyclerView.Adapter<RecyclerCharactersViewHolder> {

    private Context context;
    private ArrayList<Personagem> itens;

    public RecyclerCharactersAdapter(Context context){
        this.context = context;
        this.itens = CharacterController.getPersonagens();
    }

    @NonNull
    @Override
    public RecyclerCharactersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_characters, parent, false);

        return new RecyclerCharactersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerCharactersViewHolder holder, int position) {

        Personagem item = itens.get(position);
        holder.labelNome.setText(item.getNome());
        holder.labelEstiloCombate.setText(item.getEstiloCombate());
        holder.labelEspecie.setText(item.getEspecie());
        holder.labelNivel.setText("Nivel: "+ String.valueOf(item.getNivel()));
        if(item.getImagemPersonagem() != null){
            holder.imgPersonagem.setImageBitmap(item.getImagemPersonagem());
        }

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
