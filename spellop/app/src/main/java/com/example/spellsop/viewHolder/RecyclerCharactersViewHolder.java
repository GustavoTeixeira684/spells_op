package com.example.spellsop.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spellsop.R;

public class RecyclerCharactersViewHolder extends RecyclerView.ViewHolder {

    public TextView labelNome, labelEstiloCombate, labelEspecie, labelNivel;
    public ImageView imgBtnRemove, imgPersonagem;
    public CardView cardCharacter;

    public RecyclerCharactersViewHolder(@NonNull View itemView) {
        super(itemView);
        labelNome = itemView.findViewById(R.id.labelNome);
        labelEstiloCombate = itemView.findViewById(R.id.labelEstiloCombate);
        labelEspecie = itemView.findViewById(R.id.labelEspecie);
        labelNivel = itemView.findViewById(R.id.labelNivel);
        cardCharacter = itemView.findViewById(R.id.cardCharacter);
        imgBtnRemove = itemView.findViewById(R.id.imgBtnRemove);
        imgPersonagem = itemView.findViewById(R.id.imgPersonagem);

    }
}
