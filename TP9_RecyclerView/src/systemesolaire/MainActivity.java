package com.example.systemesolaire;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.MyPlaneteAdapter;
import model.Planete;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private MyPlaneteAdapter myAdapter;
    List listePlanete = new ArrayList<Planete>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        


        myRecyclerView = findViewById(R.id.myRecyclerView);


        listePlanete.add(new Planete("Mercure", 58,R.drawable.mercure,"87 jours", "4 879 km", "0,378", 0));
        listePlanete.add(new Planete("Vénus", 108,R.drawable.venus, "224 jours", "12 104 km", "0,907", 0));
        listePlanete.add(new Planete("Terre", 150,R.drawable.terre, "365 jours", "12 756 km", "1,000", 1));
        listePlanete.add(new Planete("Mars", 228,R.drawable.mars, "686 jours", "6 792 km", "0,377", 2));
        listePlanete.add(new Planete("Jupiter", 778,R.drawable.jupiter, "11 ans 315 jours", "142 984 km", "2,36", 67));
        listePlanete.add(new Planete("Saturne", 1427,R.drawable.saturne, "29 ans 167 jours", "120 536 km", "0,89", 62));
        listePlanete.add(new Planete("Uranus", 2871,R.drawable.uranus, "84 ans 7 jours", "51 118 km", "0,89", 27));
        listePlanete.add(new Planete("Neptune", 4497,R.drawable.neptune, "164 ans 281 jours", "49 530 km", "1,14", 14));




//        Resources res = getResources();
//        final String [] noms = res.getStringArray(R.array.noms);
//        final int [] distances = res.getIntArray(R.array.distances);
//        List listePlanete = new ArrayList<>();
//        for (int i = 0 ; i<noms.length;++i){
//            listePlanete.add(new Planete(noms[i] , distances[i]));
//        }
        Log.d("size list",String.valueOf(listePlanete.size()));

        myAdapter = new MyPlaneteAdapter(listePlanete);
        myAdapter.setOnItemClickListener(this::onItemClick);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this , DividerItemDecoration.VERTICAL);
        myRecyclerView.addItemDecoration(dividerItemDecoration);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        myRecyclerView.setAdapter(myAdapter);

    }

    private void onItemClick(int position) {
        Planete planete = (Planete) listePlanete.get(position);
        Intent intent = new Intent(MainActivity.this,PlaneteDetailsActivity.class);
        intent.putExtra("planete", planete);
        startActivity(intent);

    }
}