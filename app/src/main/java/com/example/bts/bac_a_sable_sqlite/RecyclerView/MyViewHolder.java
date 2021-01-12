package com.example.bts.bac_a_sable_sqlite.RecyclerView;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bts.bac_a_sable_sqlite.Donnee;
import com.example.bts.bac_a_sable_sqlite.R;


public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView tvid;
    private TextView tvtxt;

    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(View itemView) {
        super(itemView);
        //c'est ici que l'on fait nos findView
        tvid = (TextView) itemView.findViewById(R.id.tvL_id);
        tvtxt = (TextView) itemView.findViewById(R.id.tvL_texte);

    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    //callback// 2 - add callback reference to the signature
    public void bind(Donnee myObject){
        tvid.setText(myObject.getId().toString());
        tvtxt.setText(myObject.getTexte().toString());
    }
}