package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class Fatigue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fatigue);
    }
    public void fatigue_red(View view) {
        Intent intent = new Intent(this, fatigue_red.class);
        startActivity(intent);
        finish();
    }
    public void fatigue_green(View view) {
        Intent intent = new Intent(this, fatigue_green.class);
        startActivity(intent);
        finish();
    }
}
