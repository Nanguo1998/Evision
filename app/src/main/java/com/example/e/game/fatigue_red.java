package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class fatigue_red extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fatigue_red);
    }
    public void returnmain(View view) {
        Intent intent = new Intent(this, relax.class);
        startActivity(intent);
        finish();
    }
}
