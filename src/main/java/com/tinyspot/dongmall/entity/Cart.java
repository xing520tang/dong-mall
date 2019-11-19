package com.tinyspot.dongmall.entity;

/**
 * @Author tinyspot
 * @Time 2019/11/18-9:25
 * 购物车实体类
 */
public class Cart {
    private Integer id;
    private String userId;
    private Integer goodsId;
    private String param;
    private Integer number;

    public Cart(){}

    public Cart(String userId, Integer goodsId, String param, Integer number) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.param = param;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", goodsId=" + goodsId +
                ", param='" + param + '\'' +
                ", number=" + number +
                '}';
    }
}
