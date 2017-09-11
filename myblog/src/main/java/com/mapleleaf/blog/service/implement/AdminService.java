package com.mapleleaf.blog.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mapleleaf.blog.dao.AdminMapper;
import com.mapleleaf.blog.entity.Admin;
import com.mapleleaf.blog.service.Interface.IAdminService;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public Boolean selectAdminByName(Admin admins) {
		boolean flag = false;
		Admin admin = adminMapper.selectByName(admins.getAdminName());
		if(admin != null && (admin.getAdminPassword().equals(admins.getAdminPassword()))){
		//if(admin != null ){
			flag = true;
		}
		return flag;
	}

	@Override
	public int updateByName(Admin admin) {
		int flag = adminMapper.updateByName(admin);
		return flag;
	}



}
