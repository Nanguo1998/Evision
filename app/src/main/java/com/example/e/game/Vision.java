package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class Vision extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vision);
    }
    public void vision35(View view) {
        Intent intent = new Intent(Vision.this, vision35.class);
        startActivity(intent);
        finish();
    }
    public void game_vision(View view) {
        Intent intent = new Intent(this, Vision.class);
        startActivity(intent);
        finish();
    }
    public void game_fatigue(View view) {
        Intent intent = new Intent(this, Fatigue.class);
        startActivity(intent);
        finish();
    }
    public void game_astig(View view) {
        Intent intent = new Intent(this, Astig.class);
        startActivity(intent);
        finish();
    }
    public void game_color(View view) {
        Intent intent = new Intent(this, Color.class);
        startActivity(intent);
        finish();
    }
}
