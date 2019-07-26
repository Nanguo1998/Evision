package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class vision37 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vision37);
    }
    public void vision38(View view) {
        Intent intent = new Intent(this, vision38.class);
        startActivity(intent);
        finish();
    }
    public void stopvision37(View view) {
        Intent intent = new Intent(this, stopvision37.class);
        startActivity(intent);
        finish();
    }
}
