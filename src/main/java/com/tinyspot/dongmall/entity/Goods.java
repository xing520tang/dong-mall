package com.tinyspot.dongmall.entity;

/**
 * @Author tinyspot
 * @Time 2019/11/17-14:48
 */
public class Goods {
    private Integer id;
    private String name;
    private Integer typeId;
    private String typeName;
    private double nowPrice;
    private double oldPrice;
    private Integer sold;
    private String detail;
    private String param;
    private byte seckill;
    private String picture;

    public Goods(){}

    public Goods(Integer id, String name, Integer typeId, String typeName, double nowPrice, double oldPrice, Integer sold, String detail, String param, byte seckill, String picture) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.typeName = typeName;
        this.nowPrice = nowPrice;
        this.oldPrice = oldPrice;
        this.sold = sold;
        this.detail = detail;
        this.param = param;
        this.seckill = seckill;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public byte getSeckill() {
        return seckill;
    }

    public void setSeckill(byte seckill) {
        this.seckill = seckill;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", nowPrice=" + nowPrice +
                ", oldPrice=" + oldPrice +
                ", sold=" + sold +
                ", detail='" + detail + '\'' +
                ", param='" + param + '\'' +
                ", seckill=" + seckill +
                ", picture='" + picture + '\'' +
                '}';
    }
}
