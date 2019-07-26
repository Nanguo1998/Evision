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

public class new3 extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new3);
        getSupportActionBar().hide();
        initFruits(); // 初始化水果数据
        FruitAdapter adapter = new FruitAdapter(new3.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

    private void initFruits() {

        Fruit food1 = new Fruit("隐形眼镜对眼睛危害大，所以大家能不用隐形眼镜就不用隐形眼镜.哦.....如果避免不了，那就注意以下几项：\n", R.drawable.news_cir);
        fruitList.add(food1);
        Fruit food2 = new Fruit("第一、能不能带眼镜需要眼科医生的详细检查。除常规检查外，还应进行医学验光、角膜曲率半径测定、角膜荧光素染色检查等。\n", R.drawable.news_cir);
        fruitList.add(food2);
        Fruit food3 = new Fruit("第二、隐形眼镜不只一种！角膜接触镜主要分为软性和硬性两大类：\n" +
                "硬性角膜接触镜矫正散光较好、耐用、消毒护理简单、价格低，但异物感明显，适应期较长；硬性角膜接触镜最常见的就是角膜矫正接触镜（OK镜）和硬性透氧性角膜接触镜（RGP），都是由同一种隐形眼镜材料制成。\n" +
                "软性角膜接触镜异物感少、易适应、但散光矫正差、不耐用、护理麻烦、价格较贵。软性角膜接触镜根据其透氧量及含水量分为日抛型、月抛型等；\n" +
                "戴镜者应在正规验光师及专业人员的帮助下选择镜片。\n", R.drawable.news_cir);
        fruitList.add(food3);
        Fruit food4 = new Fruit("第三：隐形眼镜浸泡液每两天就要更换！每位戴镜者一定要按照使用说明书中规定的操作规程戴镜和摘镜，并且要认真地做好镜片的消毒和清洗。不同品牌、不同类型的护理液绝对不能替代或混用，不能随便用洗涤剂、食盐水或自来水清洁镜片。隐形眼镜一定要经手搓洗30秒以上，也不能长期浸泡在药水中，通常2天要更换一次新的浸泡液，每周固定去蛋白，双氧消毒系统一定要中和后才可使用。\n", R.drawable.news_cir);
        fruitList.add(food4);
        Fruit food5 = new Fruit("第四：异物进眼怎么处理？常见的异物有灰尘、沙粒、液体、睫毛和化妆品。戴隐形眼镜期间若有异物入眼，应立即取下镜片，用清水冲洗镜片并待眼睛充分缓解之后再戴上镜片，也要避免大幅度揉眼睛，避免异物损伤镜片和眼睛，同时避免镜片偏离正常的位置或造成脱离丢失。\n", R.drawable.news_cir);
        fruitList.add(food5);
        Fruit food6 = new Fruit("第五、眼睛发炎时不能带隐形眼镜！如睑缘炎、麦粒肿、睑内翻倒睫、泪囊炎、泪液分泌不足、干眼、结膜炎、沙眼、角膜炎、青光眼、巩膜炎、虹膜睫状体炎等，都不应使用隐形眼镜。\n", R.drawable.news_cir);
        fruitList.add(food6);
        Fruit food7 = new Fruit("第六、月经期不适合带隐形眼镜！经期戴隐形易造成眼充血，这是因为女性在月经期间眼压比平常要高，眼球四周也较易充血，痛经的女性更是如此，这时如果戴隐形眼镜，会对眼球产生不良影响。\n", R.drawable.news_cir);
        fruitList.add(food7);
        Fruit food8 = new Fruit("第七、佩戴隐形眼镜后还应定期到眼科检查，若有不适感或门诊随诊发现问题，应在医生的指导下进行进一步诊治。\n", R.drawable.news_cir);
        fruitList.add(food8);



    }

}
