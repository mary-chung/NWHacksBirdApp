package com.example.birdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button ReBirdIDBtn = (Button)findViewById(R.id.ReBirdIDBtn);
        ReBirdIDBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),LocActivity.class);
                startActivity(startIntent);
            }
        });

        ImageButton HomeBtn = (ImageButton)findViewById(R.id.HomeBtn);
        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(startIntent);
            }
        });

    }
}