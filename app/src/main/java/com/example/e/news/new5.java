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

public class new5 extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new5);
        initFruits(); // 初始化水果数据
        FruitAdapter adapter = new FruitAdapter(new5.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

    private void initFruits() {

        Fruit food1 = new Fruit("1.多眨眼。\n" +
                "正常情况下，每分钟的眨眼次数大约 15～20 次。如果长时间盯着电脑，眨眼次数会明显减少，记得提醒自己多眨眼。\n", R.drawable.news_cir);
        fruitList.add(food1);
        Fruit food2 = new Fruit("2.多休息。\n" +
                "每隔一段时间就看看远处，时长自己把握，最好不要超过 1 个小时。注意，这里强调的是「远处」两个字。\n" +
                "晚上保证有质量的睡眠。\n", R.drawable.news_cir);
        fruitList.add(food2);
        Fruit food3 = new Fruit("3.调整电脑位置和屏幕显示。\n" +
                "电脑位置：\n电脑屏幕与眼睛的水平距离应为50-60cm。\n" +
                "屏幕中心与眼睛的竖直距离应为10-15cm，使视线水平或稍向下。\n" +
                "电脑屏幕略倾斜。\n"+"屏幕显示：\n保证字体大小为不用眯眼就能看清的范围。\n" +
                "调整屏幕亮度为不刺眼、不费力就能看清。\n", R.drawable.news_cir);
        fruitList.add(food3);
        Fruit food4 = new Fruit("4.热敷眼睛。\n" +
                "用温水或热水弄湿毛巾，热敷眼睛，注意不要温度太高而烫着自己。\n", R.drawable.news_cir);
        fruitList.add(food4);
        Fruit food5 = new Fruit("5.使用加湿器。\n" +
                "空气干燥，可以加一台空气加湿器。\n", R.drawable.news_cir);
        fruitList.add(food5);
        Fruit food6 = new Fruit("6. 配一副合适的眼镜。\n" +
                "感觉看不清楚的，一定要带上眼镜看，不要勉强用眼。\n", R.drawable.news_cir);
        fruitList.add(food6);
        Fruit food7 = new Fruit("7. 摘下隐形眼镜，让眼睛透透气。\n" +
                "不要戴着隐形眼镜睡觉，平时也要偶尔戴一下框架眼镜。\n", R.drawable.news_cir);
        fruitList.add(food7);
        Fruit food8 = new Fruit("8. 增加户外活动。\n" +
                "生命在于运动。\n", R.drawable.news_cir);
        fruitList.add(food8);



    }

}
