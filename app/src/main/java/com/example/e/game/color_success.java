package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.avos.avoscloud.AVUser;
import com.example.e.R;

public class color_success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_color_success);
    }
    public void returnmain(View view) {
        Intent intent = new Intent(this, relax.class);
        startActivity(intent);
        final AVUser currentUser= AVUser.getCurrentUser();
        currentUser.put("ColorblindnessFlag","0");
        currentUser.saveInBackground();
        finish();
    }
}
