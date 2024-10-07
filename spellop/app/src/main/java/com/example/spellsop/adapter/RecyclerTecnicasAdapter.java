package com.example.spellsop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;
import com.example.spellsop.viewHolder.RecyclerAtaquesViewHolder;
import com.example.spellsop.viewHolder.RecyclerTecnicasViewHolder;

import java.util.ArrayList;

public class RecyclerTecnicasAdapter extends RecyclerView.Adapter<RecyclerTecnicasViewHolder> {

    Context context;
    ArrayList<String> itens;

    public RecyclerTecnicasAdapter(Context context, ArrayList<String> itens){
        this.context = context;
        this.itens = itens;
    }

    @NonNull
    @Override
    public RecyclerTecnicasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.card_ataque, parent, false);
        return new RecyclerTecnicasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerTecnicasViewHolder holder, int position) {

        String item = itens.get(position);
        holder.txtNomeTecnica.setText(item);

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
