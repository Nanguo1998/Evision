package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class Astig extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_astig);
    }
    public void astig2(View view) {
        Intent intent = new Intent(this, astig2.class);
        startActivity(intent);
        finish();
    }
    public void astig_fail(View view) {
        Intent intent = new Intent(this, astig_fail.class);
        startActivity(intent);
        finish();
    }
}
