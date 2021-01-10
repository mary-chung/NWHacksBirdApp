package com.example.birdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;

    Button btn_add, btn_viewAll;
//    EditText et_name, et_
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc);


    }
}