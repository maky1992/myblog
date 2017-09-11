package com.mapleleaf.blog.service.Interface;

import java.util.ArrayList;

import com.mapleleaf.blog.entity.Articles;

public interface IArticleService {
	/**
	 * 查询所有博文
	 * @return
	 */
	ArrayList<Articles> selectArticlesList();
	/**
	 * 添加博文
	 * @return
	 */
	Integer insert(Articles article);
	/**
	 * 通过博文ID删除
	 * @return
	 */
	Integer delete(Integer artId);

}
