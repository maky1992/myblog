package com.mapleleaf.blog.service.Interface;

import org.springframework.stereotype.Service;

import com.mapleleaf.blog.entity.Admin;
/**
 * 
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年7月13日
 * @Description:管理员service接口
 */

public interface IAdminService {
	/**
	 * 管理员查询
	 * @param name
	 * @return
	 */
	Boolean selectAdminByName(Admin admin);

	int updateByName(Admin admin);
}
