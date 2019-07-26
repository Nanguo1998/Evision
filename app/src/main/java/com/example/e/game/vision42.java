package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class vision42 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vision42);
    }
    public void vision43(View view) {
        Intent intent = new Intent(this, vision43.class);
        startActivity(intent);
        finish();
    }
    public void stopvision42(View view) {
        Intent intent = new Intent(this, stopvision42.class);
        startActivity(intent);
        finish();
    }
}
