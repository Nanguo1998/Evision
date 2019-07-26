package com.example.e.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.avos.avoscloud.AVUser;
import com.example.e.MainActivity;
import com.example.e.R;

public class stopvision39 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_stopvision39);
    }
    public void lreturnmain(View view) {
        Intent intent = new Intent(this, relax.class);
        startActivity(intent);
        final AVUser currentUser= AVUser.getCurrentUser();
        currentUser.put("Left_Vision","4.4");
        currentUser.saveInBackground();
        finish();
    }
    public void rreturnmain(View view) {
        Intent intent = new Intent(this, relax.class);
        startActivity(intent);
        final AVUser currentUser= AVUser.getCurrentUser();
        currentUser.put("Right_Vision","4.4");
        currentUser.saveInBackground();
        finish();
    }
}
