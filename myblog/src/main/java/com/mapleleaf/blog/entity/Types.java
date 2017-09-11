package com.mapleleaf.blog.entity;
/**
 * 
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年7月13日
 * @Description:文章类型
 */
public class Types {
	/*
	 * 类型ID，自增长
	 */
    private Integer typeId;
    /*
     * 类型名称，最大长度20
     */
    private String typeName;

    //setter()和getter()方法
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}