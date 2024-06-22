package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    Toolbar toolBarMainTB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.startBTN);
        toolBarMainTB = findViewById(R.id.toolBarMainTB);


        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FirstQuestion.class);
            startActivity(intent);
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