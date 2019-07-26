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

public class new1 extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1);
        initFruits(); // 初始化水果数据
        FruitAdapter adapter = new FruitAdapter(new1.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

    private void initFruits() {
        Fruit food1 = new Fruit("大家好，小伙伴们每天都要花很长的时间盯着电脑，长期以此，就会感到眼干眼涩，眼睛不舒服的状态。辣么，若要从饮食方面来改善这种状态，那我们应该吃什么好呢。\n", R.drawable.news_cir);
        fruitList.add(food1);
        Fruit food2 = new Fruit("胡萝卜：\n" +
                "小伙伴也许听过胡萝卜有富含丰富的维生素A，它促进了视网膜内视紫红质的合成，的确。食用胡萝卜要注意，生吃胡萝卜几乎是无效的，胡萝卜素是脂溶性的，要与油脂吃才可以被吸收，在如图中转化为a原，所以最好是熟食。\n", R.drawable.news_cir);
        fruitList.add(food2);
        Fruit food3 = new Fruit("动物肝脏，鱼类：\n" +
                "小伙伴可以发现身边的朋友吃鱼的大部分都是视力比较好的，是的，鱼体中有丰富的氨基酸等营养物质，这些有助于保护眼的作用。\n" +
                "动物肝脏的维生素A远远超越其他肉类等食品，能防止眼睛干涩，疲劳等症状。\n", R.drawable.news_cir);
        fruitList.add(food3);
        Fruit food4 = new Fruit("菠菜：\n" +
                "菠菜含有丰富的维生素b2和维生素b，维生素b2可有效防止眼睛出现血丝，而维生素b可在人体转化成维生素a 所以多吃菠菜是有好处的。另外多吃深绿色蔬菜，对眼睛也是个很好的帮助。\n", R.drawable.news_cir);
        fruitList.add(food4);
        Fruit food5 = new Fruit("鸡蛋：\n" +
                "鸡蛋的蛋黄有着丰富的叶黄素和玉米黄素，而这俩种营养是世界公认对眼睛好的，由于鸡蛋的高胆固醇较多，每天半个到一个为宜。学生每天一个不仅对眼有好处，且能增强数学思维。\n", R.drawable.news_cir);
        fruitList.add(food5);
        Fruit food6 = new Fruit("蓝莓：\n" +
                "蓝莓含有大量花青素，促进视网膜中的视紫质再生成，预防视网膜剥离，增进视力。\n" +
                "叶黄素酯：眼底黄斑区的主要组成部分，保护视力，防止眼部病变。\n", R.drawable.news_cir);
        fruitList.add(food6);
        Fruit food7 = new Fruit("玉米黄质：\n眼底黄斑区的主要组成部分，可增强眼睛对抗光线损害的能力。\n" , R.drawable.news_cir);
        fruitList.add(food7);
        Fruit food8 = new Fruit("松子油：\n具有抗氧化和清除自由基的作用，抑制自由基对眼部皮肤的损害。\n" , R.drawable.news_cir);
        fruitList.add(food8);
        Fruit food9 = new Fruit("紫苏籽油：\n含α-亚麻酸，含不饱和脂肪酸，有润滑血管、保肝，保护视力的作用。\n" , R.drawable.news_cir);
        fruitList.add(food9);
        Fruit food10 = new Fruit("壳寡糖：\n自然界中唯一带正电荷阳离子碱性氨基低聚糖，抗病毒、消炎，预防眼部病变。\n" , R.drawable.news_cir);
        fruitList.add(food10);


    }

}
