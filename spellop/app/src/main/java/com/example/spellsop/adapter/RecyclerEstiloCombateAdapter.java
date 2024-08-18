package com.example.spellsop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;
import com.example.spellsop.viewHolder.RecyclerEstiloCombateViewHolder;
import com.example.spellsop.viewHolder.RecyclerSpellsViewHolder;

import java.util.ArrayList;

public class RecyclerEstiloCombateAdapter extends RecyclerView.Adapter<RecyclerEstiloCombateViewHolder> {

    private Context context;
    private ArrayList<String> itens; // Arraylist que carrega os itens que serão exibidos


    public RecyclerEstiloCombateAdapter(Context context, ArrayList<String> itens){
        this.context = context;
        this.itens = itens;
    }

    @Override
    public RecyclerEstiloCombateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(this.context).inflate(R.layout.card_item_filtro, parent, false);

        return new RecyclerEstiloCombateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerEstiloCombateViewHolder holder, int position) {
        String item = itens.get(position);
        holder.labelItem.setText(item);
        holder.imgCheck.setVisibility(View.INVISIBLE);

        // Evento selecionando item
        holder.cardEstiloCombate.setOnClickListener(new View.OnClickListener() {
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
