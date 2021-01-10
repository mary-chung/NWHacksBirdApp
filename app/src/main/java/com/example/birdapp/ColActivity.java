package com.example.birdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ColActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList colours = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_col);

        ImageButton WhiteBtn = (ImageButton)findViewById(R.id.whitebtn);
        ImageButton BlackBtn = (ImageButton)findViewById(R.id.blackbtn);
        ImageButton GreyBtn = (ImageButton)findViewById(R.id.greybtn);
        ImageButton YellowBtn = (ImageButton)findViewById(R.id.yellowbtn);
        ImageButton PinkBtn = (ImageButton)findViewById(R.id.pinkbtn);
        ImageButton RedBtn = (ImageButton)findViewById(R.id.redbtn);
        ImageButton GreenBtn = (ImageButton)findViewById(R.id.greenbtn);
        ImageButton PurpleBtn = (ImageButton)findViewById(R.id.purplebtn);
        ImageButton BlueBtn = (ImageButton)findViewById(R.id.bluebtn);
        ImageView Next = findViewById(R.id.forwardarw);

        WhiteBtn.setOnClickListener(this);
        BlackBtn.setOnClickListener(this);
        GreyBtn.setOnClickListener(this);
        YellowBtn.setOnClickListener(this);
        PinkBtn.setOnClickListener(this);
        RedBtn.setOnClickListener(this);
        GreenBtn.setOnClickListener(this);
        PurpleBtn.setOnClickListener(this);
        BlueBtn.setOnClickListener(this);
        Next.setOnClickListener(this);
    }

    // on click, add color to array and set clickable of button to false
    @Override
    public void onClick(View v) {
        while (colours.size() < 4) {
            switch (v.getId()) {
                case R.id.whitebtn:
                    colours.add("white");
                    v.setEnabled(false);
                    break;
                case R.id.blackbtn:
                    colours.add("black");
                    v.setEnabled(false);
                    break;
                case R.id.greybtn:
                    colours.add("grey");
                    v.setEnabled(false);
                    break;
                case R.id.yellowbtn:
                    colours.add("yellow");
                    v.setEnabled(false);
                    break;
                case R.id.pinkbtn:
                    colours.add("pink");
                    v.setEnabled(false);
                    break;
                case R.id.redbtn:
                    colours.add("red");
                    v.setEnabled(false);
                    break;
                case R.id.greenbtn:
                    colours.add("green");
                    v.setEnabled(false);
                    break;
                case R.id.purplebtn:
                    colours.add("purple");
                    v.setEnabled(false);
                    break;
                case R.id.bluebtn:
                    colours.add("blue");
                    v.setEnabled(false);
                    break;
                case R.id.forwardarw:
                    Intent startIntent = new Intent(ColActivity.this, Directory.class);
                    startActivity(startIntent);
                    break;
            }
        }
    }
}
