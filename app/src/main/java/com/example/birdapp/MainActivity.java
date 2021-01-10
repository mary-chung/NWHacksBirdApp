package com.example.birdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton BirdIDBtn = (ImageButton)findViewById(R.id.BirdIDBtn);
        BirdIDBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),LocActivity.class);
                startActivity(startIntent);
            }
        });

        ImageButton DirectoryBtn = (ImageButton)findViewById(R.id.DirectoryBtn);
        DirectoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),Directory.class);
                startActivity(startIntent);
            }
        });
//the code below is just to test if the button from result to find another bird works
        ImageButton BirdexBtn = (ImageButton)findViewById(R.id.BirdexBtn);
        BirdexBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),Result.class);
                startActivity(startIntent);
            }
        });
    }
}