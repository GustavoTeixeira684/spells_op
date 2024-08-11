package com.example.spellsop.viewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;

public class RecyclerSpellsViewHolder extends RecyclerView.ViewHolder {

    public TextView labelNome, labelRequisito, labelAlcance, labelGrau;
    public ImageButton imgBtnAdd;

    public RecyclerSpellsViewHolder(@NonNull View itemView) {
        super(itemView);
        labelNome = itemView.findViewById(R.id.labelNome);
        labelAlcance = itemView.findViewById(R.id.labelAlcance);
        labelGrau = itemView.findViewById(R.id.labelGrau);
        labelRequisito = itemView.findViewById(R.id.labelRequisito);
        imgBtnAdd = itemView.findViewById(R.id.imgBtnAdd);

    }
}
