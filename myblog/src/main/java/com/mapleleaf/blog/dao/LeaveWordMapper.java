package com.mapleleaf.blog.dao;

import com.mapleleaf.blog.entity.LeaveWord;

public interface LeaveWordMapper {
    int deleteByPrimaryKey(Integer lwId);

    int insert(LeaveWord record);

    int insertSelective(LeaveWord record);

    LeaveWord selectByPrimaryKey(Integer lwId);

    int updateByPrimaryKeySelective(LeaveWord record);

    int updateByPrimaryKey(LeaveWord record);
}