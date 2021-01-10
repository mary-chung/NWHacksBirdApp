package com.example.birdapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ColActivity extends AppCompatActivity {

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


    }
}
