package com.mapleleaf.blog.dao;

import com.mapleleaf.blog.entity.SoftTools;

public interface SoftToolsMapper {
    int deleteByPrimaryKey(Integer toolId);

    int insert(SoftTools record);

    int insertSelective(SoftTools record);

    SoftTools selectByPrimaryKey(Integer toolId);

    int updateByPrimaryKeySelective(SoftTools record);

    int updateByPrimaryKey(SoftTools record);
}