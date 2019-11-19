package com.tinyspot.dongmall.entity;

import java.util.List;

/**
 * @Author tinyspot
 * @Time 2019/11/18-9:30
 */
public class CartR {
    private String userId;
    private Integer goodsId;
    private String param;
    private Integer number;
    private String detail;
    private double nowPrice;
    private double oldPrice;
    private byte seckill;
    //图片地址
    private List<String> src;

    public CartR(){}

    public CartR(String userId, Integer goodsId, String param, Integer number, String detail, double nowPrice, double oldPrice, byte seckill, List<String> src) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.param = param;
        this.number = number;
        this.detail = detail;
        this.nowPrice = nowPrice;
        this.oldPrice = oldPrice;
        this.seckill = seckill;
        this.src = src;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
        return "CartR{" +
                "userId='" + userId + '\'' +
                ", goodsId=" + goodsId +
                ", param='" + param + '\'' +
                ", number=" + number +
                ", detail='" + detail + '\'' +
                ", nowPrice=" + nowPrice +
                ", oldPrice=" + oldPrice +
                ", seckill=" + seckill +
                ", src=" + src +
                '}';
    }
}
