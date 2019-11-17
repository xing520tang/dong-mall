package com.tinyspot.dongmall.entity;

import java.util.List;

/**
 * @Author tinyspot
 * @Time 2019/11/17-14:59
 */
public class GoodsR {
    private Integer id;
    private String name;
    private Integer typeId;
    private String typeName;
    private double nowPrice;
    private double oldPrice;
    private Integer sold;
    private String detail;
    //参数规格
    private List<String> param;
    private byte seckill;
    //图片地址
    private List<String> src;

    public GoodsR(Integer id, String name, Integer typeId, String typeName, double nowPrice, double oldPrice, Integer sold, String detail, byte seckill) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.typeName = typeName;
        this.nowPrice = nowPrice;
        this.oldPrice = oldPrice;
        this.sold = sold;
        this.detail = detail;
        this.seckill = seckill;
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

    public byte getSeckill() {
        return seckill;
    }

    public void setSeckill(byte seckill) {
        this.seckill = seckill;
    }

    public List<String> getParam() {
        return param;
    }

    public void setParam(List<String> param) {
        this.param = param;
    }

    public List<String> getSrc() {
        return src;
    }

    public void setSrc(List<String> src) {
        this.src = src;
    }


    @Override
    public String toString() {
        return "GoodsR{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", nowPrice=" + nowPrice +
                ", oldPrice=" + oldPrice +
                ", sold=" + sold +
                ", detail='" + detail + '\'' +
                ", param=" + param +
                ", seckill=" + seckill +
                ", src=" + src +
                '}';
    }
}
