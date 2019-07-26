package com.example.e.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e.R;

public class News extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_news);
    }
    public void new1(View view) {
        Intent intent = new Intent(this, new1.class);
        startActivity(intent);
    }
    public void new2(View view) {
        Intent intent = new Intent(this, new2.class);
        startActivity(intent);
    }
    public void new3(View view) {
        Intent intent = new Intent(this, new3.class);
        startActivity(intent);
    }
    public void new4(View view) {
        Intent intent = new Intent(this, new4.class);
        startActivity(intent);
    }
    public void new5(View view) {
        Intent intent = new Intent(this, new5.class);
        startActivity(intent);
    }
}
