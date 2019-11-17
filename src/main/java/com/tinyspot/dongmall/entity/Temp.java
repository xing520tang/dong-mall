package com.tinyspot.dongmall.entity;

import java.util.List;

/**
 * @Author tinyspot
 * @Time 2019/11/17-18:07
 */
public class Temp {
    private List<GoodsT> goods_detail;

    public Temp(){}

    public Temp(List<GoodsT> goods_detail) {
        this.goods_detail = goods_detail;
    }

    public List<GoodsT> getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(List<GoodsT> goods_detail) {
        this.goods_detail = goods_detail;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "goods_detail=" + goods_detail +
                '}';
    }
}
