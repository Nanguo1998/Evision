package com.example.e;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVSaveOption;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.GetCallback;
import com.avos.avoscloud.SaveCallback;
import com.example.e.game.Color;
import com.example.e.game.Vision;

public class Person extends AppCompatActivity {
    public String donedays;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AVOSCloud.initialize(this, "0A1lYup3rvVr3iYFaA4TKT91-gzGzoHsz", "Vr1c59fQx1XMUrLoINTVyupo");
        Typeface typeFace1 = Typeface.createFromAsset(getAssets(), "font/全新硬笔楷书.ttf");
       Typeface typeFace2 = Typeface.createFromAsset(getAssets(), "font/百度综艺简体.ttf");
        getSupportActionBar().hide();
        setContentView(R.layout.activity_person);

        TextView Left_Vision = (TextView) findViewById(R.id.leftvision);
        TextView Right_Vision = (TextView) findViewById(R.id.rightvision);
        TextView Colorblindness_Judge = (TextView) findViewById(R.id.colorbindnessjudge);
        TextView sesanjude = (TextView) findViewById(R.id.sesanjudge);
        TextView Password_Reset = (TextView) findViewById(R.id.passwordreset);
        TextView lefteye = (TextView) findViewById(R.id.lefteye);
        TextView righteye = (TextView) findViewById(R.id.righteye);
        TextView username=(TextView)findViewById(R.id.username);
        final TextView flagdaysnum = (TextView) findViewById(R.id.flagdaysnum);
        TextView report = (TextView) findViewById(R.id.report);
        ImageView toMain = (ImageView) findViewById(R.id.Main);


        Password_Reset.setTypeface(typeFace1);
        report.setTypeface(typeFace1);

        report.setTypeface(typeFace1);
        if (AVUser.getCurrentUser() != null) {
            AVUser currentUser = AVUser.getCurrentUser();
            username.setText("用户名："+currentUser.getUsername().toString());
            Left_Vision.setText(currentUser.get("Left_Vision").toString());
            Right_Vision.setText(currentUser.get("Right_Vision").toString());
            String Colorblindness_Flag =currentUser.get("ColorblindnessFlag").toString();
            String sesan_Flag = currentUser.get("sesan_judge").toString();
            Log.d("flag99",Colorblindness_Flag);
            Log.d("flag99",currentUser.get("ColorblindnessFlag").toString());
            if (Colorblindness_Flag=="1") Colorblindness_Judge.setText("色盲");
            else Colorblindness_Judge.setText("非色盲");
            if (sesan_Flag=="1") sesanjude.setText("色散");
            else sesanjude.setText("非色散");

            Left_Vision.setTypeface(typeFace1);
            Right_Vision.setTypeface(typeFace1);
            lefteye.setTypeface(typeFace1);
            righteye.setTypeface(typeFace1);
            Colorblindness_Judge.setTypeface(typeFace1);
            sesanjude.setTypeface(typeFace1);
            username.setTypeface(typeFace1);
        }


