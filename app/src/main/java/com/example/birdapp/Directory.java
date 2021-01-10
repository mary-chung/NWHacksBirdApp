package com.example.birdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Comparator;

public class Directory extends AppCompatActivity {

    ListView Directory;
    String[] birddirectory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);

        Resources res = getResources();
        Directory = (ListView) findViewById(R.id.Directory);
        birddirectory = res.getStringArray(R.array.birddirectory);

        Directory.setAdapter(new ArrayAdapter<String>(this, R.layout.directory_detail, birddirectory));

    }
}