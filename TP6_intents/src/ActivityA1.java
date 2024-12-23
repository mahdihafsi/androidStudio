package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ActivityA1 extends Activity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1activity);

        Button btnStartActivityA2 = findViewById(R.id.btnStartActivityA2);
        btnStartActivityA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityA1.this, ActivityA2.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String result;
            if (data != null) {
                result = data.getStringExtra("result");
            } else result = "No Result";
            Toast.makeText(this, "Result from ActivityA2: " + result, Toast.LENGTH_LONG).show();
        }
    }
}
