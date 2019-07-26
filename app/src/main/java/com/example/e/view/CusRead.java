package com.example.e.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.e.R;
import com.example.e.utils.*;

public class CusRead extends RelativeLayout implements View.OnClickListener {

    private Context context;
    SeekBar sb_ld,sb_r,sb_b,sb_g;
    RadioGroup radio;
    ImageView iv_main;
    Button btn_auto;
    TextView text_title;
    Dialog dialog;

    //红蓝绿 三原色的初始值
    private int blue=0;
    private int red=0;
    private int green=0;
    private int alapha=0;

    private int blueProgress=0;
    private int redProgress=0;
    private int greenProgress=0;
    private int alaphaProgress=0;


    private int current_alapha = 100;
    private boolean isAuto = false;

    public CusRead(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CusRead(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public void init(){
        LayoutInflater.from(context).inflate(R.layout.read,this);
        initView();
//        openAleterWindow();
        initData();
//        initListner();
    }

    private void initView() {
        radio=findViewById(R.id.read_group_readio);
        sb_ld=findViewById(R.id.sb_ld);
        sb_r=findViewById(R.id.sb_r);
        sb_b=findViewById(R.id.sb_b);
        sb_g=findViewById(R.id.sb_g);
        btn_auto=findViewById(R.id.eye_btn);
        text_title=findViewById(R.id.eye_text);

        btn_auto.setOnClickListener(this);
    }

    //智能点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.eye_btn:
                    isAuto = !isAuto;
                    if(isAuto){
                        btn_auto.setBackgroundResource(R.drawable.eye_on);
                        text_title.setText("智能模式");
                    }
                    else{
                        btn_auto.setBackgroundResource(R.drawable.eye_off);
                        text_title.setText("手动模式");
                    }
                break;
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0://处理智能模式
                    sb_ld.setProgress(256-TimeTool.getAutoAlapha());
                    break;
            }
        }
    };


    //模式反应逻辑
    public void initListner() {
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = radioGroup.getCheckedRadioButtonId();
                String title = "";
                switch (id){
                    case R.id.radio_game:
                        iv_main.setBackgroundResource(R.color.color_game);
                        title="游戏模式,在玩游戏的时候视觉体验更佳";
                        break;

                    case R.id.radio_outdoor:
                        iv_main.setBackgroundResource(R.color.color_outdoor);
                        title="外出模式，抵抗外来光线污染";
                        break;

                    case R.id.radio_read:
                        iv_main.setBackgroundResource(R.color.color_read);
                        title="阅读模式，给人阅读更好的体验";
                        break;

                    case R.id.radio_recommend:
                        iv_main.setBackgroundResource(R.color.color_recommend);
                        title="助眠模式，帮助你更好的入眠";
                        break;

                    case R.id.radio_normal:
                        iv_main.setBackgroundColor(Color.alpha(current_alapha));
                        title="恢复手动状态";
                        break;
                }
                text_title.setText(title);
//                sb_ld.setProgress(40);
            }
        });

        sb_ld.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int add=progress-alaphaProgress;
                alapha=alapha+add;
                alaphaProgress=progress;
                Log.e("this","alapha"+(alapha-256));
                iv_main.setBackgroundColor(Color.argb(alapha, red, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        sb_r.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int add=progress-redProgress;
                red=red-add;
                redProgress=progress;
                Log.e("this","red:"+red);
                iv_main.setBackgroundColor(Color.argb(alapha,red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        sb_b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int add=progress-blueProgress;
                blue=blue-add;
                blueProgress=progress;
                Log.e("this","blue:"+blue);
                iv_main.setBackgroundColor(Color.argb(alapha,red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int add=progress-greenProgress;
                green=green-add;
                greenProgress=progress;
                Log.e("this","green:"+green);
                iv_main.setBackgroundColor(Color.argb(alapha,red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public  void initData(){    //每当打开acitivy 对 sharedprefernces 初始化
        SharedPreferences myPreference=((Activity)context).getSharedPreferences("myPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPreference.edit();
        editor.putInt("alapha",256);
        editor.putInt("red", 256);
        editor.putInt("blue", 256);
        editor.putInt("green", 256);

        editor.commit();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    if(isAuto) {
                        handler.sendEmptyMessage(0);
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            }
        }).start();
    }

    public void getData(){  //获取 存储 sharePrefrence 保存的三原色值
        SharedPreferences preferences=((Activity)context).getSharedPreferences("myPreference", Context.MODE_PRIVATE);
        alapha=preferences.getInt("alapha",256);
        red=preferences.getInt("red",256);
        green=preferences.getInt("green",256);
        blue=preferences.getInt("blue",256);
        sb_ld.setProgress(256-alapha);
        sb_r.setProgress(256-red);
        sb_g.setProgress(256-green);
        sb_b.setProgress(256-blue);
        iv_main.setBackgroundColor(Color.argb(alapha,red,green,blue));
//        changeAppBrightness(ld);
    }

    public void saveData(){
        SharedPreferences myPreference=((Activity)context).getSharedPreferences("myPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPreference.edit();
        if(alapha>=0&&alapha<=255&&red>=0&&red<=100&&blue>=0&blue<=100&&green>=0&&green<=100) {
            editor.putInt("alapha", alapha);
            editor.putInt("red", red);
            editor.putInt("blue", blue);
            editor.putInt("green", green);
            editor.commit();
        }


    }


    public void openAleterWindow() {   //打开 dailog 窗口 对 dailog 初始化

        dialog=new Dialog(context,R.style.dialog_translucent);
        dialog.setContentView(R.layout.dailog);


        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();//获取布局参数
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.flags =WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;  //设置不影响下层的触碰
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            lp.type=WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }else{
            lp.type=WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        }


        dialog.getWindow().setAttributes(lp);

        if(!((Activity)context).isFinishing())
            dialog.show();



        iv_main=dialog.findViewById(R.id.ll_main);
        getData();


    }



    public void permission(){

//        if (Build.VERSION.SDK_INT >= 23) {
//            if(!Settings.canDrawOverlays(this)) {
//                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
//                startActivity(intent);
//            }
//        }
    }


    public void changeAppBrightness(int brightness) {   //改变系统屏幕亮度
        WindowManager.LayoutParams lp = ((Activity)context).getWindow().getAttributes();
        Float ld=Float.valueOf(brightness) * (1f / 100f);
        Log.e("this","ld:"+ld);
        lp.screenBrightness = ld;

        ((Activity)context).getWindow().setAttributes(lp);
    }

}
