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
import com.example.spellsop.viewHolder.RecyclerDuracaoViewHolder;

import java.util.ArrayList;
import java.util.Objects;

public class RecyclerDuracaoAdapter extends RecyclerView.Adapter<RecyclerDuracaoViewHolder> {

    private Context context;
    private ArrayList<String> itens;
    private TextView labelQntDuracao, labelLimparDuracao;

    public RecyclerDuracaoAdapter(Context context, ArrayList<String> itens, TextView labelQntDuracao, TextView labelLimparDuracao){
        this.context = context;
        this.itens = itens;
        this.labelQntDuracao = labelQntDuracao;
        this.labelLimparDuracao = labelLimparDuracao;
    }

    @Override
    public RecyclerDuracaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.card_item_filtro, parent, false);

        return new RecyclerDuracaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDuracaoViewHolder holder, int position) {
        String item = itens.get(position);
        holder.labelItem.setText(item);
        if(Objects.requireNonNull(SpellsController.getFiltros().get("duracao")).contains(item)){
            holder.imgCheck.setVisibility(View.VISIBLE);
        }else{
            holder.imgCheck.setVisibility(View.INVISIBLE);
        }

        // Evento selecionando item
        holder.cardDuracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.imgCheck.getVisibility() == View.INVISIBLE){
                    holder.imgCheck.setVisibility(View.VISIBLE);
                    SpellsController.atualizaItemFiltroInserido("duracao", labelQntDuracao, labelLimparDuracao, item);
                }else{
                    holder.imgCheck.setVisibility(View.INVISIBLE);
                    SpellsController.atualizaItemFiltroRemovido("duracao", labelQntDuracao, labelLimparDuracao, item);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
