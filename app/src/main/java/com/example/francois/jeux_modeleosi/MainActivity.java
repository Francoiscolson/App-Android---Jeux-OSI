package com.example.francois.jeux_modeleosi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Random r = new Random();
    int valeur = r.nextInt(6);
    TextView Affiche;
    Button valider;
    RadioGroup group;
    int couche;
    int index = 3 ;
    Button recommencer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Affiche = (TextView)findViewById(R.id.random);
        valider = (Button)findViewById(R.id.valider);
        group = (RadioGroup)findViewById(R.id.group);
        recommencer = (Button)findViewById(R.id.recommencer);
        recommencer.setVisibility(View.INVISIBLE);



        switch (valeur)
        {
            case 0:
                Affiche.setText("Quelle couche est chargée de la transmission effective des signaux entre les interlocuteur ?" + String.valueOf(valeur));
                break;
            case 1:
                Affiche.setText("Quelle couche gère les communications de proche en proche, généralement entre machines : routage et adressage des paquets ?" +String.valueOf(valeur));
                break;
            case 2:
                Affiche.setText("Quelle couche gère les communications de bout en bout entre processus (programmes en cours d'exécution) ?" +String.valueOf(valeur));
                break;
            case 3:
                Affiche.setText("Quelle couche gère la synchronisation des échanges et les « transactions », permet l'ouverture et la fermeture de session ?"+ String.valueOf(valeur));
                break;
            case 4:
                Affiche.setText("Quelle couche  est chargée du codage des données applicatives, précisément de la conversion entre données manipulées au niveau applicatif et chaînes d'octets effectivement transmises ?" +String.valueOf(valeur));
                break;
            case 5:
                Affiche.setText("Quelle couche gère les communications entre 2 machines directement connectées entre elles, ou connectées à un équipement qui émule une connexion directe (commutateur)?"+String.valueOf(valeur));
                break;
            case 6:
                Affiche.setText("Quelle couche est le point d'accès aux services réseaux, elle n'a pas de service propre spécifique et entrant dans la portée de la norme ?"+String.valueOf(valeur));
                break;
        }

    }
    public void OnClickMain(View v)
    {
        switch (v.getId()) {
            case R.id.valider:

             if(group.getCheckedRadioButtonId() == R.id.application){couche=6;}
                if(group.getCheckedRadioButtonId() == R.id.presentation){couche=4;}
                if(group.getCheckedRadioButtonId() == R.id.session){couche=3;}
                if(group.getCheckedRadioButtonId() == R.id.Transport){couche=2;}
                if(group.getCheckedRadioButtonId() == R.id.Reseaux){couche=1;}
                if(group.getCheckedRadioButtonId() == R.id.LDD){couche=5;}
                if(group.getCheckedRadioButtonId() == R.id.physique){couche=0;}

                if(valeur == couche)
                {
                    Toast.makeText(getApplication(), "Bonne réponse", Toast.LENGTH_LONG).show();
                    valider.setVisibility(View.INVISIBLE);
                    recommencer.setVisibility(View.VISIBLE);
                }
                else
                {

                    if(index <=3 && index > 0 ){
                        index = index - 1;
                        if(index>0) {
                            Toast.makeText(getApplication(), "Mauvaise réponse encore : " + index + " essaies", Toast.LENGTH_SHORT).show();
                        }

                    }
                    if(index<=0) {
                        Toast.makeText(getApplication(), "vous avez perdu", Toast.LENGTH_SHORT).show();
                        valider.setVisibility(View.INVISIBLE);
                        recommencer.setVisibility(View.VISIBLE);

                    }
                }

                break;

            case R.id.recommencer :
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);


                break;
                }








        }

    }





