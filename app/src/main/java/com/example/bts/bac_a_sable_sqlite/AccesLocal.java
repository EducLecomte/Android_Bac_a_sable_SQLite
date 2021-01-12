package com.example.bts.bac_a_sable_sqlite;
//https://vogella.developpez.com/tutoriels/android/utilisation-base-donnees-sqlite/

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class AccesLocal {

    //propriété
    private String nomDB = "bacasable.sqlite";
    private Integer version = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase database;


    public AccesLocal(Context contexte){
        accesBD = new MySQLiteOpenHelper(contexte, nomDB, null, version);
    }

    // methodes personnalisées
    // methode pour ajouter un enregistrement,
    public void ajout(String texte){
        database = accesBD.getWritableDatabase();
        String request = " Insert into demosqlite (id, texte) values ";
        Integer id =  recupDernierId()+1;
        request += "( "+id +" , \""+texte+"\");";
        database.execSQL(request);
    }

    // methode pour retirer tout les enregistrements
    public void vider(){
        database = accesBD.getWritableDatabase();
        String request = "delete from demosqlite";
        database.execSQL(request);
    }

    // methode pour récupèrer l'id du dernier enregistrement
    public Integer recupDernierId(){
        Integer id = 0;
        database = accesBD.getReadableDatabase();
        String request = "select * from demosqlite;";
        Cursor curseur = database.rawQuery(request, null);
        curseur.moveToLast();
        if (!curseur.isAfterLast()){
           id = curseur.getInt(0);
        }
        curseur.close();

        return id;
    }

    // methode pour récupèrer le dernier enregistrement
    public Donnee recupDernierEnreg(){

        database = accesBD.getReadableDatabase();
        String request = "select * from demosqlite;";
        Cursor curseur = database.rawQuery(request, null);
        Donnee donnee = null;
        curseur.moveToLast();
        if (!curseur.isAfterLast()){
            Integer id = curseur.getInt(0);
            String texte = curseur.getString(1);
            donnee = new Donnee(id, texte);
        }
        curseur.close();

        return donnee;
    }

    // methode pour tout recupérer
    public ArrayList<Donnee> recupEtoile(){
        ArrayList<Donnee> listDonnee = new ArrayList<Donnee>();
        database = accesBD.getReadableDatabase();
        String request = "select * from demosqlite;";
        Cursor curseur = database.rawQuery(request, null);
        Donnee donnee = null;

        curseur.moveToFirst();
        while (curseur.isAfterLast() == false)
        {

            Integer id = curseur.getInt(0);
            String texte = curseur.getString(1);
            donnee = new Donnee(id, texte);
            listDonnee.add(donnee);
            curseur.moveToNext();
        }
        curseur.close();
        return listDonnee;
    }

}
