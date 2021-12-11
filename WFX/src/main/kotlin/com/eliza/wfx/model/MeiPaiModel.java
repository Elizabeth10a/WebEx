package com.eliza.wfx.model;


public class MeiPaiModel {

    //basic information
    private long id;
    private String shortTitle="";
    private String content="";
    private String coverPic="";
    private String contentPic="";

    //收藏数
    private int nCollect=0;
    //点赞数
    private int nFavorite=0;

    private long ownerId;
    private UserModel owner;
    private boolean isTop = false;
    private short isDeleted = 0;
    private int nOrder = 0;
    public MeiPaiModel(String shortTitle, long ownerId) {
        this.shortTitle = shortTitle;
        this.ownerId = ownerId;
    }

    public MeiPaiModel(long id, long ownerId, String shortTitle) {
        this.id = id;
        this.shortTitle = shortTitle;
        this.ownerId = ownerId;
    }

    public MeiPaiModel(long id, long ownerId, int nCollect, int nFavorite, String shortTitle, String content, String coverPic, String contentPic) {
        this.id = id;
        this.ownerId = ownerId;
        this.nCollect = nCollect;
        this.nFavorite = nFavorite;
        this.shortTitle = shortTitle;
        this.content = content;
        this.coverPic = coverPic;
        this.contentPic = contentPic;

    } public MeiPaiModel(long id, long ownerId, int nCollect, int nFavorite, String shortTitle, String content, String coverPic, String contentPic,UserModel userModel) {
        this.id = id;
        this.ownerId = ownerId;
        this.nCollect = nCollect;
        this.nFavorite = nFavorite;
        this.shortTitle = shortTitle;
        this.content = content;
        this.coverPic = coverPic;
        this.contentPic = contentPic;
        this.owner = userModel;

    }

    public MeiPaiModel() {
        super();
        // TODO Auto-generated constructor stub
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public String getContentPic() {
        return contentPic;
    }

    public void setContentPic(String contetPic) {
        this.contentPic = contetPic;
    }

    public int getnCollect() {
        return nCollect;
    }

    public void setnCollect(int nCollect) {
        this.nCollect = nCollect;
    }

    public int getnFavorite() {
        return nFavorite;
    }

    public void setnFavorite(int nFavorite) {
        this.nFavorite = nFavorite;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean isTop) {
        this.isTop = isTop;
    }

    public short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(short isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getnOrder() {
        return nOrder;
    }

    public void setnOrder(int nOrder) {
        this.nOrder = nOrder;
    }


}
