package com.mapleleaf.blog.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mapleleaf.blog.entity.Admin;
import com.mapleleaf.blog.service.Interface.IAdminService;
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	/**
	 * 转向登录页面
	 * @return
	 */
	@RequestMapping(value="/toLogin",method=RequestMethod.GET)
	public String loginGet(){
		return "admin/login";
	}
	/**
	 * 管理员登录
	 * @param admin
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Admin admin,HttpSession session,Model model){
		boolean flag = false;
		flag = adminService.selectAdminByName(admin);
		if(flag){
			session.setAttribute("admin", admin);
			return "admin/index";
		}else{
			model.addAttribute("error", "账号或者密码错误！");
			return "admin/login";
		}
	}
	/**
	 * 转向修改密码页面
	 * @return
	 */
	@RequestMapping(value="/toModifyPassword",method=RequestMethod.GET)
	public String modifyPasswordGet(){
		return "admin/modifyPassword";
	}
	/**
	 * 修改密码页面
	 * @return
	 */
	@RequestMapping(value="/modifyPassword",method=RequestMethod.POST)
	public String modifyPassword(Admin admin,HttpSession session,Model model){
		// Session取值
		Admin admins = (Admin) session.getAttribute("admin");
		String username = admins.getAdminName();
		admin.setAdminName(username);
		int flag = 0;
		flag = adminService.updateByName(admin);
		if(flag != 0){
			model.addAttribute("msg", "密码修改成功！请重新登陆！");
			return "admin/modifyPassword";
		}else{
			model.addAttribute("msg", "密码修改失败！");
			return "admin/modifyPassword";
		}
	}
}
