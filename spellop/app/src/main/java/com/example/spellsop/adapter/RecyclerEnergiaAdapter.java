package com.example.spellsop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;
import com.example.spellsop.controller.SpellsController;
import com.example.spellsop.viewHolder.RecyclerEnergiaViewHolder;

import java.util.ArrayList;

public class RecyclerEnergiaAdapter extends RecyclerView.Adapter<RecyclerEnergiaViewHolder> {

    private Context context;
    private ArrayList<String> itens;
    private TextView labelQntEnergia, labelLimparEnergia;

    public RecyclerEnergiaAdapter(Context context, ArrayList<String> itens, TextView labelQntEnergia, TextView labelLimparEnergia){
        this.context = context;
        this.itens = itens;
        this.labelQntEnergia = labelQntEnergia;
        this.labelLimparEnergia = labelLimparEnergia;
    }

    @Override
    public RecyclerEnergiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.card_item_filtro, parent, false);

        return new RecyclerEnergiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerEnergiaViewHolder holder, int position) {
        String item = itens.get(position);
        holder.labelItem.setText(item);
        holder.imgCheck.setVisibility(View.INVISIBLE);

        // Evento selecionando item
        holder.cardEnergia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.imgCheck.getVisibility() == View.INVISIBLE){
                    holder.imgCheck.setVisibility(View.VISIBLE);
                    SpellsController.atualizaItemFiltroInserido("energia", labelQntEnergia, labelLimparEnergia);
                }else{
                    holder.imgCheck.setVisibility(View.INVISIBLE);
                    SpellsController.atualizaItemFiltroRemovido("energia", labelQntEnergia, labelLimparEnergia);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
