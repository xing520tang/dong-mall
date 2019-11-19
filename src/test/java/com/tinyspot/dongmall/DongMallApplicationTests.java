package com.tinyspot.dongmall;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.tinyspot.dongmall.entity.*;
import com.tinyspot.dongmall.mapper.GoodsMapper;
import com.tinyspot.dongmall.service.GoodsService;
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

    @Autowired
    GoodsService goodsService;

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

    @Test
    public void testBody(){
        String str = "Body: {\"session_key\":\"zap0knbr5dwbui4hbd+zAg==\",\"openid\":\"kdsjafkljdoifwjeofijlkqwe\"}";
        String substring = str.substring(str.indexOf("{"));
        System.out.println("substring: " + substring);
        Body body = JSONUtil.toBean(substring, Body.class);
        System.out.println(body);
    }

    @Test
    public void testFenYe(){
        PageHelper.startPage(0, 10);
        //pagehelper后面紧跟的就是一个分页查询
        List<Goods> list = goodsService.getAllSeckillGoods();
        System.out.println("*************************");
        System.out.println("list的size： " + list.size());
        System.out.println(list);
        System.out.println("*************************");
        List<GoodsR> result = Convert.convertGoods(list);
        System.out.println("*************************");
        System.out.println("result的size： " + result.size());
        System.out.println(result);
        System.out.println("*************************");
    }

}
