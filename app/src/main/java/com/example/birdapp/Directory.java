package com.example.birdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Comparator;

public class Directory extends AppCompatActivity {

    private static final String TAG = "DirectoryActivity";
    DatabaseHelper databaseHelper;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Hi from Directory");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        listView = (ListView) findViewById(R.id.Directory);
        databaseHelper = new DatabaseHelper(Directory.this);
        Log.d(TAG, "Populate birds list");


        Cursor data = databaseHelper.getListOfBirdsV2();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add(data.getString(0));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
    }
}