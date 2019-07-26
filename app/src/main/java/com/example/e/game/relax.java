package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.avos.avoscloud.AVUser;
import com.example.e.MainActivity;
import com.example.e.R;

public class relax extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_relax);
        Typeface typeFace1 = Typeface.createFromAsset(getAssets(), "font/全新硬笔楷书.ttf");
        Typeface typeFace2 = Typeface.createFromAsset(getAssets(), "font/百度综艺简体.ttf");
        TextView t42=(TextView)findViewById(R.id.textView42);
        t42.setTypeface(typeFace2);
    }
    public void game_vision(View view) {
        Intent intent = new Intent(this, Vision.class);
        startActivity(intent);

    }
    public void game_fatigue(View view) {
        Intent intent = new Intent(this, Fatigue.class);
        startActivity(intent);

    }
    public void game_astig(View view) {
        Intent intent = new Intent(this, Astig.class);
        startActivity(intent);

    }
    public void game_color(View view) {
        Intent intent = new Intent(this, Color.class);
        startActivity(intent);

    }
    public void returnmain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
