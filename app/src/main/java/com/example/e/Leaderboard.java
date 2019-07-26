package com.example.e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
//排行榜
//适配器 RanklistAdapter
public class Leaderboard extends AppCompatActivity {


    //暂时存放用户名
    public String[]usernames=new String[999];
    //暂时存放打卡天数
    public Integer[]flagdayss=new Integer[999];
    public class rankList{
        //用户名
        private String username;
        //打卡天数
        private Integer flagdays;
        public rankList(String username,Integer days)
        {
            this.username=username;
            this.flagdays=days;
        }
        public String getUsername()
        {
            return username;
        }
        public Integer getDays()
        {
            return flagdays;
        }
    }


    //private List<rankList>rankLists=new ArrayList<rankList>();

    public ArrayList<rankList> rankLists=new ArrayList<rankList>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AVOSCloud.initialize(this,"0A1lYup3rvVr3iYFaA4TKT91-gzGzoHsz","Vr1c59fQx1XMUrLoINTVyupo");

        super.onCreate(savedInstanceState);
        int i=0;
        //初始化
        for(;i<999;i++){
            usernames[i]=null;
            flagdayss[i]=null;
        }





        AVQuery<AVObject> query=new AVQuery<>("Leaderboard");

        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException avException) {
                LinkedList<AVObject>users=(LinkedList<AVObject>)list;
                int i=0;

                for (AVObject user:list){
                    //取值
                    usernames[i]=user.get("Username").toString();
                    flagdayss[i]=(Integer)user.get("Flag_Days");
                    //强制类型转换
                    i++;
                }
                Log.d("flag","here");
                int j=0;
                while (usernames[j]!=null)
                {
                    String usrname=usernames[j];
                    System.out.print(usrname);
                    Integer flagdays=flagdayss[j];
                    System.out.println(flagdays);
                    rankList newuser=new rankList((String) usrname,(Integer) flagdays);

                    rankLists.add(newuser);
                    j++;
                }

                rankLists.sort(new Comparator<rankList>() {
                    @Override
                    public int compare(rankList u1, rankList u2) {

                        return u2.getDays().compareTo(u1.getDays());
                    }
                });
                LinearLayoutManager layoutManager=new LinearLayoutManager(Leaderboard.this);

                RanklistAdapter ranklistAdapter=new RanklistAdapter(Leaderboard.this,R.layout.person_item,
                        rankLists);
                ListView listView=(ListView)findViewById(R.id.leaderboardlistview);
                listView.setAdapter(ranklistAdapter);
            }
        });
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "font/全新硬笔楷书.ttf");
        getSupportActionBar().hide();

        setContentView(R.layout.activity_leaderboard);
        ImageView tomain=(ImageView)findViewById(R.id.tomainpic);
        TextView title=(TextView)findViewById(R.id.textView3);
        TextView username_word =(TextView)findViewById(R.id.userName_word);
        TextView flagdays_word=(TextView)findViewById(R.id.flagDays_word);
        title.setTypeface(typeFace);
        username_word.setTypeface(typeFace);
        flagdays_word.setTypeface(typeFace);
        tomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LeaderboardMain=new Intent(Leaderboard.this,MainActivity.class);
                startActivity(LeaderboardMain);
                finish();
            }
        });
    }

}
