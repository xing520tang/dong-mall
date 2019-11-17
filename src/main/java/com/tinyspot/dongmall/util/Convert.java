package com.tinyspot.dongmall.util;

import com.tinyspot.dongmall.entity.Goods;
import com.tinyspot.dongmall.entity.GoodsR;
import com.tinyspot.dongmall.entity.GoodsT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tinyspot
 * @Time 2019/11/17-15:06
 * 转换类
 */
public class Convert {

    /*
    将Goods转换为GoodsR
     */
    public static GoodsR goodsToGoodsR(Goods good){
        GoodsR r = new GoodsR(good.getId(),good.getName(),good.getTypeId(),good.getTypeName()
                ,good.getNowPrice(),good.getOldPrice(),good.getSold(),good.getDetail(),good.getSeckill());

        String s1[] = good.getParam().split(";");
        List<String> list1 = new ArrayList<>();
        for(String s : s1)
            list1.add(s);
        r.setParam(list1);

        String s2[] = good.getPicture().split(";");
        List<String> list2 = new ArrayList<>();
        for(String s : s2)
            list2.add(s);
        r.setSrc(list2);

        return r;
    }

    /*
    将GoodsT转换为Goods
     */
    public static Goods goodstTogoods(GoodsT goodsT){
        Goods goods = new Goods(null, goodsT.getShop_name(),goodsT.getClassify_id(),goodsT.getClassify_name(),goodsT.getNowPrice()
        ,goodsT.getOldPrice(),goodsT.getSold(),goodsT.getDescription(),null,goodsT.getSeckill(),null);

        StringBuilder sb = new StringBuilder();
        for(String s1 : goodsT.getShop_spec())
            sb.append(s1).append(";");
        goods.setParam(sb.toString());

        StringBuilder sb1 = new StringBuilder();
        for (String s1 : goodsT.getSrc())
            sb1.append(s1).append(";");
        goods.setPicture(sb1.toString());

        return goods;
    }

    /*
    将List里的Goods转换为GoodsR
    其实就是将Goods里的param和picture字段中的字符串用；分割开来
     */
    public static List<GoodsR> convertGoods(List<Goods> list) {
        List<GoodsR> result = new ArrayList<>();
        for(Goods good : list){
            GoodsR r = goodsToGoodsR(good);

            result.add(r);
        }
        return result;
    }

    public static Map<Integer, List<GoodsR>> sort(List<Goods> list) {
        Map<Integer, List<GoodsR>> result = new HashMap<>();
        //将所有Goods转换为goodsr
        List<GoodsR> goodsR = convertGoods(list);

        for(GoodsR good : goodsR){
            //若该种类id已经在map中, 将goodsr直接放到对应的list中
            if(result.containsKey(good.getTypeId())){
                List<GoodsR> t = result.get(good.getTypeId());
                t.add(good);
            }else{
                List<GoodsR> tt = new ArrayList<>();
                tt.add(good);
                result.put(good.getTypeId(), tt);
            }
        }

        return result;
    }
}
