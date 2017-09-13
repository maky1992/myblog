package com.mapleleaf.blog.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mapleleaf.blog.entity.Articles;
import com.mapleleaf.blog.entity.Types;
import com.mapleleaf.blog.service.Interface.IArticleService;
import com.mapleleaf.blog.service.Interface.ITypeService;

@Controller
@RequestMapping("/article")
public class articlesController {
	@Autowired
	private  IArticleService articleService;
	@Autowired
	private ITypeService typeService;
	
	/**
	 * 转向分类列表页面
	 * @return
	 */
	@RequestMapping(value="/toArticleList",method=RequestMethod.GET)
	public String articleListGet(Model model){
		ArrayList<Articles> typesList = null;
		typesList = articleService.selectArticlesList();
		model.addAttribute("typesList", typesList);
		return "articles/articlePublishList";
	}
	/**
	 * 转向博文添加页面
	 * @return
	 */
	@RequestMapping(value="/toAddArticle",method=RequestMethod.POST)
	public String toAddArticleGet(Model model){
		ArrayList<Types> typesList = null;
		typesList = typeService.selectTypesList();
		model.addAttribute("typesList", typesList);
		return "articles/articleAdd";
	}
	/**
	 * 博文添加
	 * @return
	 */
	@RequestMapping(value="/addArticle",method=RequestMethod.POST)
	public String addArticle(Model model,Articles article,HttpServletRequest request){
		// 获取封页相对路径
		String realpath=request.getRealPath(article.getArtPicture());
		article.setArtPicture(realpath);
		Integer flag = 0;
		flag = articleService.insert(article);
		if(flag != 0){
			model.addAttribute("msg", "添加成功！");
			return "redirect:/article/toArticleList";
		}else{
			model.addAttribute("msg", "添加失败！");
			return "articles/articleAdd";
		}
	}
	/**
	 * 博文删除
	 * @return
	 */
	@RequestMapping(value="/deleteArticle",method=RequestMethod.GET)
	public String deleteArticle(Model model,Articles article){
		Integer flag = 0;
		flag = articleService.delete(article.getArtId());
		if(flag != 0){
			model.addAttribute("msg", "删除成功！");
			return "articles/articlePublishList";
		}else{
			model.addAttribute("msg", "删除失败！");
			return "articles/articlePublishList";
		}
	}
}
