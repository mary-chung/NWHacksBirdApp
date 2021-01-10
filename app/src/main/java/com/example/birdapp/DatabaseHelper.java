package com.example.birdapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    // credit to http://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/
    // for the tutorial on creating a database
    // database specs
    private static final String TAG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BirdHouse.db";

    // table names
    public static final String TABLE_BIRDS = "Birds";
    public static final String TABLE_BIRDCOLOURS = "BirdColours";
    public static final String TABLE_BIRDLOCS = "BirdLocs";

    // common column names
    public static final String COLOUR = "colour";
    public static final String LOC = "loc";
    public static final String CNAME = "cname";
    public static final String SNAME = "sname";
    public static final String SIZE = "size";
    public static final String FUNFACT = "funfact";
    public static final String HABITAT = "habitat";
    public static final String SIZERANGE = "sizerange";
    public static final String DIET = "diet";
    public static final String APPEARANCE = "appearance";


    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_BIRDS = "CREATE TABLE " + TABLE_BIRDS +
            "(" + CNAME + " VARCHAR NOT NULL PRIMARY KEY," +
            SNAME + " VARCHAR," +
            SIZE + " VARCHAR," +
            FUNFACT + " VARCHAR," +
            HABITAT + " VARCHAR,"+
            SIZERANGE + " VARCHAR," +
            DIET + " VARCHAR," +
            APPEARANCE + " VARCHAR" + ")";

    // Tag table create statement
    private static final String CREATE_TABLE_BIRDCOLOURS = "CREATE TABLE " + TABLE_BIRDCOLOURS +
            "(" + CNAME + " VARCHAR NOT NULL," +
            COLOUR + " VARCHAR NOT NULL," +
            "PRIMARY KEY (" + CNAME + "," + COLOUR + ")"
            + ")";


    // todo_tag table create statement
    private static final String CREATE_TABLE_BIRDLOCS = "CREATE TABLE " + TABLE_BIRDLOCS +
            "(" + CNAME + " VARCHAR NOT NULL," +
            LOC + " VARCHAR NOT NULL," +
            "PRIMARY KEY (" + CNAME + "," + LOC + ")"
            + ")";




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_BIRDS);
        db.execSQL(CREATE_TABLE_BIRDCOLOURS);
        db.execSQL(CREATE_TABLE_BIRDLOCS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // update tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BIRDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BIRDCOLOURS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BIRDLOCS);
        onCreate(db);
    }
}
