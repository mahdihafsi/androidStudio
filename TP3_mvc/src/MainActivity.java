package com.example.coach.vue;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.coach.R;
import com.example.coach.controlleur.Control;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    // proprieté
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private RadioButton rdFemme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Control control ;

    /**
     * initialisation des liens avec les objets graphiques
     */
    private void init(){
        txtPoids = (EditText) findViewById(R.id.txtPoids) ;
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge) ;
        rdHomme = (RadioButton) findViewById(R.id.rdHomme) ;
        rdFemme = (RadioButton) findViewById(R.id.rdFemme) ;
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley) ;
        lblIMG = (TextView) findViewById(R.id.lblIMG) ;
        txtPoids = (EditText) findViewById(R.id.txtPoids) ;
        this.control= Control.getInstance(this);
        ecouteCalcul();
        recupProfil();
    }

    /**
     * Ecoute evenement sur bouton calcul
     */
    private void ecouteCalcul(){
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
//                Toast.makeText(MainActivity.this,"test" , Toast.LENGTH_SHORT).show();
                  Log.d("message","test du boutton calcul **********OK*********");
                Integer poids = 0 ;
                Integer taille = 0 ;
                Integer age = 0 ;
                Integer sexe = 0 ;

                // recuperation des données saisies;
                try {
                    poids = Integer.parseInt(txtPoids.getText().toString()) ;
                    taille = Integer.parseInt(txtTaille.getText().toString()) ;
                    age = Integer.parseInt(txtAge.getText().toString()) ;
                }catch (Exception e){}

                if(rdHomme.isChecked()){
                    sexe = 1 ;
                }

                //controle des données saisie
                if(poids == 0 || taille == 0 || age== 0 ){
                    Toast.makeText(MainActivity.this,"Saisie incorrecte" , Toast.LENGTH_SHORT).show();
                }else {
                        afficheResult(poids , taille , age , sexe);
                }
            }
        });
    }

    /**
     * Affichage de l'IMG , du message et de l'image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    private  void afficheResult(Integer poids , Integer taille , Integer age , Integer sexe ){
        // creation de profil et recuperation des information
        this.control.creerProfil(poids , taille , age , sexe , this);
        float img = this.control.getImg();
        String message = this.control.getMessage();

        // affichage
        if(message.equals("normal")){
            imgSmiley.setImageResource(R.drawable.happy);
            lblIMG.setTextColor(Color.GREEN);
        }else {
            if (message.equals("trop faible")){
                imgSmiley.setImageResource(R.drawable.smiley);
                lblIMG.setTextColor(Color.RED);
            }else {
                imgSmiley.setImageResource(R.drawable.normal);
                lblIMG.setTextColor(Color.RED);
            }
        }
        lblIMG.setText(String.format("%.01f",img)+ " : IMG " + message);
    }

    /**
     * recuperation du profil s'il été serialisé
     */
    private void recupProfil(){
        if(control.getPoids() != null){
            txtPoids.setText(control.getPoids().toString());
            txtTaille.setText(control.getTaille().toString());
            txtAge.setText(control.getAge().toString());
            rdFemme.setChecked(true);
            if(control.getSexe()==1){
                rdHomme.setChecked(true);
            }
            //simule le clic sur le boutton calcul
            ((Button)findViewById(R.id.btnCalc)).performClick();
        }
    }
}