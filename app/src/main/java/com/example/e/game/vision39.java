package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class vision39 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vision39);
    }
    public void vision40(View view) {
        Intent intent = new Intent(this, vision40.class);
        startActivity(intent);
        finish();
    }
    public void stopvision39(View view) {
        Intent intent = new Intent(this, stopvision39.class);
        startActivity(intent);
        finish();
    }
}
