package com.example.spellsop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;
import com.example.spellsop.viewHolder.RecyclerEstiloCombateViewHolder;
import com.example.spellsop.viewHolder.RecyclerGrauViewHolder;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class RecyclerGrauAdapter extends RecyclerView.Adapter<RecyclerGrauViewHolder> {

    Context context;
    ArrayList<String> itens;

    public RecyclerGrauAdapter(Context context, ArrayList<String> itens){
        this.context = context;
        this.itens = itens;
    }

    @Override
    public RecyclerGrauViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.card_item_filtro, parent, false);

        return new RecyclerGrauViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerGrauViewHolder holder, int position) {

        String item = itens.get(position);
        holder.labelItem.setText(item);
        holder.imgCheck.setVisibility(View.INVISIBLE);

        // Evento selecionando item
        holder.cardGrau.setOnClickListener(new View.OnClickListener() {
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
