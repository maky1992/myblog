package com.mapleleaf.blog.entity;
/**
 * 
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年7月13日
 * @Description:常用工具，主要采用百度云链接方式
 */
public class SoftTools {
	/*
	 * 工具ID，自增长
	 */
    private Integer toolId;
    /*
	 * 工具名，最大长度50
	 */
    private String toolName;
    /*
	 * 工具链接，最大长度50
	 */
    private String toolLink;
    /*
	 * 工具链接密码，最大长度30
	 */
    private String toolPassword;

    
    //setter()和getter()方法
    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName == null ? null : toolName.trim();
    }

    public String getToolLink() {
        return toolLink;
    }

    public void setToolLink(String toolLink) {
        this.toolLink = toolLink == null ? null : toolLink.trim();
    }

    public String getToolPassword() {
        return toolPassword;
    }

    public void setToolPassword(String toolPassword) {
        this.toolPassword = toolPassword == null ? null : toolPassword.trim();
    }
}