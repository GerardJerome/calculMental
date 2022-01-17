package com.example.calculemental.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.calculemental.DAO.HighScoreDao;
import com.example.calculemental.R;
import com.example.calculemental.model.Entities.HighScore;

public class SaveScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_score);
        Button buttonSave = findViewById(R.id.button_sauvegarder);
        buttonSave.setOnClickListener(v -> saveInDatabase());
    }

    private void saveInDatabase() {
    }
}