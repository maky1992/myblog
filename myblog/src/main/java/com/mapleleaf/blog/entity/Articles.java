package com.mapleleaf.blog.entity;
/**
 * 
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年7月13日
 * @Description:博文
 */
public class Articles {
	/*
	 * 博文ID，自增长
	 */
    private Integer artId;
    /*
     * 博文题目，最大长度50
     */
    private String artTitle;
    /*
     * 博文关键字，最大长度50
     */
    private String artKeyword;
    /*
     * 博文发布日期，最大长度20
     */
    private String artPublishdate;
    /*
     * 博文封面图片，保存地址。最大长度50
     */
    private String artPicture;
    /*
     * 博文是否推荐，0表示不推荐，1表示推荐
     */
    private String artIsrecommend;
    /*
     * 博文浏览量
     */
    private Integer artBrowser;
    /*
     * 博文类型ID
     */
    private Integer typeId;
    /*
     * 博文评论ID
     */
    private Integer commId;
    /*
     * 博文内容，数据库存储类型：mediumblob
     */
    private byte[] artContent;

    
    //getter()和setter()方法
    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle == null ? null : artTitle.trim();
    }

    public String getArtKeyword() {
        return artKeyword;
    }

    public void setArtKeyword(String artKeyword) {
        this.artKeyword = artKeyword == null ? null : artKeyword.trim();
    }

    public String getArtPublishdate() {
        return artPublishdate;
    }

    public void setArtPublishdate(String artPublishdate) {
        this.artPublishdate = artPublishdate == null ? null : artPublishdate.trim();
    }

    public String getArtPicture() {
        return artPicture;
    }

    public void setArtPicture(String artPicture) {
        this.artPicture = artPicture == null ? null : artPicture.trim();
    }

    public String getArtIsrecommend() {
        return artIsrecommend;
    }

    public void setArtIsrecommend(String artIsrecommend) {
        this.artIsrecommend = artIsrecommend == null ? null : artIsrecommend.trim();
    }

    public Integer getArtBrowser() {
        return artBrowser;
    }

    public void setArtBrowser(Integer artBrowser) {
        this.artBrowser = artBrowser;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public byte[] getArtContent() {
        return artContent;
    }

    public void setArtContent(byte[] artContent) {
        this.artContent = artContent;
    }
    
}