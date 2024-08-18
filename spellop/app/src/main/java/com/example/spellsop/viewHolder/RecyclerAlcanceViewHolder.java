package com.example.spellsop.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;

public class RecyclerAlcanceViewHolder extends RecyclerView.ViewHolder {

    public TextView labelItem;
    public ImageView imgCheck;
    public CardView cardAlcance;

    public RecyclerAlcanceViewHolder(@NonNull View itemView) {
        super(itemView);
        labelItem = itemView.findViewById(R.id.labelItem);
        imgCheck = itemView.findViewById(R.id.imgCheck);
        cardAlcance = itemView.findViewById(R.id.cardItemFiltro);
    }
}
