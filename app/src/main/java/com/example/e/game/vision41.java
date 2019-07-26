package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class vision41 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vision41);
    }
    public void vision42(View view) {
        Intent intent = new Intent(this, vision42.class);
        startActivity(intent);
        finish();
    }
    public void stopvision41(View view) {
        Intent intent = new Intent(this, stopvision41.class);
        startActivity(intent);
        finish();
    }
}
