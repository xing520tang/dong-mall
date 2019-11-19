package com.tinyspot.dongmall.entity;

/**
 * @Author tinyspot
 * @Time 2019/11/18-9:51
 * 查询时用的中间类型
 */
public class CartT {
    private String userId;
    private Integer goodsId;
    private String param;
    private Integer number;
    private String detail;
    private double nowPrice;
    private double oldPrice;
    private byte seckill;
    //图片地址
    private String picture;

    public CartT(){}

    public CartT(String userId, Integer goodsId, String param, Integer number, String detail, double nowPrice, double oldPrice, byte seckill, String picture) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.param = param;
        this.number = number;
        this.detail = detail;
        this.nowPrice = nowPrice;
        this.oldPrice = oldPrice;
        this.seckill = seckill;
        this.picture = picture;
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

    public String getSrc() {
        return picture;
    }

    public void setSrc(String src) {
        this.picture = src;
    }

    @Override
    public String toString() {
        return "CartT{" +
                "userId='" + userId + '\'' +
                ", goodsId=" + goodsId +
                ", param='" + param + '\'' +
                ", number=" + number +
                ", detail='" + detail + '\'' +
                ", nowPrice=" + nowPrice +
                ", oldPrice=" + oldPrice +
                ", seckill=" + seckill +
                ", src='" + picture + '\'' +
                '}';
    }
}
