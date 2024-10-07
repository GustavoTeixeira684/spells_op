package com.example.spellsop.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;

public class RecyclerAdicionarTecnicasViewHolder extends RecyclerView.ViewHolder  {

    public TextView labelNome, labelEstilo, labelRequisito, labelGrau;

    public RecyclerAdicionarTecnicasViewHolder(@NonNull View itemView) {
        super(itemView);
        labelNome = itemView.findViewById(R.id.labelNome);
        labelEstilo = itemView.findViewById(R.id.labelEstilo);
        labelRequisito = itemView.findViewById(R.id.labelRequisito);
        labelGrau = itemView.findViewById(R.id.labelGrau);
    }
}
