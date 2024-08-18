package com.example.spellsop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;
import com.example.spellsop.viewHolder.RecyclerAlcanceViewHolder;
import com.example.spellsop.viewHolder.RecyclerEstiloCombateViewHolder;

import java.util.ArrayList;

public class RecyclerAlcanceAdapter extends RecyclerView.Adapter<RecyclerAlcanceViewHolder> {

    Context context;
    ArrayList<String> itens;

    public RecyclerAlcanceAdapter(Context context, ArrayList<String> itens){
        this.context = context;
        this.itens = itens;
    }

    @Override
    public RecyclerAlcanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.card_item_filtro, parent, false);

        return new RecyclerAlcanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAlcanceViewHolder holder, int position) {
        String item = itens.get(position);
        holder.labelItem.setText(item);
        holder.imgCheck.setVisibility(View.INVISIBLE);

        // Evento selecionando item
        holder.cardAlcance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.imgCheck.getVisibility() == View.INVISIBLE){
                    holder.imgCheck.setVisibility(View.VISIBLE);
                }else{
                    holder.imgCheck.setVisibility(View.INVISIBLE);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
