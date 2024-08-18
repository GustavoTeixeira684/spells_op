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
import com.example.spellsop.viewHolder.RecyclerGrauViewHolder;

import java.util.ArrayList;

public class RecyclerGrauAdapter extends RecyclerView.Adapter<RecyclerGrauViewHolder> {

    private Context context;
    private ArrayList<String> itens;
    private TextView labelQntGrau, labelLimparGrau;

    public RecyclerGrauAdapter(Context context, ArrayList<String> itens, TextView labelQntGrau, TextView labelLimparGrau){
        this.context = context;
        this.itens = itens;
        this.labelQntGrau = labelQntGrau;
        this.labelLimparGrau = labelLimparGrau;
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
                    SpellsController.atualizaItemFiltroInserido("grau", labelQntGrau, labelLimparGrau);
                }else{
                    holder.imgCheck.setVisibility(View.INVISIBLE);
                    SpellsController.atualizaItemFiltroRemovido("grau", labelQntGrau, labelLimparGrau);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
