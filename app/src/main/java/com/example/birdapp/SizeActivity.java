package com.example.birdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SizeActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent startIntent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);

        ImageButton smallBtn = (ImageButton)findViewById(R.id.smallbtn);
        ImageButton mediumBtn = (ImageButton)findViewById(R.id.medbtn);
        ImageButton bigBtn = (ImageButton)findViewById(R.id.bigbtn);
        ImageButton hugeBtn = (ImageButton)findViewById(R.id.hugebtn);

        smallBtn.setOnClickListener(this);
        mediumBtn.setOnClickListener(this);
        bigBtn.setOnClickListener(this);
        hugeBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.smallbtn:
                Questionnaire.getInstance().setSize("small");
                startIntent = new Intent(SizeActivity.this, ResultActivity.class);
                startActivity(startIntent);
                break;
            case R.id.medbtn:
                Questionnaire.getInstance().setSize("medium");
                startIntent = new Intent(SizeActivity.this, ResultActivity.class);
                startActivity(startIntent);
                break;
            case R.id.bigbtn:
                Questionnaire.getInstance().setSize("big");
                startIntent = new Intent(SizeActivity.this, ResultActivity.class);
                startActivity(startIntent);
                break;
            case R.id.hugebtn:
                Questionnaire.getInstance().setSize("huge");
                startIntent = new Intent(SizeActivity.this, ResultActivity.class);
                startActivity(startIntent);
                break;
        }
    }
}
