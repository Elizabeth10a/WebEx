package com.eliza.wfx.model;

public class UserModel {

    private long id;
    private String name;
    private String title;
    private String signature;
    private String signatureTxt;
    private String tel;
    private String pwd;


    public UserModel() {
        // TODO Auto-generated constructor stub
    }

    public UserModel(String name, String pwd) {
        super();
        this.name = name;
        this.pwd = pwd;
    }

    public UserModel(long id, String name, String title, String signature, String signatureTxt, String tel, String pwd) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.signature = signature;
        this.signatureTxt = signatureTxt;
        this.tel = tel;
        this.pwd = pwd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignatureTxt() {
        return signatureTxt;
    }

    public void setSignatureTxt(String signatureTxt) {
        this.signatureTxt = signatureTxt;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", signature='" + signature + '\'' +
                ", signatureTxt='" + signatureTxt + '\'' +
                ", tel='" + tel + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
