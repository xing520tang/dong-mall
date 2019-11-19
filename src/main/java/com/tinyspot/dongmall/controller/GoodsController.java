package com.tinyspot.dongmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tinyspot.dongmall.entity.Goods;
import com.tinyspot.dongmall.entity.GoodsAndType;
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
    public List<GoodsR> getAllSecKill(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        logger.info("获取所有秒杀商品...");
        //开启分页，从pn也开始，一页10个数据
        PageHelper.startPage(pn, 10);
        //pagehelper后面紧跟的就是一个分页查询
        List<Goods> list = goodsService.getAllSeckillGoods();
        List<GoodsR> result = Convert.convertGoods(list);

        return result;
    }


    /*
    返回所有商品，按照分类返回
     */
    @GetMapping("/all")
    @ResponseBody
    public List<GoodsAndType> getClassifyGoods(){
        logger.info("获取所有商品，按照分类返回...");
        List<Goods> list = goodsService.getAllGoods();
        Map<Integer, List<GoodsR>> map = Convert.sort(list);
        List<GoodsAndType> result = Convert.mapToList(map);
        return result;
    }

    /*
    返回某个商品的信息，根据id
     */
    @GetMapping("/detail")
    @ResponseBody
    public GoodsR getGoodsDetail(@RequestParam("id") Integer id){
        logger.info("返回商品Id为" + id + "的详细信息...");
        Goods good = goodsService.getGoodsDetail(id);
        GoodsR result = Convert.goodsToGoodsR(good);
        return result;
    }
}
