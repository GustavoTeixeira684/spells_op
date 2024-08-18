package com.example.spellsop.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;

public class RecyclerRequisitoViewHolder extends RecyclerView.ViewHolder {

    public TextView labelItem;
    public ImageView imgCheck;
    public CardView cardRequisito;

    public RecyclerRequisitoViewHolder(@NonNull View itemView) {
        super(itemView);
        labelItem = itemView.findViewById(R.id.labelItem);
        imgCheck = itemView.findViewById(R.id.imgCheck);
        cardRequisito = itemView.findViewById(R.id.cardItemFiltro);
    }
}
