package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class vision35 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vision35);
    }
    public void vision36(View view) {
        Intent intent = new Intent(this, vision36.class);
        startActivity(intent);
        finish();
    }
    public void stopvision35(View view) {
        Intent intent = new Intent(this, stopvision35.class);
        startActivity(intent);
        finish();
    }
}
