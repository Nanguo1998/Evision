package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class vision36 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vision36);
    }
    public void vision37(View view) {
        Intent intent = new Intent(this, vision37.class);
        startActivity(intent);
        finish();
    }
    public void stopvision36(View view) {
        Intent intent = new Intent(this, stopvision36.class);
        startActivity(intent);
        finish();
    }
}
