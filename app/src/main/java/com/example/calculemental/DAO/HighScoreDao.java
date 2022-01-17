package com.example.calculemental.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.calculemental.model.Entities.HighScore;

import java.util.ArrayList;
import java.util.List;


public class HighScoreDao extends BaseDao<HighScore> {

    public static final String ID_KEY = "id";
    public static final String TABLE_NAME = "highScore";
    public static final String PSEUDO = "pseudo" ;
    public static final String SCORE = "score" ;

    public HighScoreDao(DataBaseHelper helper) {
        super(helper);
    }

    public List<HighScore> getAllHighScore(SQLiteDatabase db){
        List<HighScore> highScores = new ArrayList<>();
        String query = "select * from Highscore";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                HighScore highScore =new HighScore();
                highScore.setId(Integer.parseInt(cursor.getString(0)));
                highScore.setPseudo(cursor.getString(1));
                highScore.setScore(cursor.getInt(2));
                highScores.add(highScore);
            }while(cursor.moveToNext());
        }
        return highScores;
    }


    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    protected void putValues(ContentValues values, HighScore entity) {

    }

    @Override
    protected HighScore getEntity(Cursor cursor) {
        return null;
    }
}
