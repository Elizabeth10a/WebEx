package com.eliza.fjd.model;

public class ShopCartModel {
    private int u_id;
    private int c_id;

    public ShopCartModel() {
    }

    public ShopCartModel(int u_id, int c_id) {
        this.u_id = u_id;
        this.c_id = c_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
}
