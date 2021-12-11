package com.eliza.fjd.model;

import java.security.SecureRandom;

public class CommodityModel {
    private int id;
    private String title;
    private int price;
    private String img1;
    private String img2;
    private String img3;

    public CommodityModel() {
    }

    public CommodityModel(int id, String title, int price, String img1, String img2, String img3) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
    }
}
