package com.example.bts.bac_a_sable_sqlite;

public class Donnee {

    //attribut
    Integer id;
    String texte;

    public Donnee(Integer id, String texte) {
        this.id = id;
        this.texte = texte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
