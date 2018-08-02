package com.mapleleaf.blog.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mapleleaf.blog.entity.SoftTools;
import com.mapleleaf.blog.service.Interface.IToolsService;

/**
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年10月10日
 * @Description:工具控制器
 */
@Controller
@RequestMapping("/tools")
public class ToolsController {
	
	@Autowired
	private IToolsService toolsService;

	/**
	 * 工具列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toToolsList",method = RequestMethod.GET)
	public String toToolsList(ModelMap model){
		ArrayList<SoftTools> toolList;
		toolList = toolsService.selectToolList();
		model.addAttribute("toolList", toolList);
		return "tools/toolsList";
	}
	
	/**
	 * 跳转工具添加页面
	 * @return
	 */
	@RequestMapping(value="/toAddTools",method = RequestMethod.GET)
	public String toAddTools(){
		return "tools/addTool";
	}
	
	/**
	 * 添加工具
	 * @param tool
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addTool",method = RequestMethod.POST)
	public String addTool(SoftTools tool,ModelMap model){
		Integer flag = 0;
		flag = toolsService.addTool(tool);
		if(flag > 0){
			model.addAttribute("msg", "添加成功！");
			return "redirect:/tools/toToolsList";
		}else{
			model.addAttribute("msg", "添加失败！");
			return "tools/addTool";
		}
	}
	/**
	 * 跳转详情页面
	 * @param toolId
	 * @param flag
	 * @param model
	 * @return
	 */
	@RequestMapping(value="searchTool",method = RequestMethod.GET)
	public String searchTool(@RequestParam Integer toolId,@RequestParam String flag,ModelMap model){
			SoftTools softTool;
			softTool = toolsService.selectByPrimaryKey(toolId);
			model.addAttribute("softTool",softTool);
			model.addAttribute("flag",flag);
		return "tools/updateTool";
	}
	/**
	 * 更新工具
	 * @param softTool
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updateTool",method=RequestMethod.POST)
	public String updateTool(SoftTools softTool,ModelMap model){
		Integer flag = 0;
		flag = toolsService.updateTool(softTool);
		if(flag > 0){
			model.addAttribute("msg", "更新成功！");
			return "redirect:/tools/toToolsList";
		}else{
			model.addAttribute("msg", "更新失败！");
			return "tools/updateTool";
		}
	}
	
	@RequestMapping(value="/deleteTool",method=RequestMethod.GET)
	public String deleteTool(@RequestParam Integer toolId){
		toolsService.deleteTool(toolId);
		return "redirect:/tools/toToolsList";
	}
}
