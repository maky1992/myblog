package com.mapleleaf.blog.dao;

import com.mapleleaf.blog.entity.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}