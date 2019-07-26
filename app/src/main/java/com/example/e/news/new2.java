package com.example.e.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.e.R;

import java.util.ArrayList;
import java.util.List;

public class new2 extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new2);
        initFruits(); // 初始化水果数据
        FruitAdapter adapter = new FruitAdapter(new2.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

    private void initFruits() {

        Fruit food1 = new Fruit("对于程序员来说，主要矛盾是：\n" +
                "已经产生近视疲劳的近视眼需要同不得不盯着电脑屏幕工作之间的矛盾。\n", R.drawable.news_cir);
        fruitList.add(food1);
        Fruit food2 = new Fruit("护眼小技巧：\n" +
                "其实，不要长时间盯着电子屏幕，就是最好的护眼方法。\n" +
                "而程序员的悲惨之处是必须长时间使用电脑。\n" +
                "程序员一工作起来往往进入“忘我”境界。\n" +
                "眼睛已经酸痛到不行了还是编程到无法自拔。\n" +
                "对于互联网时代的护眼方法，在前面的“实用护眼方法”中已经科普得很全面了，\n" +
                "这里给程序员推荐一个小技巧，“强行”要求各位程序员护眼\n", R.drawable.news_cir);
        fruitList.add(food2);
        Fruit food3 = new Fruit("程序员每天使用电脑的时间较长，更应注意没用眼1小时适当休息3~5分钟。\n" +
                "建议你可以在电脑上安装具有“定时提醒”功能的视力保护软件。（例如电脑版“E视界”嘿嘿嘿）\n" +
                "或者既然是程序员，自己写一个闹钟程序，想必也是一件容易的事。\n" +
                "可以设置成，每工作1小时，屏幕自动弹出个提醒框。\n" +
                "或者对于自控能力较差的人，可以直接锁屏3~5分钟。\n" +
                "然后这个时候你就可以随机做一件非工作的小事情：\n", R.drawable.news_cir);
        fruitList.add(food3);
        Fruit food4 = new Fruit("A.\t闭目养神休息，知道电脑恢复正常；\n" +
                "B.\t起身去接一杯水，或泡一杯咖啡；\n" +
                "C.\t或去洗手间上个厕所，照照镜子（看一下自己今天是不是又帅了）；\n" +
                "D.\t走到窗边远眺，思考一下人生；\n" +
                "E.\t静静地听一首歌；\n" +
                "F.\t伸个懒腰，转转眼睛。\n", R.drawable.news_cir);
        fruitList.add(food4);





    }

}
