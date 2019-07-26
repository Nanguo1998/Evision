package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class vision43 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vision43);
    }
    public void vision44(View view) {
        Intent intent = new Intent(this, vision44.class);
        startActivity(intent);
        finish();
    }
    public void stopvision43(View view) {
        Intent intent = new Intent(this, stopvision43.class);
        startActivity(intent);
        finish();
    }
}
