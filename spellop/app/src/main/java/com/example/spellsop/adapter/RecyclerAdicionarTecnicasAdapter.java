package com.example.spellsop.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;
import com.example.spellsop.model.Tecnica;
import com.example.spellsop.viewHolder.RecyclerAdicionarTecnicasViewHolder;
import com.example.spellsop.viewHolder.RecyclerSpellsViewHolder;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecyclerAdicionarTecnicasAdapter extends RecyclerView.Adapter<RecyclerAdicionarTecnicasViewHolder>{

    private Context context;
    private ArrayList<Tecnica> itens;

    public void setItens(ArrayList<Tecnica> itens){
        this.itens = itens;
    }

    public RecyclerAdicionarTecnicasAdapter(Context context, ArrayList<Tecnica> itens){
        this.context = context;
        this.itens = itens;
    }

    @NonNull
    @Override
    public RecyclerAdicionarTecnicasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(this.context).inflate(R.layout.card_tecnicas_cadastro_personagem, parent, false);
        return new RecyclerAdicionarTecnicasViewHolder(view);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdicionarTecnicasViewHolder holder, int position) {

        Tecnica item = itens.get(position);
        holder.labelNome.setText(item.getTitulo());
        holder.labelEstilo.setText(item.getEstilo());
        holder.labelRequisito.setText(item.getRequisito());
        holder.labelGrau.setText(item.getGrau() + "°");

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
