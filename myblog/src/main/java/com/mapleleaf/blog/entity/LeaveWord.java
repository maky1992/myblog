package com.mapleleaf.blog.entity;
/**
 * 
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年7月13日
 * @Description:留言
 */
public class LeaveWord {
	/*
	 * 留言ID
	 */
    private Integer lwId;
    /*
	 * 留言用户名，最大长度 30
	 */
    private String lwUname;
    /*
	 * 留言邮箱，最大长度 20
	 */
    private String lwMailbox;
    /*
	 * 留言内容，最大长度450
	 */
    private String lwContent;

    //getter()和setter()方法
    public Integer getLwId() {
        return lwId;
    }

    public void setLwId(Integer lwId) {
        this.lwId = lwId;
    }

    public String getLwUname() {
        return lwUname;
    }

    public void setLwUname(String lwUname) {
        this.lwUname = lwUname == null ? null : lwUname.trim();
    }

    public String getLwMailbox() {
        return lwMailbox;
    }

    public void setLwMailbox(String lwMailbox) {
        this.lwMailbox = lwMailbox == null ? null : lwMailbox.trim();
    }

    public String getLwContent() {
        return lwContent;
    }

    public void setLwContent(String lwContent) {
        this.lwContent = lwContent == null ? null : lwContent.trim();
    }
}