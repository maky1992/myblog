package com.mapleleaf.blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mapleleaf.blog.entity.Articles;
import com.mapleleaf.blog.entity.Types;
import com.mapleleaf.blog.service.Interface.IArticleService;
import com.mapleleaf.blog.service.Interface.ITypeService;

@Controller
@RequestMapping("/article")
public class articlesController {
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ITypeService typeService;

	/**
	 * 转向分类列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toArticleList", method = RequestMethod.GET)
	public String articleListGet(Model model) {
		ArrayList<Articles> typesList = null;
		typesList = articleService.selectArticlesList();
		model.addAttribute("typesList", typesList);
		return "articles/articlePublishList";
	}

	/**
	 * 转向博文添加页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toAddArticle", method = RequestMethod.POST)
	public String toAddArticleGet(Model model) {
		ArrayList<Types> typesList = null;
		typesList = typeService.selectTypesList();
		model.addAttribute("typesList", typesList);
		return "articles/articleAdd";
	}

	/**
	 * 博文添加
	 * 
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String addArticle(Model model, Articles article,
			@RequestParam(value = "file", required = false) MultipartFile artPicture, HttpServletRequest request)
			throws Exception {
		String pathRoot = "";
		pathRoot = request.getSession().getServletContext().getRealPath("");
		System.out.println(pathRoot);
		String path = "";
		if (!artPicture.isEmpty()) {
			// 生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType = artPicture.getContentType();
			// 获得文件后缀名称
			String imageName = contentType.substring(contentType.indexOf("/") + 1);
			path = "picture/" + uuid + "." + imageName;
			artPicture.transferTo(new File(pathRoot + path));
		}
		article.setArtPicture(path);
		System.out.println(article.getArtContent().toString());
		Integer flag = 0;
		flag = articleService.insert(article);
		if (flag != 0) {
			model.addAttribute("msg", "添加成功！");
			return "redirect:/article/toArticleList";
		} else {
			model.addAttribute("msg", "添加失败！");
			return "articles/articleAdd";
		}
	}

	/**
	 * 博文删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/deleteArticle", method = RequestMethod.GET)
	public String deleteArticle(Model model, Articles article) {
		Integer flag = 0;
		flag = articleService.delete(article.getArtId());
		if (flag != 0) {
			model.addAttribute("msg", "删除成功！");
			return "articles/articlePublishList";
		} else {
			model.addAttribute("msg", "删除失败！");
			return "articles/articlePublishList";
		}
	}

	/**
	 * 查看详细文章
	 * 
	 * @param model
	 * @param article
	 * @return
	 */
	@RequestMapping(value = "/searchArticle", method = RequestMethod.GET)
	public String searchArticle(@RequestParam Integer artId, @RequestParam String flag, Model model) {
		Articles article;
		article = articleService.selectByArtId(artId);
		ArrayList<Types> typesList = null;
		typesList = typeService.selectTypesList();
		String str = new String(article.getArtContent());
		model.addAttribute("artContent", str);
		model.addAttribute("typesList", typesList);
		model.addAttribute("article", article);
		model.addAttribute("flag", flag);
		return "articles/articleUpdate";
	}

	/**
	 * 更新操作
	 * 
	 * @return
	 */
	@RequestMapping(value = "updateArticles", method = RequestMethod.POST)
	public String updateArticles(Model model, Articles article,@RequestParam(value = "file", required = false) MultipartFile artPicture, HttpServletRequest request)
			throws Exception {
		String pathRoot = "";
		pathRoot = request.getSession().getServletContext().getRealPath("");
		System.out.println(pathRoot);
		String path = "";
		if (!artPicture.isEmpty()) {
			// 生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType = artPicture.getContentType();
			// 获得文件后缀名称
			String imageName = contentType.substring(contentType.indexOf("/") + 1);
			path = "picture/" + uuid + "." + imageName;
			artPicture.transferTo(new File(pathRoot + path));
			article.setArtPicture(path);
		}else{
			Articles article1;
			article1 = articleService.selectByArtId(article.getArtId());
			article.setArtPicture(article1.getArtPicture());
		}
		
		System.out.println(article.getArtContent().toString());
		Integer flag = 0;
		flag = articleService.updateByPrimaryKey(article);
		if (flag != 0) {
			model.addAttribute("msg", "更新成功！");
			return "articles/articlePublishList";
		} else {
			model.addAttribute("msg", "更新失败！");
			return "articles/articlePublishList";
		}
	}
}
