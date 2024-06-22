package com.example.quiz;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result extends AppCompatActivity {

    TextView descriptionTV;
    TextView resultTV;
    Button exitBTN;
    Toolbar toolBarMainTB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        descriptionTV = findViewById(R.id.descriptionTV);
        resultTV = findViewById(R.id.resultTV);
        exitBTN = findViewById(R.id.exitBTN);
        toolBarMainTB = findViewById(R.id.toolBarMainTB);

        Integer result = Integer.parseInt(getIntent().getStringExtra("result"));
        resultTV.setText(String.valueOf(result));

        switch (result){
            case 500:
                descriptionTV.setText(R.string.best_result);
                break;
            case 400:
                descriptionTV.setText(R.string.great_result);
                break;
            case 300:
                descriptionTV.setText(R.string.normal_result);
                break;
            case 200:
                descriptionTV.setText(R.string.bad_result);
                break;
            case 100:
                descriptionTV.setText(R.string.terrible_result);
                break;
            case 0:
                descriptionTV.setText(R.string.worst_result);
                break;
        }



        exitBTN.setOnClickListener(v -> {
            finish();

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
        if (item.getItemId() == R.id.exitBTN){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}