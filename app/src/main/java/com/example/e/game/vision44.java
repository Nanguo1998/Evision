package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class vision44 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vision44);
    }
    public void vision45(View view) {
        Intent intent = new Intent(this, vision45.class);
        startActivity(intent);
        finish();
    }
    public void stopvision44(View view) {
        Intent intent = new Intent(this, stopvision44.class);
        startActivity(intent);
        finish();
    }
}