        //final Intent PersonVisiontest=new Intent(Person.this, Vision.class);
        //final Intent PersonColoblindnesstest=new Intent(Person.this, Color.class);
        final Intent PersonMain = new Intent(Person.this, MainActivity.class);
        final Intent PersonaForgetpassword = new Intent(Person.this, Forgetpassword.class);
        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PersonMain);
                finish();
            }
        });
        Password_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PersonaForgetpassword);
            }
        });
        final AVQuery<AVObject> query = new AVQuery<>("Leaderboard");
        if(AVUser.getCurrentUser()!=null)
            query.whereContains("Username", AVUser.getCurrentUser().getUsername().toString());

        query.getFirstInBackground(new GetCallback<AVObject>() {
            @Override
            public void done(final AVObject object, AVException e) {
                AVSaveOption option = new AVSaveOption();
                if (AVUser.getCurrentUser() != null) {
                    option.query(new AVQuery<>("Leaderboard").whereEqualTo("Username", AVUser.getCurrentUser().getUsername()));
                    Log.d("message", AVUser.getCurrentUser().getUsername().toString());
                    option.setFetchWhenSave(true);
                    object.saveInBackground(option, new SaveCallback() {
                        @Override
                        public void done(AVException e) {
                            if (e == null) {
                             donedays=object.get("Flag_Days").toString();
                                flagdaysnum.setText("总计打卡天数："+donedays+"天");
                                flagdaysnum.setTypeface( Typeface.createFromAsset(getAssets(), "font/全新硬笔楷书.ttf"));
                                Log.d("flag", "1");
                                Log.d("flag", object.get("Flag_Days").toString());
                                Log.d("flag", object.get("Username").toString());
                            } else {
                                Log.d("flag", "2");
                                Log.d("flag", object.get("Flag_Days").toString());
                                Log.d("flag", object.get("Username").toString());
                            }
                        }
                    });
                }
            }
        });

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        AVOSCloud.initialize(this, "0A1lYup3rvVr3iYFaA4TKT91-gzGzoHsz", "Vr1c59fQx1XMUrLoINTVyupo");
        Typeface typeFace1 = Typeface.createFromAsset(getAssets(), "font/全新硬笔楷书.ttf");
        Typeface typeFace2 = Typeface.createFromAsset(getAssets(), "font/百度综艺简体.ttf");
        getSupportActionBar().hide();
        setContentView(R.layout.activity_person);

        TextView Left_Vision = (TextView) findViewById(R.id.leftvision);
        TextView Right_Vision = (TextView) findViewById(R.id.rightvision);
        TextView Colorblindness_Judge = (TextView) findViewById(R.id.colorbindnessjudge);
        TextView sesanjude = (TextView) findViewById(R.id.sesanjudge);
        TextView Password_Reset = (TextView) findViewById(R.id.passwordreset);
        TextView lefteye = (TextView) findViewById(R.id.lefteye);
        TextView righteye = (TextView) findViewById(R.id.righteye);
        TextView report = (TextView) findViewById(R.id.report);
        final TextView flagdaysnum = (TextView) findViewById(R.id.flagdaysnum);
        ImageView toMain = (ImageView) findViewById(R.id.Main);


        Password_Reset.setTypeface(typeFace1);

        report.setTypeface(typeFace1);
        if (AVUser.getCurrentUser() != null) {
            AVUser currentUser = AVUser.getCurrentUser();
            Left_Vision.setText(currentUser.get("Left_Vision").toString());
            Right_Vision.setText(currentUser.get("Right_Vision").toString());
            String Colorblindness_Flag =currentUser.get("ColorblindnessFlag").toString();
            Log.d("flag99",Colorblindness_Flag);
            String sesan_Flag = currentUser.get("sesan_judge").toString();
            if (Colorblindness_Flag=="1") Colorblindness_Judge.setText("色盲");
            else Colorblindness_Judge.setText("非色盲");
            if (sesan_Flag=="1") sesanjude.setText("色散");
            else sesanjude.setText("非色散");
            Left_Vision.setTypeface(typeFace1);
            Right_Vision.setTypeface(typeFace1);
            lefteye.setTypeface(typeFace1);
            righteye.setTypeface(typeFace1);
            Colorblindness_Judge.setTypeface(typeFace1);
            sesanjude.setTypeface(typeFace1);
        }
        //final Intent PersonVisiontest=new Intent(Person.this, Vision.class);
        //final Intent PersonColoblindnesstest=new Intent(Person.this, Color.class);
        final Intent PersonMain = new Intent(Person.this, MainActivity.class);
        final Intent PersonaForgetpassword = new Intent(Person.this, Forgetpassword.class);
        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PersonMain);
                finish();
            }
        });
        Password_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PersonaForgetpassword);
            }
        });
        final AVQuery<AVObject> query = new AVQuery<>("Leaderboard");
        if(AVUser.getCurrentUser()!=null)
            query.whereContains("Username", AVUser.getCurrentUser().getUsername().toString());
        query.getFirstInBackground(new GetCallback<AVObject>() {
            @Override
            public void done(final AVObject object, AVException e) {
                AVSaveOption option = new AVSaveOption();
                if (AVUser.getCurrentUser() != null) {
                    option.query(new AVQuery<>("Leaderboard").whereEqualTo("Username", AVUser.getCurrentUser().getUsername()));
                    Log.d("message", AVUser.getCurrentUser().getUsername().toString());
                    option.setFetchWhenSave(true);
                    object.saveInBackground(option, new SaveCallback() {
                        @Override
                        public void done(AVException e) {
                            if (e == null) {
                                donedays=object.get("Flag_Days").toString();
                                flagdaysnum.setText("总计打卡天数："+donedays+"天");
                                flagdaysnum.setTypeface(Typeface.createFromAsset(getAssets(), "font/全新硬笔楷书.ttf"));
                                Log.d("flag", "1");
                                Log.d("flag", object.get("Flag_Days").toString());
                                Log.d("flag", object.get("Username").toString());
                            } else {
                                Log.d("flag", "2");
                                Log.d("flag", object.get("Flag_Days").toString());
                                Log.d("flag", object.get("Username").toString());
                            }
                        }
                    });
                }
            }
        });

    }
}
