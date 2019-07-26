package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class vision38 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vision38);
    }
    public void vision39(View view) {
        Intent intent = new Intent(this, vision39.class);
        startActivity(intent);
        finish();
    }
    public void stopvision38(View view) {
        Intent intent = new Intent(this, stopvision38.class);
        startActivity(intent);
        finish();
    }
}
