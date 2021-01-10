package com.example.birdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LocActivity extends AppCompatActivity implements View.OnClickListener {
    private String location;
    private Intent startIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc);

        ImageButton shoreBtn = (ImageButton)findViewById(R.id.shorebtn);
        ImageButton forestBtn = (ImageButton)findViewById(R.id.forestbtn);
        ImageButton marshBtn = (ImageButton)findViewById(R.id.marshbtn);
        ImageButton yardBtn = (ImageButton)findViewById(R.id.yardbtn);
        ImageButton lakeBtn = (ImageButton)findViewById(R.id.lakebtn);
        ImageButton treeBtn = (ImageButton)findViewById(R.id.treebtn);
        ImageButton riverBtn = (ImageButton)findViewById(R.id.riverbtn);
        ImageButton parkBtn = (ImageButton)findViewById(R.id.parkbtn);
        ImageButton feederBtn = (ImageButton)findViewById(R.id.feederbtn);

        shoreBtn.setOnClickListener(this);
        forestBtn.setOnClickListener(this);
        marshBtn.setOnClickListener(this);
        yardBtn.setOnClickListener(this);
        lakeBtn.setOnClickListener(this);
        treeBtn.setOnClickListener(this);
        riverBtn.setOnClickListener(this);
        parkBtn.setOnClickListener(this);
        feederBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.shorebtn:
                Questionnaire.getInstance().setLocation("shore");
                startIntent = new Intent(LocActivity.this, ColActivity.class);
                startActivity(startIntent);
                break;
            case R.id.forestbtn:
                Questionnaire.getInstance().setLocation("forest");
                startIntent = new Intent(LocActivity.this, ColActivity.class);
                startActivity(startIntent);
                break;
            case R.id.marshbtn:
                Questionnaire.getInstance().setLocation("marsh");
                startIntent = new Intent(LocActivity.this, ColActivity.class);
                startActivity(startIntent);
                break;
            case R.id.yardbtn:
                Questionnaire.getInstance().setLocation("yard");
                startIntent = new Intent(LocActivity.this, ColActivity.class);
                startActivity(startIntent);
                break;
            case R.id.lakebtn:
                Questionnaire.getInstance().setLocation("lake");
                startIntent = new Intent(LocActivity.this, ColActivity.class);
                startActivity(startIntent);
                break;
            case R.id.treebtn:
                Questionnaire.getInstance().setLocation("tree");
                startIntent = new Intent(LocActivity.this, ColActivity.class);
                startActivity(startIntent);
                break;
            case R.id.riverbtn:
                Questionnaire.getInstance().setLocation("river");
                startIntent = new Intent(LocActivity.this, ColActivity.class);
                startActivity(startIntent);
                break;
            case R.id.parkbtn:
                Questionnaire.getInstance().setLocation("park");
                startIntent = new Intent(LocActivity.this, ColActivity.class);
                startActivity(startIntent);
                break;


        }
    }
}