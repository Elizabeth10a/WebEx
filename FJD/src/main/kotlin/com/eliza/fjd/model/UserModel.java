package com.eliza.fjd.model;

import java.nio.file.LinkOption;

public class UserModel {
    private int id;
    private String name;
    private long tel;
    private String pwd;
    private String head_img;
    private String balance;
    private String addr;

    public UserModel() {
    }

    public UserModel(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public UserModel(int id, String name, long tel, String pwd) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.pwd = pwd;
    }

    public UserModel(int id, String name, long tel, String pwd, String head_img, String balance, String addr) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.pwd = pwd;
        this.head_img = head_img;
        this.balance = balance;
        this.addr = addr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
