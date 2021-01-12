package com.example.bts.bac_a_sable_sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Donnee> {

    //attribut
    Context context;

    // Nous créons le constructeur de l'adaptateur à qui on indique la liste 
    // qui détient les données qu'il devra gérer
    public ListAdapter(Context context, List<Donnee> listeDonnee) {
        super(context, -1, listeDonnee);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        // Déclaration d'une variable qui va contenir les données d'une Donnee
        Donnee uneDonnee;
        view = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.liste_ligne, parent, false);
        } else {
            view = convertView;
        }

        // Permet de mettre dans la variable « uneDonnee », un élément de la liste
        uneDonnee = getItem(position);

        //Faire le lien entre la variable Java et le composant « TextView » de l'interface
        TextView tvLid = (TextView) view.findViewById(R.id.tvL_id);
        TextView tvLtexte = (TextView) view.findViewById(R.id.tvL_texte);
        
        // Mettre les valeurs de la Donnee récupéré dans le composant « TextView » adéquat
        tvLid.setText(uneDonnee.getId().toString());
        tvLtexte.setText(uneDonnee.getTexte());

        /*     Exemple de gestion des images dans une liste

        //Faire le lien entre la variable Java et le composant « ImageView »
        ImageView imageView = (ImageView) view.findViewById(R.id.imageListe);
        // Dans la variable « manager », nous mettons un lien vers le répertoire « Assets »
        AssetManager manager =context.getAssets();
        InputStream open = null;
        try {
            // Ouvre le fichier image de la personne récupérée
            open = manager.open(uneDonnee.getImage());
            // Stocke dans la variable bitmap, l'image récupérée
            Bitmap bitmap = BitmapFactory.decodeStream(open);
            // Met dans « ImageView », l'image de la Donnee
            imageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        */

        return view;
    }


    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }
}
