package com.example.spellsop.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;

public class RecyclerAtaquesViewHolder extends RecyclerView.ViewHolder{

    public TextView txtNomeAtaque;

    public RecyclerAtaquesViewHolder(@NonNull View itemView) {
        super(itemView);
        txtNomeAtaque = itemView.findViewById(R.id.textView);
    }
}
