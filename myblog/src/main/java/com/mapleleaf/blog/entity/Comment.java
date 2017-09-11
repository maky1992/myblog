package com.mapleleaf.blog.entity;
/**
 * 
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年7月13日
 * @Description:博文评论
 */
public class Comment {
	/*
	 * 评论ID，自增长
	 */
    private Integer commId;
    /*
	 * 评论用户名，最大长度30
	 */
    private String commUname;
    /*
	 * 评论用户邮箱，可以为空，最大长度为20
	 */
    private String commMailbox;
    /*
	 * 评论内容，最大长度为450。
	 */
    private String commContent;

    
    //setter()和getter()方法
    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public String getCommUname() {
        return commUname;
    }

    public void setCommUname(String commUname) {
        this.commUname = commUname == null ? null : commUname.trim();
    }

    public String getCommMailbox() {
        return commMailbox;
    }

    public void setCommMailbox(String commMailbox) {
        this.commMailbox = commMailbox == null ? null : commMailbox.trim();
    }

    public String getCommContent() {
        return commContent;
    }

    public void setCommContent(String commContent) {
        this.commContent = commContent == null ? null : commContent.trim();
    }
}