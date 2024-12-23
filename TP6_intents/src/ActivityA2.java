package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class ActivityA2 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2activity);

        Button btnOui = findViewById(R.id.btnOui);
        btnOui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", "OUI");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        Button btnNon = findViewById(R.id.btnNon);
        btnNon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", "NON");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
