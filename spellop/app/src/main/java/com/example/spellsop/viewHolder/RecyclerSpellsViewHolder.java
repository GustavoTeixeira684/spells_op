package com.example.spellsop.viewHolder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;

public class RecyclerSpellsViewHolder extends RecyclerView.ViewHolder {

    public TextView labelNome, labelEstilo, labelRequisito, labelGrau;
    public ImageButton imgBtnAdd;

    public RecyclerSpellsViewHolder(@NonNull View itemView) {
        super(itemView);
        labelNome = itemView.findViewById(R.id.labelNome);
        labelRequisito = itemView.findViewById(R.id.labelRequisito);
        labelGrau = itemView.findViewById(R.id.labelGrau);
        labelEstilo = itemView.findViewById(R.id.labelEstilo);
        imgBtnAdd = itemView.findViewById(R.id.imgBtnAdd);

    }
}
