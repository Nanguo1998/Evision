package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class color1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_color1);
    }
    public void color2(View view) {
        Intent intent = new Intent(this, color2.class);
        startActivity(intent);
        finish();
    }
    public void color_fail(View view) {
        Intent intent = new Intent(this, color_fail.class);
        startActivity(intent);
        finish();
    }
}
