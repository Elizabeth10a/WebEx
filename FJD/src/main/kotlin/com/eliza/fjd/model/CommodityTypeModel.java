package com.eliza.fjd.model;

public class CommodityTypeModel {
    private int id;
    private String type;

    public CommodityTypeModel() {
    }

    public CommodityTypeModel(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
