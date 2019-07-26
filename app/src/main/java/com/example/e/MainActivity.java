package com.example.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVSaveOption;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.GetCallback;
import com.avos.avoscloud.SaveCallback;
import com.example.e.Calendar.Calendar;
import com.example.e.EPV.EPV;
import com.example.e.game.mainact;
import com.example.e.news.News;
import com.example.e.utils.PermissionUtil;
import com.example.e.view.CusRead;

//主页面
//调光-
//Flag-
//时长监控-
//轻松一刻，护眼常识-
public class MainActivity extends AppCompatActivity {
    public String doneDays;
    private Typeface typeFace1;
    private AVUser currentUser;
    private CusRead cusRead;
    private Typeface typeFace2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        AVOSCloud.initialize(this, "0A1lYup3rvVr3iYFaA4TKT91-gzGzoHsz", "Vr1c59fQx1XMUrLoINTVyupo");
        typeFace1 = Typeface.createFromAsset(getAssets(), "font/全新硬笔楷书.ttf");
        typeFace2=Typeface.createFromAsset(getAssets(),"font/百度综艺简体.ttf");
        getSupportActionBar().hide();
        currentUser = AVUser.getCurrentUser();
        //
        /*
        currentUser.put("Left_Vision","5.0");
        currentUser.saveInBackground();
        */
        if (currentUser == null) {
            Intent Intent_SignIn = new Intent(MainActivity.this, Signin.class);
            startActivity(Intent_SignIn);
            finish();
        }
        setContentView(R.layout.activity_main);
        initView();
        initLightView();
    }

    private void initLightView() {
        //检查权限
        cusRead = findViewById(R.id.cusread);
        PermissionUtil.checkWindowPermission(this);
        PermissionUtil.checkPermissions(this);
        PermissionUtil.startRequestPermission(this);
        if (PermissionUtil.isWindwos)
            openWindows();

    }

    private void initView() {
        getSupportActionBar().hide();
        ImageView Person = (ImageView) findViewById(R.id.personalInformation);
        //通过点击图片触发
        ImageView Relax = (ImageView) findViewById(R.id.relax);
        ImageView Leader_board = (ImageView) findViewById(R.id.leaderboard);
        ImageView Eyes_care = (ImageView) findViewById(R.id.eyescare);
        ImageView To_flag=(ImageView)findViewById(R.id.toflagpic);
        //前往打卡模块 刘魁元
        ImageView To_timer=(ImageView)findViewById(R.id.totimer);
        //前往手机使用时间模块 姚旭晟

        ImageView flagpic=(ImageView)findViewById(R.id.flagpic);
        TextView Relax_Word = (TextView) findViewById(R.id.relax_word);
        TextView Leaderboard_Word = (TextView) findViewById(R.id.leaderboard_word);
        TextView Eyescare_Word = (TextView) findViewById(R.id.eyescare_word);
        TextView Flag_Word=(TextView)findViewById(R.id.flagword);
        TextView Usedhours_Word=(TextView)findViewById(R.id.usedhoursword);
        TextView Tips=(TextView)findViewById(R.id.tips);
        //final TextView Donedays = (TextView) findViewById(R.id.donedaysnumber);
        TextView Sign_out = (TextView) findViewById(R.id.signout);

        //从数据库中读取
        TextView Flaghours_num=(TextView)findViewById(R.id.flaghoursnum);
        TextView Usedhours_num=(TextView)findViewById(R.id.usedhoursnum);
        //
        Relax_Word.setTypeface(typeFace2);
        Leaderboard_Word.setTypeface(typeFace2);
        Eyescare_Word.setTypeface(typeFace2);
        Flag_Word.setTypeface(typeFace2);
        Usedhours_Word.setTypeface(typeFace2);
        Tips.setTypeface(typeFace2);
        Sign_out.setTypeface(typeFace1);
        final Intent MainPerson = new Intent(MainActivity.this, Person.class);
        final Intent MainLeaderboard = new Intent(MainActivity.this, Leaderboard.class);
        final Intent MainSignin = new Intent(MainActivity.this, Signin.class);
        final AVUser current = AVUser.getCurrentUser();

        //事件
        Person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MainPerson);
                finish();
            }
        });
        Leader_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MainLeaderboard);
            }
        });
        Sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AVUser.logOut();
                AVUser currentUser = AVUser.getCurrentUser();
                startActivity(MainSignin);
                finish();
            }
        });
        //刘魁元
        To_flag.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                getSupportActionBar().hide();
                Intent intent = new Intent(MainActivity.this, EPV.class);
                startActivity(intent);
                finish();
            }
        });

        flagpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Calendar.class);
                startActivity(intent);
            }
        });
        //姚旭晟
        To_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //从数据库中读取
        if(AVUser.getCurrentUser()!=null) {
            Flaghours_num.setText(AVUser.getCurrentUser().get("Screen_HoursFlag").toString()+"小时");
            Usedhours_num.setText(AVUser.getCurrentUser().get("Screen_Hours").toString());
        }
        //读写打卡天数-如需使用 可将整块代码直接复制到需要的模块
        final AVQuery<AVObject> query = new AVQuery<>("Leaderboard");
        if(AVUser.getCurrentUser()!=null)
        query.whereContains("Username", AVUser.getCurrentUser().getUsername().toString());

        query.getFirstInBackground(new GetCallback<AVObject>() {
            @Override
            public void done(final AVObject object, AVException e) {
                AVSaveOption option = new AVSaveOption();
                if (AVUser.getCurrentUser() != null) {
                    option.query(new AVQuery<>("Leaderboard").whereEqualTo("Username", currentUser.getUsername()));
                    Log.d("message", AVUser.getCurrentUser().getUsername().toString());
                    option.setFetchWhenSave(true);
                    object.saveInBackground(option, new SaveCallback() {
                        @Override
                        public void done(AVException e) {
                            if (e == null) {
                                doneDays = object.get("Flag_Days").toString();
                                //Donedays.setText(doneDays);
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
   //读写打卡天数



    public void openWindows() {
        cusRead.openAleterWindow();
        cusRead.initListner();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
//        super.onBackPressed();
    }

    //检查权限
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 101) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!Settings.canDrawOverlays(this)) {
                    Toast.makeText(this, "授权失败无法打开弹窗", Toast.LENGTH_LONG).show();
                } else
                    openWindows();
            }
        } else if (requestCode == 100) {
            if (Build.VERSION.SDK_INT >= 23) {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermissionUtil.REQUEST_PERMISSION_CALL:
                if (grantResults.length > 0) {
                    try {
                        for (int i = 0; i < grantResults.length; i++) {
                            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                                Log.e("sdf", "权限被居居");
//                                    Toast.makeText(MainActivity.this, "权限被拒绝", Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        try {
                            Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
                            Toast.makeText(MainActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
                        } catch (Exception localException) {
                            localException.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                break;
        }
    }


    public void news(View view) {
        Intent intent = new Intent(this, News.class);
        startActivity(intent);
    }
    public void mainact(View view) {
        Intent intent = new Intent(this, mainact.class);
        startActivity(intent);
    }

}
