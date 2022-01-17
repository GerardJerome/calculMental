package com.example.calculemental.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CalculDatabaseHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME = "historique";
    static int VERSION = 1;
    public CalculDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    private String TABLE_CALCUL = "calculs";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String script = "CREATE TABLE " + TABLE_CALCUL + "(id INTEGER PRIMARY KEY, calcul TEXT , resultat TEXT)";
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CALCUL);
        onCreate(db);
    }


}
