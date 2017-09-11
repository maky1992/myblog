package com.mapleleaf.blog.dao;

import org.springframework.stereotype.Repository;

import com.mapleleaf.blog.entity.Admin;
@Repository
public interface AdminMapper {
    int insert(Admin record);

    int insertSelective(Admin record);
    
    Admin selectByName(String name);
    
    int updateByName(Admin record);
}