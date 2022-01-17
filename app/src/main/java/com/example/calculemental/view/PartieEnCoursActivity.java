package com.example.calculemental.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculemental.R;
import com.example.calculemental.model.OperationType;

import java.util.Random;

public class PartieEnCoursActivity extends AppCompatActivity {
    private TextView calculTextView;
    private TextView responseTextView;
    private MenuItem scoreText;
    private MenuItem errorText;
    private int first = 0;
    private int second = 0;
    private OperationType operatorSymbol ;
    private Integer score = 0;
    private Integer misstakeLeft = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie_en_cours);
        calculTextView = findViewById(R.id.CalculTextView);
        responseTextView = findViewById(R.id.reponseTextView);
        generateOperation();
        changeCalcul();

        // HERE : ajout des evenements associés aux boutons de chiffre
        Button button0= findViewById(R.id.button0);
        Button button1= findViewById(R.id.button1);
        Button button2= findViewById(R.id.button2);
        Button button3= findViewById(R.id.button3);
        Button button4= findViewById(R.id.button4);
        Button button5= findViewById(R.id.button5);
        Button button6= findViewById(R.id.button6);
        Button button7= findViewById(R.id.button7);
        Button button8= findViewById(R.id.button8);
        Button button9= findViewById(R.id.button9);
        Button buttonOpposite = findViewById(R.id.button_opposite);
        Button buttonOK = findViewById(R.id.button_ok);
        Button buttonClear = findViewById(R.id.buttonEffacer);
        button0.setOnClickListener(view -> addNumber(0));
        button1.setOnClickListener(view -> addNumber(1));
        button2.setOnClickListener(view -> addNumber(2));
        button3.setOnClickListener(view -> addNumber(3));
        button4.setOnClickListener(view -> addNumber(4));
        button5.setOnClickListener(view -> addNumber(5));
        button6.setOnClickListener(view -> addNumber(6));
        button7.setOnClickListener(view -> addNumber(7));
        button8.setOnClickListener(view -> addNumber(8));
        button9.setOnClickListener(view -> addNumber(9));
        buttonClear.setOnClickListener(v -> responseTextView.setText(""));
        buttonOpposite.setOnClickListener(v -> oppositeValue());
        buttonOK.setOnClickListener(v -> checkAnswer());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void oppositeValue() {
        responseTextView.setText("-"+responseTextView.getText());
    }

    private void checkAnswer() {
        Integer result = 0;
        switch(operatorSymbol){
            case add:
                result+=first+second;
                break;
            case substract:
                result+=first-second;
                break;
            case multiply:
                result+=first*second;
                break;
        }
        if(Integer.parseInt(responseTextView.getText().toString())==result){
            score++;
        }else{
            misstakeLeft--;
        }

        checkMisstakeAndRefreshToolBar();

    }

    private void checkMisstakeAndRefreshToolBar() {
        if(misstakeLeft==0){
            Intent i  = new Intent(this,SaveScoreActivity.class);
            i.putExtra("score",score);
            startActivity(i);
        }else{
            scoreText.setTitle(getString(R.string.score)+" "+score.toString());
            errorText.setTitle(getString(R.string.erreurs_possible)+" "+misstakeLeft.toString());
            generateOperation();
            changeCalcul();
        }
    }

    private void generateOperation() {
        Random random = new Random();
        first = (random.nextInt(10)+1);
        operatorSymbol  = generateCalculMode();
        second = (random.nextInt(10)+1);


    }

    private OperationType generateCalculMode() {
        Random random = new Random();
        return OperationType.getByIndex(random.nextInt(3)+1);
    }

    private void addNumber(int i) {
        responseTextView.setText(responseTextView.getText()+(String.valueOf(i)));
    }
    private void changeCalcul() {
        String text = getComputeText();
        this.calculTextView.setText(text);
        responseTextView.setText("");
    }



    private String getComputeText() {
        StringBuilder builder = new StringBuilder();
        builder.append(first);


        builder.append(" ");
        builder.append(operatorSymbol.getSymbol());
        builder.append(" ");
        builder.append(second);
        return builder.toString();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        scoreText = menu.findItem(R.id.scoreText);
        errorText = menu.findItem(R.id.erreurPossibleText);
        scoreText.setTitle(getString(R.string.score)+" "+score.toString());
        errorText.setTitle(getString(R.string.erreurs_possible)+" "+misstakeLeft.toString());
        return true;
    }
}