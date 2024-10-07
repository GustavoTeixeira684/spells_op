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

import java.util.ArrayList;

public class RecyclerAtaquesAdapter extends RecyclerView.Adapter<RecyclerAtaquesViewHolder> {

    Context context;
    ArrayList<String> itens;
    TextView txtNomeAtaque;

    public RecyclerAtaquesAdapter(Context context, ArrayList<String> itens){
        this.context = context;
        this.itens = itens;
    }

    @NonNull
    @Override
    public RecyclerAtaquesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.card_ataque, parent, false);
        return new RecyclerAtaquesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAtaquesViewHolder holder, int position) {

        String item = itens.get(position);
        holder.txtNomeAtaque.setText(item);

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
