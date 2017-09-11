package com.mapleleaf.blog.entity;
/**
 * 
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年7月13日
 * @Description:日记
 */
public class Diary {
	/*
	 * 日记ID，自增长
	 */
    private Integer diaryId;
    /*
	 * 日记标题，最大长度50
	 */
    private String diaryTitle;
    /*
	 * 日记图片，图片地址
	 */
    private String diaryPicture;
    /*
	 * 日记背景音乐，存储文件地址，mp3、mp4格式
	 */
    private String diaryMusic;
    /*
	 * 日记浏览量
	 */
    private Integer diaryBrowser;
    /*
	 * 日记评论ID
	 */
    private Integer commId;
    /*
	 * 日记内容 数据库存储类型：mediumblob
	 */
    private byte[] diaryContent;

    
    //getter()和setter()方法
    public Integer getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Integer diaryId) {
        this.diaryId = diaryId;
    }

    public String getDiaryTitle() {
        return diaryTitle;
    }

    public void setDiaryTitle(String diaryTitle) {
        this.diaryTitle = diaryTitle == null ? null : diaryTitle.trim();
    }

    public String getDiaryPicture() {
        return diaryPicture;
    }

    public void setDiaryPicture(String diaryPicture) {
        this.diaryPicture = diaryPicture == null ? null : diaryPicture.trim();
    }

    public String getDiaryMusic() {
        return diaryMusic;
    }

    public void setDiaryMusic(String diaryMusic) {
        this.diaryMusic = diaryMusic == null ? null : diaryMusic.trim();
    }

    public Integer getDiaryBrowser() {
        return diaryBrowser;
    }

    public void setDiaryBrowser(Integer diaryBrowser) {
        this.diaryBrowser = diaryBrowser;
    }

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public byte[] getDiaryContent() {
        return diaryContent;
    }

    public void setDiaryContent(byte[] diaryContent) {
        this.diaryContent = diaryContent;
    }
}