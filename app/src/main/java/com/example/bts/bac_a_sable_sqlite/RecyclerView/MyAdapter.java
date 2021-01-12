package com.example.bts.bac_a_sable_sqlite.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bts.bac_a_sable_sqlite.Donnee;
import com.example.bts.bac_a_sable_sqlite.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Donnee> list;

    //ajouter un constructeur prenant en entrée une liste
    public MyAdapter(List<Donnee> list) {
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.liste_ligne,viewGroup,false);
        return new MyViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Donnee maDonnee = list.get(position);
        myViewHolder.bind(maDonnee);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }




}
