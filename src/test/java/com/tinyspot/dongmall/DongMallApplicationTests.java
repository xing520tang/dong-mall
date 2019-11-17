package com.tinyspot.dongmall;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tinyspot.dongmall.entity.Goods;
import com.tinyspot.dongmall.entity.GoodsT;
import com.tinyspot.dongmall.entity.Temp;
import com.tinyspot.dongmall.mapper.GoodsMapper;
import com.tinyspot.dongmall.util.Convert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DongMallApplicationTests {

    @Autowired
    GoodsMapper goodsMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMd5(){

        Digester sha = new Digester(DigestAlgorithm.SHA1);
        String hex = sha.digestHex("123456");
        System.out.println(hex);
    }

    @Test
    public void importdata(){
        File file = new File("G://八爷/样例完整版/shop.txt");
        JSONObject jsonObject = JSONUtil.readJSONObject(file, Charset.forName("utf-8"));
        System.out.println(jsonObject);

        Temp temp = JSONUtil.toBean(jsonObject, Temp.class);
//        Goods goods = Convert.goodstTogoods(temp.getGoods_detail().get(1));
//        System.out.println(goods);

        for (GoodsT goodsT : temp.getGoods_detail()){
            Goods goods1 = Convert.goodstTogoods(goodsT);
            goodsMapper.insertGoods(goods1);
        }
//        goodsMapper.insertGoods(goods);
        System.out.println("成功");
    }


    @Test
    public void alterData(){
        for(int i = 5; i < 80; i++){
            Goods goods = goodsMapper.getGoodsById(i);
            if (goods.getSold() != null){
                goods.setSold((int)(Math.random()*100));
                goodsMapper.updateGoods(goods);
            }
        }

//        Goods goods = goodsMapper.getGoodsById(5);
//        goods.setSold((int)(Math.random()*100));
//        goodsMapper.updateGoods(goods);
//        System.out.println("wancheng.........");
    }

}
