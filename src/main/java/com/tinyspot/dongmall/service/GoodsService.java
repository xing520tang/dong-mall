package com.tinyspot.dongmall.service;

import com.tinyspot.dongmall.entity.Goods;
import com.tinyspot.dongmall.entity.GoodsR;
import com.tinyspot.dongmall.mapper.GoodsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tinyspot
 * @Time 2019/11/17-14:55
 */
@Service
public class GoodsService {

    private static final Logger logger = LoggerFactory.getLogger(GoodsService.class);

    @Autowired
    GoodsMapper goodsMapper;

    /*
    获取所有秒杀商品
     */
    public List<Goods> getAllSeckillGoods() {
        List<Goods> list = goodsMapper.selectAllSeckillGoods();
        return list;
    }

    /*
    获取所有商品
     */
    public List<Goods> getAllGoods() {
        List<Goods> list = goodsMapper.selectAllGoods();
        return list;
    }

    public Goods getGoodsDetail(Integer id) {
        Goods goods = goodsMapper.getGoodsById(id);
        return goods;
    }
}
