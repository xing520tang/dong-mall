package com.tinyspot.dongmall.controller;

import com.tinyspot.dongmall.entity.Goods;
import com.tinyspot.dongmall.entity.GoodsR;
import com.tinyspot.dongmall.service.GoodsService;
import com.tinyspot.dongmall.util.Convert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author tinyspot
 * @Time 2019/11/17-14:34
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    GoodsService goodsService;

    /*
    返回所有秒杀商品
     */
    @GetMapping("/seckill")
    @ResponseBody
    public List<GoodsR> getAllSecKill(){
        List<Goods> list = goodsService.getAllSeckillGoods();
        List<GoodsR> result = Convert.convertGoods(list);
        return result;
    }


    /*
    返回所有商品，按照分类返回
     */
    @GetMapping("/all")
    @ResponseBody
    public Map<Integer, List<GoodsR>> getClassifyGoods(){
        List<Goods> list = goodsService.getAllGoods();
        Map<Integer, List<GoodsR>> result = Convert.sort(list);
        return result;
    }

    /*
    返回某个商品的信息，根据id
     */
    @GetMapping("/detail")
    @ResponseBody
    public GoodsR getGoodsDetail(@RequestParam("id") Integer id){
        Goods good = goodsService.getGoodsDetail(id);
        GoodsR result = Convert.goodsToGoodsR(good);
        return result;
    }
}
