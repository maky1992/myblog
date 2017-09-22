package com.mapleleaf.blog.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mapleleaf.blog.entity.Articles;
import com.mapleleaf.blog.entity.Diary;
import com.mapleleaf.blog.service.Interface.IArticleService;
import com.mapleleaf.blog.service.Interface.IDiaryService;

@Controller
@RequestMapping("/diary")
public class diaryController {
	@Autowired 
	private IDiaryService diaryService;
	/**
	 * 转向日记列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toDiaryList", method = RequestMethod.GET)
	public String toDiaryList(Model model) {
		ArrayList<Diary> typesList = null;
		typesList = diaryService.selectDiaryList();
		model.addAttribute("typesList", typesList);
		return "diary/diaryList";
	}
	/**
	 * 转向日记增加页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toDiaryAdd", method = RequestMethod.GET)
	public String toDiaryAdd() {
		return "diary/diaryAdd";
	}
}
