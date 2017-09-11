package com.mapleleaf.blog.entity;
/**
 * 
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年7月13日
 * @Description:管理员
 */
public class Admin {
	/*
	 * 管理员姓名
	 */
    private String adminName;
    /*
     * 管理员密码
     */
    private String adminPassword;
    
    //getter()和setter()方法
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }
}