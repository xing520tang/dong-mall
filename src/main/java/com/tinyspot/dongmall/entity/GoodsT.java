package com.tinyspot.dongmall.entity;

import java.util.List;

/**
 * @Author tinyspot
 * @Time 2019/11/17-18:02
 * 用于转换的类
 */
public class GoodsT {
    private Integer id;
    private String shop_name;
    private Integer classify_id;
    private String classify_name;
    private double nowPrice;
    private double oldPrice;
    private Integer sold;
    private String description;
    //参数规格
    private List<String> shop_spec;
    private byte seckill;
    //图片地址
    private List<String> src;

    public GoodsT() { }

    public GoodsT(Integer id, String shop_name, Integer classify_id, String classify_name, double nowPrice, double oldPrice, Integer sold, String description, List<String> shop_spec, byte seckill, List<String> src) {
        this.id = id;
        this.shop_name = shop_name;
        this.classify_id = classify_id;
        this.classify_name = classify_name;
        this.nowPrice = nowPrice;
        this.oldPrice = oldPrice;
        this.sold = sold;
        this.description = description;
        this.shop_spec = shop_spec;
        this.seckill = seckill;
        this.src = src;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public Integer getClassify_id() {
        return classify_id;
    }

    public void setClassify_id(Integer classify_id) {
        this.classify_id = classify_id;
    }

    public String getClassify_name() {
        return classify_name;
    }

    public void setClassify_name(String classify_name) {
        this.classify_name = classify_name;
    }

    public double getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(double nowPrice) {
        this.nowPrice = nowPrice;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getShop_spec() {
        return shop_spec;
    }

    public void setShop_spec(List<String> shop_spec) {
        this.shop_spec = shop_spec;
    }

    public byte getSeckill() {
        return seckill;
    }

    public void setSeckill(byte seckill) {
        this.seckill = seckill;
    }

    public List<String> getSrc() {
        return src;
    }

    public void setSrc(List<String> src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "GoodsT{" +
                "id=" + id +
                ", shop_name='" + shop_name + '\'' +
                ", classify_id=" + classify_id +
                ", classify_name='" + classify_name + '\'' +
                ", nowPrice=" + nowPrice +
                ", oldPrice=" + oldPrice +
                ", sold=" + sold +
                ", description='" + description + '\'' +
                ", shop_spec=" + shop_spec +
                ", seckill=" + seckill +
                ", src=" + src +
                '}';
    }
}
