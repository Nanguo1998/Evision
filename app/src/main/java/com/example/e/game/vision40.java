package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class vision40 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vision40);
    }
    public void vision41(View view) {
        Intent intent = new Intent(this, vision41.class);
        startActivity(intent);
        finish();
    }
    public void stopvision40(View view) {
        Intent intent = new Intent(this, stopvision40.class);
        startActivity(intent);
        finish();
    }
}
