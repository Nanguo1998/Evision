package com.example.e;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.RequestPasswordResetCallback;

public class Forgetpassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AVOSCloud.initialize(this,"0A1lYup3rvVr3iYFaA4TKT91-gzGzoHsz","Vr1c59fQx1XMUrLoINTVyupo");
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "font/全新硬笔楷书.ttf");
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        final EditText E_mail=(EditText)findViewById(R.id.email);
        Button Send=(Button)findViewById(R.id.send);
        TextView Forgetpassword_Tips=(TextView)findViewById(R.id.forgetpasswordtips);
        E_mail.setTypeface(typeFace);
        Send.setTypeface(typeFace);
        Forgetpassword_Tips.setTypeface(typeFace);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=E_mail.getText().toString();
                AVUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {
                    @Override
                    public void done(AVException e) {
                        if(e==null){
                            Toast.makeText(Forgetpassword.this,"重置密码邮件已发送",Toast.LENGTH_LONG).show();
                             for(int i=0;i<100;i++);
                             finish();//回到上一个界面
                        }else setContentView(R.layout.activity_forgetpassword);
                    }
                });
            }
        });
    }
}
