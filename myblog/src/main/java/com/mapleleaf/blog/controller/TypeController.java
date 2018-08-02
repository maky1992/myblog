package com.mapleleaf.blog.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mapleleaf.blog.entity.Types;
import com.mapleleaf.blog.service.Interface.ITypeService;
/**
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年8月15日
 * @Description:博客类型控制器
 */
@Controller
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private ITypeService typeService;
	
	/**
	 * 转向分类列表页面
	 * @return
	 */
	@RequestMapping(value="/toTypeList",method=RequestMethod.GET)
	public String typeListGet(Model model){
		ArrayList<Types> typesList = null;
		typesList = typeService.selectTypesList();
		model.addAttribute("typesList", typesList);
		return "articles/articleTypeList";
	}
	/**
	 * 添加分类
	 * @return
	 */
	@RequestMapping(value="addType",method=RequestMethod.POST)
	public String addType(Types types,Model model){
		Integer flag = 0;
		flag = typeService.insert(types);
		if(flag != 0){
			model.addAttribute("msg", "添加成功！");
			//session.setAttribute("msg", "添加成功！");
			return "articles/articleTypeList";
		}else{
			model.addAttribute("msg", "添加失败！");
			//session.setAttribute("msg", "添加失败！");
			return "articles/articleTypeList";
		}
		
	}
	/**
	 * 删除分类
	 * @return
	 */
	@RequestMapping(value="deleteType",method=RequestMethod.GET)
	public String deleteType(@RequestParam int typeId,Model model){
		Integer flag = 0;
		flag = typeService.deleteById(typeId);
		if(flag != 0){
			model.addAttribute("msg", "删除成功！");
			return "articles/articleTypeList";
		}else{
			model.addAttribute("msg", "删除失败！");
			return "articles/articleTypeList";
		}
		
	}
	/**
	 * 查看分类
	 * @return
	 */
	@RequestMapping(value="openType",method=RequestMethod.GET)
	public String openType(Types types,Model model){
		// 调用service 
		Types type = typeService.openById(types.getTypeId());
		model.addAttribute("type",type);
		return "articles/articleTypeSearch";

	}	
	/**
	 * 修改页面跳转
	 * @return
	 */
	@RequestMapping(value="updateTypeGet",method=RequestMethod.GET)
	public String updateTypeGet(@RequestParam int typeId,Model model){
		model.addAttribute("typeId",typeId);
		return "articles/articleTypeUpdate";
	}
	/**
	 * 修改页面
	 * @return
	 */
	@RequestMapping(value="updateType",method=RequestMethod.GET)
	public String updateType(Types types,Model model){
		
		Integer flag = 0;
		flag = typeService.updateByPrimaryKey(types);
		if(flag != 0){
			model.addAttribute("msg", "更新成功！");
			return "articles/articleTypeUpdate";
		}else{
			model.addAttribute("msg", "更新失败！");
			return "articles/articleTypeUpdate";
		}
	}	
}
