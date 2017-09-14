package com.mapleleaf.blog.service.implement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mapleleaf.blog.dao.ArticlesMapper;
import com.mapleleaf.blog.entity.Articles;
import com.mapleleaf.blog.service.Interface.IArticleService;
@Service
public class ArticleService implements IArticleService{
	@Autowired
	private ArticlesMapper articlesMapper;
	/**
	 * 查询所有博文
	 * @return
	 */

	@Override
	public ArrayList<Articles> selectArticlesList() {
		ArrayList<Articles> typesList = null;
		typesList = articlesMapper.selectArticlesList();
		return typesList;
	}
	/**
	 * 添加博文
	 */
	@Override
	public Integer insert(Articles article) {
		// 获取当前日期
		Date dt=new Date();
		// 格式化日期
		SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
		article.setArtPublishdate(matter1.format(dt));
		Integer flag = 0;
		// 调用DAO方法
		flag = articlesMapper.insert(article);
		return flag;
	}
	/**
	 * 删除博文
	 */
	@Override
	public Integer delete(Integer artId) {
		Integer flag = 0;
		// 调用DAO方法
		flag = articlesMapper.deleteByPrimaryKey(artId);
		return flag;
	}
	
	/**
	 * 根据ID查询博文
	 */
	@Override
	public Articles selectByArtId(Integer artId) {
		Articles article = null;
		try {
			article = articlesMapper.selectByPrimaryKey(artId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return article;
	}
}
