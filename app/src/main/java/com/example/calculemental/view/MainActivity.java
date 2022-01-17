package com.example.calculemental.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.calculemental.R;

public class MainActivity extends AppCompatActivity {

    private Button newGameButton;
    private Button scoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newGameButton= findViewById(R.id.nouvelPartieBouton);
        scoreButton=findViewById(R.id.scoreBoutton);

        newGameButton.setOnClickListener(v -> {
            Intent i = new Intent(this,PartieEnCoursActivity.class);
            startActivity(i);
        });

        scoreButton.setOnClickListener(v -> {
            Intent i = new Intent(this,ScoreActivity.class);
            startActivity(i);
        });
    }
}