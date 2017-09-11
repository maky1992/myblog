package com.mapleleaf.blog.dao;

import java.util.ArrayList;

import com.mapleleaf.blog.entity.Articles;

public interface ArticlesMapper {
    int deleteByPrimaryKey(Integer artId);

    int insert(Articles record);

    int insertSelective(Articles record);

    Articles selectByPrimaryKey(Integer artId);

    int updateByPrimaryKeySelective(Articles record);

    int updateByPrimaryKeyWithBLOBs(Articles record);

    int updateByPrimaryKey(Articles record);
    /**
	 * 查询所有博文
	 * @return
	 */
	ArrayList<Articles> selectArticlesList();
}