package com.example.e;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AVOSCloud.initialize(this,"0A1lYup3rvVr3iYFaA4TKT91-gzGzoHsz","Vr1c59fQx1XMUrLoINTVyupo");
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_signin);
        getSupportActionBar().hide();
        Typeface typeFace1 = Typeface.createFromAsset(getAssets(), "font/全新硬笔楷书.ttf");
        Typeface typeFace2 = Typeface.createFromAsset(getAssets(), "font/百度综艺简体.ttf");
        TextView usrname=(TextView)findViewById(R.id.username);
        TextView password=(TextView)findViewById(R.id.password);
        final EditText Username=(EditText)findViewById(R.id.Username);
        final EditText Password=(EditText)findViewById(R.id.Password);
        TextView SignIn=(TextView)findViewById(R.id.signin);
        TextView SignUp=(TextView)findViewById(R.id.signup);
        TextView ForgetPassword=(TextView)findViewById(R.id.forgetpassword);
        TextView TextView1=(TextView)findViewById(R.id.textView1);
        TextView TextView2=(TextView)findViewById(R.id.textView2);

        usrname.setTypeface(typeFace2);
        password.setTypeface(typeFace2);
        //Username.setTypeface(typeFace);
        //Password.setTypeface(typeFace);
        SignIn.setTypeface(typeFace1);
        SignUp.setTypeface(typeFace1);
        ForgetPassword.setTypeface(typeFace1);
        //TextView1.setTypeface(typeFace);
        //TextView2.setTypeface(typeFace);
        final Intent SigninSignup=new Intent(Signin.this,Signup.class);
        final Intent SigninMain=new Intent(Signin.this,MainActivity.class);
        final Intent SigninForgetpassword=new Intent(Signin.this,Forgetpassword.class);
        final AlertDialog.Builder SignInSuccess=new AlertDialog.Builder(Signin.this);
        final AlertDialog.Builder SignInFail=new AlertDialog.Builder(Signin.this);
        final Intent ReSignin=new Intent(Signin.this,Signin.class);
        SignInSuccess.setTitle("提示");
        SignInSuccess.setMessage("登录成功\n确认后将进入主页面");
        SignInSuccess.setCancelable(false);
        SignInSuccess.setPositiveButton("确认",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog,int which){
                startActivity(SigninMain);
                finish();
            }
        });
        SignInSuccess.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                setContentView(R.layout.activity_signin);
            }
        });
        SignInFail.setTitle("提示");
        SignInFail.setMessage("用户名或密码错误\n请重新输入");
        SignInSuccess.setCancelable(false);
        SignInFail.setPositiveButton("确认",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog,int which){
                startActivity(ReSignin);
                finish();
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User_name=Username.getText().toString();
                String Pass_word=Password.getText().toString();
                AVUser.logInInBackground(User_name, Pass_word, new LogInCallback<AVUser>() {
                    @Override
                    public void done(AVUser user, AVException e) {
                        if(e==null){
                            SignInSuccess.show();
                        }else{
                            SignInFail.show();
                        }
                    }
                });
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SigninSignup);
                finish();
            }
        });

        ForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SigninForgetpassword);
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        AVOSCloud.initialize(this,"0A1lYup3rvVr3iYFaA4TKT91-gzGzoHsz","Vr1c59fQx1XMUrLoINTVyupo");
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_signin);
        getSupportActionBar().hide();
        Typeface typeFace1 = Typeface.createFromAsset(getAssets(), "font/全新硬笔楷书.ttf");
        Typeface typeFace2 = Typeface.createFromAsset(getAssets(), "font/百度综艺简体.ttf");
        TextView usrname=(TextView)findViewById(R.id.username);
        TextView password=(TextView)findViewById(R.id.password);
        final EditText Username=(EditText)findViewById(R.id.Username);
        final EditText Password=(EditText)findViewById(R.id.Password);
        TextView SignIn=(TextView)findViewById(R.id.signin);
        TextView SignUp=(TextView)findViewById(R.id.signup);
        TextView ForgetPassword=(TextView)findViewById(R.id.forgetpassword);
        TextView TextView1=(TextView)findViewById(R.id.textView1);
        TextView TextView2=(TextView)findViewById(R.id.textView2);

        usrname.setTypeface(typeFace2);
        password.setTypeface(typeFace2);
        //Username.setTypeface(typeFace);
        //Password.setTypeface(typeFace);
        SignIn.setTypeface(typeFace1);
        SignUp.setTypeface(typeFace1);
        ForgetPassword.setTypeface(typeFace1);
        //TextView1.setTypeface(typeFace);
        //TextView2.setTypeface(typeFace);
        final Intent SigninSignup=new Intent(Signin.this,Signup.class);
        final Intent SigninMain=new Intent(Signin.this,MainActivity.class);
        final Intent SigninForgetpassword=new Intent(Signin.this,Forgetpassword.class);
        final Intent ReSignin=new Intent(Signin.this,Signin.class);
        final AlertDialog.Builder SignInSuccess=new AlertDialog.Builder(Signin.this);
        final AlertDialog.Builder SignInFail=new AlertDialog.Builder(Signin.this);
        SignInSuccess.setTitle("提示");
        SignInSuccess.setMessage("登录成功\n确认后将进入主页面");
        SignInSuccess.setCancelable(false);
        SignInSuccess.setPositiveButton("确认",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog,int which){
                startActivity(SigninMain);
                finish();
            }
        });
        SignInSuccess.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                setContentView(R.layout.activity_signin);
            }
        });
        SignInFail.setTitle("提示");
        SignInFail.setMessage("用户名或密码错误\n请重新输入");
        SignInSuccess.setCancelable(false);
        SignInFail.setPositiveButton("确认",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog,int which){
                startActivity(ReSignin);
                finish();
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User_name=Username.getText().toString();
                String Pass_word=Password.getText().toString();
                AVUser.logInInBackground(User_name, Pass_word, new LogInCallback<AVUser>() {
                    @Override
                    public void done(AVUser user, AVException e) {
                        if(e==null){
                            SignInSuccess.show();
                        }else{
                            SignInFail.show();
                        }
                    }
                });
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SigninSignup);
                finish();
            }
        });

        ForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SigninForgetpassword);
            }
        });
    }
}

