package com.example.bts.bac_a_sable_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bts.bac_a_sable_sqlite.RecyclerView.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // attribut
    private Donnee donnee;
    private AccesLocal accesLocal;
    private RecyclerView rvListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        accesLocal = new AccesLocal(this);

        ecouteBtn();
        //checkBDLocal();
        noFocusOnLayout(this);
        //gestion de la liste dans le onResume()
    }

    private void ecouteBtn() {
        findViewById(R.id.btn_enregistre).setOnClickListener(new TextView.OnClickListener() {
            public void onClick(View v) {
                accesLocal.ajout( ((TextView) findViewById(R.id.et_saisie)).getText().toString() );
                //Toast.makeText(MainActivity.this, "Saisie enregistrée.", Toast.LENGTH_SHORT).show();
                checkBDLocal();
                onResume();
            }
        });

        findViewById(R.id.btn_vider).setOnClickListener(new TextView.OnClickListener() {
            public void onClick(View v) {
                accesLocal.vider();
                onResume();
            }
        });
    }

    private void checkBDLocal(){
        donnee = accesLocal.recupDernierEnreg();
            ((TextView) findViewById(R.id.tvL_id)).setText("Id : " + donnee.getId());
            ((TextView) findViewById(R.id.tvL_texte)).setText("Texte : " + donnee.getTexte());

    }


    @Override
    protected void onResume() {
        super.onResume();
        //on récupére la liste des donnees
        ArrayList<Donnee> listeDonnee = accesLocal.recupEtoile();

        //On met en mémoire notre adaptateur et nous lui donnons notre liste de Donnee
        rvListe = (RecyclerView) findViewById(R.id.rv_liste) ;
        rvListe.setLayoutManager(new LinearLayoutManager(this));
        //On donne à notre RecyclerViex notre nouvel adaptateur
        rvListe.setAdapter(new MyAdapter(listeDonnee));
        
    }


    public void noFocusOnLayout(Activity activity) {
        LinearLayout view = findViewById(R.id.all);
        view.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch (View v, MotionEvent event){
                v.requestFocusFromTouch();
                return false;
            }
        });
    }

}
