package com.mapleleaf.blog.dao;

import java.util.ArrayList;

import com.mapleleaf.blog.entity.Types;

public interface TypesMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Types record);

    int insertSelective(Types record);

    Types openById(Integer typeId);
    
    ArrayList<Types> selectAllTypes();

    int updateByPrimaryKeySelective(Types record);

    int updateByPrimaryKey(Types record);

	int deleteById(Integer typeId);
}