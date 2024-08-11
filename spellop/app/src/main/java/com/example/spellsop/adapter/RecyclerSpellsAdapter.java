package com.example.spellsop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;
import com.example.spellsop.viewHolder.RecyclerSpellsViewHolder;

import java.util.ArrayList;

public class RecyclerSpellsAdapter extends RecyclerView.Adapter<RecyclerSpellsViewHolder> {

    private Context context;
    private ArrayList<String> itens; // Mudar. fiz só para teste

    public RecyclerSpellsAdapter(Context context, ArrayList<String> itens) {
        this.context = context;
        this.itens = itens;
    }

    @NonNull
    @Override
    public RecyclerSpellsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(this.context).inflate(R.layout.card_spells, parent, false);
        RecyclerSpellsViewHolder viewHolder = new RecyclerSpellsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerSpellsViewHolder holder, int position) {
        // Mudar. Fiz só para teste
           String item = itens.get(position);
           holder.labelNome.setText(item);
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
