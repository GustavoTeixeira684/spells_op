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
import com.example.spellsop.viewHolder.RecyclerRequisitoViewHolder;

import java.util.ArrayList;

public class RecyclerRequisitoAdapter extends RecyclerView.Adapter<RecyclerRequisitoViewHolder> {

    private Context context;
    private ArrayList<String> itens; // Arraylist que carrega os itens que serão exibidos
    private TextView labelQntRequisito, labelLimparRequisito;

    public RecyclerRequisitoAdapter(Context context, ArrayList<String> itens, TextView labelQntRequisito, TextView labelLimparRequisito) {
        this.context = context;
        this.itens = itens;
        this.labelQntRequisito = labelQntRequisito;
        this.labelLimparRequisito = labelLimparRequisito;
    }

    @Override
    public RecyclerRequisitoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(this.context).inflate(R.layout.card_item_filtro, parent, false);

        return new RecyclerRequisitoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerRequisitoViewHolder holder, int position) {
        String item = itens.get(position);
        holder.labelItem.setText(item);
        holder.imgCheck.setVisibility(View.INVISIBLE);

        // Evento selecionando item
        holder.cardRequisito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.imgCheck.getVisibility() == View.INVISIBLE) {
                    holder.imgCheck.setVisibility(View.VISIBLE);
                    SpellsController.atualizaItemFiltroInserido("requisito", labelQntRequisito, labelLimparRequisito);
                } else {
                    holder.imgCheck.setVisibility(View.INVISIBLE);
                    SpellsController.atualizaItemFiltroRemovido("requisito", labelQntRequisito, labelLimparRequisito);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}