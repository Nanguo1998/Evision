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

public class new4 extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new4);
        initFruits(); // 初始化水果数据
        FruitAdapter adapter = new FruitAdapter(new4.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

    private void initFruits() {

        Fruit food1 = new Fruit("黑眼圈是由于熬夜，情绪波动大，眼疲劳、衰老导致眼部皮肤血管血流速度过于缓慢形成滞流；组织供氧不足，血管中代谢废物积累过多，造成眼部色素沉着。年纪愈大的人，眼睛周围的皮下脂肪变得愈薄，所以黑眼圈就更明显。\n\n除了少数人是天生色素沉淀致此，目前大多数人还是认为由于疲劳、没休息好导致，多注意休息就会恢复。\n", R.drawable.news_cir);
        fruitList.add(food1);
        Fruit food2 = new Fruit("消除黑眼圈的秘诀\n", R.drawable.news_cir);
        fruitList.add(food2);
        Fruit food3 = new Fruit("1：冷热毛巾交替敷眼在早上睡醒后立刻用和自己体温产不多的热毛巾敷眼，然后在用冷却的毛巾交换敷眼，10分钟左右就可以让你的黑眼圈淡化一半哦。因为大多数黑眼圈的产生都是因为睡眠不足导致眼部周围血液循环不通常，所以出现黑色素沉淀的现象。\n", R.drawable.news_cir);
        fruitList.add(food3);
        Fruit food4 = new Fruit("2：黄瓜补水眼膜黄瓜眼膜能够另皮肤变得更加光亮，非常适合深夜使用，将黄瓜切碎后和酸奶混合，然后用2个绿茶袋，并在其中加入混合好的黄瓜，放入冰箱5分钟，然后取出冰袋放在眼睛上部10分钟左右即可。\n", R.drawable.news_cir);
        fruitList.add(food4);
        Fruit food5 = new Fruit("3：多做眼部按摩+睡前喝水要适量容易产生黑眼圈的人应该多做运动，或者常做脸部及眼部按摩，帮助脸部肌肤能够进行局部血液循环，并尽可能少吃过咸或过辣的食物。睡前吃太多口味过重的食物，喝太多的水，都是形成眼泡水肿和眼袋的原因。", R.drawable.news_cir);
        fruitList.add(food5);


    }

}
