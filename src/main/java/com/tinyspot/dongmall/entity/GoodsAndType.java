package com.tinyspot.dongmall.entity;

import java.util.List;

/**
 * @Author tinyspot
 * @Time 2019/11/18-11:30
 */
public class GoodsAndType {
    private Integer typeId;
    private String typeName;
    private List<GoodsR> children;

    public GoodsAndType(){}

    public GoodsAndType(Integer typeId, String typeName, List<GoodsR> children) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.children = children;
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

    public List<GoodsR> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsR> children) {
        this.children = children;
    }
}
