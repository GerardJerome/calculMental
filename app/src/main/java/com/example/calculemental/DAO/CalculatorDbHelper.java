package com.example.calculemental.DAO;

import android.content.Context;

public class CalculatorDbHelper extends DataBaseHelper{

    public CalculatorDbHelper(Context context) {
        super(context, "calculatorDB", 1);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS " + HighScoreDao.TABLE_NAME + " (" +
                HighScoreDao.ID_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HighScoreDao.PSEUDO + " STRING NOT NULL," +
                HighScoreDao.SCORE + " INTEGER NOT NULL," +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS "+HighScoreDao.TABLE_NAME;
    }
}
