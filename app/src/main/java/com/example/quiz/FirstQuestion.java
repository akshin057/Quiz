package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstQuestion extends AppCompatActivity {

    Toolbar toolBarMainTB;

    RadioGroup radioGroupRG;
    RadioButton firstAnswer;
    RadioButton secondAnswer;
    RadioButton thirdAnswer;
    RadioButton fourthAnswer;

    TextView resultTV;

    Button nextAnswerBTN;
    Integer result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        toolBarMainTB = findViewById(R.id.toolBarMainTB);
        radioGroupRG = findViewById(R.id.radioGroupRG);
        nextAnswerBTN = findViewById(R.id.nextAnswerBTN);
        firstAnswer = findViewById(R.id.firstAnswer);
        secondAnswer = findViewById(R.id.secondAnswer);
        thirdAnswer = findViewById(R.id.thirdAnswer);
        fourthAnswer = findViewById(R.id.fourthAnswer);
        resultTV = findViewById(R.id.resultTV);

        nextAnswerBTN.setOnClickListener(v -> {
            if (nextAnswerBTN.getText().toString().equals("Ответить")) {

                if (secondAnswer.isChecked()) {
                    resultTV.setText(R.string.right_answer);
                    nextAnswerBTN.setText("Следующий вопрос");
                    result += 100;
                } else {
                    resultTV.setText(R.string.wrong_answer);
                    nextAnswerBTN.setText("Следующий вопрос");
                }

            } else if (nextAnswerBTN.getText().toString().equals("Следующий вопрос")){
                Intent intent = new Intent(FirstQuestion.this, SecondQuestion.class);
                intent.putExtra("result", String.valueOf(result));
                startActivity(intent);
                finish();
            }
        });

        setSupportActionBar(toolBarMainTB);
        getSupportActionBar().setTitle("Викторина");
        getSupportActionBar().setSubtitle("Версия 1.0");
        getSupportActionBar().setLogo(R.drawable.logo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.exitBTN) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}