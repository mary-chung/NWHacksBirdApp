package com.example.birdapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    // credit to http://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/
    // for the tutorial on creating a database


    private Context context;

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
    private static final String CREATE_TABLE_BIRDS = "CREATE TABLE " + TABLE_BIRDS +
            " (" + CNAME + " VARCHAR NOT NULL PRIMARY KEY," +
            SNAME + " VARCHAR," +
            SIZE + " VARCHAR," +
            FUNFACT + " VARCHAR," +
            HABITAT + " VARCHAR,"+
            SIZERANGE + " VARCHAR," +
            DIET + " VARCHAR," +
            APPEARANCE + " VARCHAR" + ");";

    private static final String CREATE_TABLE_BIRDCOLOURS = "CREATE TABLE " + TABLE_BIRDCOLOURS +
            "(" + CNAME + " VARCHAR NOT NULL," +
            COLOUR + " VARCHAR NOT NULL," +
            "PRIMARY KEY (" + CNAME + "," + COLOUR + ")"
            + ");";

    private static final String CREATE_TABLE_BIRDLOCS = "CREATE TABLE " + TABLE_BIRDLOCS +
            "(" + CNAME + " VARCHAR NOT NULL," +
            LOC + " VARCHAR NOT NULL," +
            "PRIMARY KEY (" + CNAME + "," + LOC + ")"
            + ");";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    // creating required tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("hello from dbhelper");
        db.execSQL(CREATE_TABLE_BIRDS);
        db.execSQL(CREATE_TABLE_BIRDCOLOURS);
        db.execSQL(CREATE_TABLE_BIRDLOCS);

        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        try {
            insertFromFile(context, 180002, db);
            insertFromFile(context, 180001, db);
            insertFromFile(context, 180000, db);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // updating tables
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // update tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BIRDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BIRDCOLOURS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BIRDLOCS);
        onCreate(db);
    }

    // method that populates a table from sql script.
    // source:
    // https://stackoverflow.com/questions/8199138/android-how-to-exec-a-sql-file-in-sqlitedatabase
    public int insertFromFile(Context context, int resourceId, SQLiteDatabase db) throws IOException {
        // Resetting Counter
        int result = 0;
        // Open the resource:
        // bird_colours.sql =    1800000
        // bird_locs.sql =       1800001
        // bird_colours.sql =    1800002
        InputStream insertsStream = context.getResources().openRawResource(resourceId);
        BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

        // Iterate through lines (assuming each insert has its own line and theres no other stuff)
        while (insertReader.ready()) {
            String insertStmt = insertReader.readLine();
            db.execSQL(insertStmt);
            result++;
        }
        insertReader.close();

        // returning number of inserted rows
        System.out.println(result);
        return result;
    }

    // returns list of birds from questionnaire(bird tuples from database)
    // credit: https://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/
    public List<Bird> executeQuizBirds(String c1, String c2, String l, String s) {
        List<Bird> birds = new ArrayList<Bird>();

        String query1 = "select * " +
                        "from Birds B " +
                        "where B.cname in ";

        String query2 = "(select BC1.cname " +
                        "from BirdColours BC1 " +
                        "where BC1.colour = " + c1 + " ";

        String query3 = "intersect " +
                        "select BC2.cname " +
                        "from BirdColours BC2 " +
                        "where BC2.colour = " + c2 + ") ";

        String query4 = "and B.cname in " +
                        "(select BL.cname " +
                        "from BirdLocs BL " +
                        "where BL.loc = " + l + ") ";

        String query5 = "and B.size = " + s;

        String query = query1 + query2 + query3 + query4 + query5;
        Log.e(TAG, query);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Bird b = new Bird();
                b.setCname(c.getString((c.getColumnIndex(CNAME))));
                b.setSname((c.getString(c.getColumnIndex(SNAME))));
                b.setSize(c.getString(c.getColumnIndex(SIZE)));
                b.setFunfact(c.getString((c.getColumnIndex(FUNFACT))));
                b.setHabitat((c.getString(c.getColumnIndex(HABITAT))));
                b.setSizerange(c.getString(c.getColumnIndex(SIZERANGE)));
                b.setDiet(c.getString((c.getColumnIndex(DIET))));
                b.setAppearance((c.getString(c.getColumnIndex(APPEARANCE))));

                // adding to birds list
                birds.add(b);
            } while (c.moveToNext());
        }

        return birds;
    }

    public Cursor getListOfBirdsV2() {
        String query = "select * from Birds";
        Log.e(TAG, query);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    // get all birds
    public List<Bird> getListOfBirds(String c1, String c2, String l, String s) {
        List<Bird> birds = new ArrayList<Bird>();

        String query = "select * from Birds";
        Log.e(TAG, query);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Bird b = new Bird();
                b.setCname(c.getString((c.getColumnIndex(CNAME))));
                b.setSname((c.getString(c.getColumnIndex(SNAME))));
                b.setSize(c.getString(c.getColumnIndex(SIZE)));
                b.setFunfact(c.getString((c.getColumnIndex(FUNFACT))));
                b.setHabitat((c.getString(c.getColumnIndex(HABITAT))));
                b.setSizerange(c.getString(c.getColumnIndex(SIZERANGE)));
                b.setDiet(c.getString((c.getColumnIndex(DIET))));
                b.setAppearance((c.getString(c.getColumnIndex(APPEARANCE))));

                // adding to birds list
                birds.add(b);
            } while (c.moveToNext());
        }
        return birds;
    }
}
