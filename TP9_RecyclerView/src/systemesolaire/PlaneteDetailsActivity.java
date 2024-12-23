package com.example.systemesolaire;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import model.Planete;

public class PlaneteDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planete_details);
        Planete planete = (Planete) getIntent().getSerializableExtra("planete");
        if(planete != null)
        {
            TextView nomPlanete = findViewById(R.id.namePlanetValue);
            TextView distPlanete = findViewById(R.id.distancePlanetValue);
            TextView periodRev = findViewById(R.id.revolutionValue);
            TextView diametre = findViewById(R.id.diametreValue);
            TextView gravite = findViewById(R.id.gravityValue);
            TextView nbrSat= findViewById(R.id.nbsatelliteValue);
            ImageView img = findViewById(R.id.imgDetail);

            img.setImageResource(planete.getImage());
            nomPlanete.setText(planete.getNom());
            distPlanete.setText(String.valueOf(planete.getDistance()));
            periodRev.setText(planete.getPeriodeRevolution());
            diametre.setText(planete.getDiametre());
            gravite.setText(planete.getGravite());
            nbrSat.setText(String.valueOf(planete.getNombreSatellites()));






        }

    }

    //recuperer les données




}
