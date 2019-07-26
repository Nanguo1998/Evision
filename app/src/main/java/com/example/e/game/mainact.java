package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.e.R;

public class mainact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainact);
        getSupportActionBar().hide();
        Typeface typeFace1 = Typeface.createFromAsset(getAssets(), "font/全新硬笔楷书.ttf");
        Typeface typeFace2 = Typeface.createFromAsset(getAssets(), "font/百度综艺简体.ttf");
        TextView t39=(TextView)findViewById(R.id.textView39);
        TextView t40=(TextView)findViewById(R.id.textView40);
        t39.setTypeface(typeFace2);
        t40.setTypeface(typeFace2);
    }
    public void Exercise(View view) {
        Intent intent = new Intent(this, Exercise.class);
        startActivity(intent);
    }
    public void relax(View view) {
        Intent intent = new Intent(this, relax.class);
        startActivity(intent);
    }
}
