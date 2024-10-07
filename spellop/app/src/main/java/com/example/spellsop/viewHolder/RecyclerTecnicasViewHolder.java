package com.example.spellsop.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;

public class RecyclerTecnicasViewHolder extends RecyclerView.ViewHolder{

    public TextView txtNomeTecnica;

    public RecyclerTecnicasViewHolder(@NonNull View itemView) {
        super(itemView);
        txtNomeTecnica = itemView.findViewById(R.id.textView);
    }
}
