package com.mapleleaf.blog.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapleleaf.blog.dao.TypesMapper;
import com.mapleleaf.blog.entity.Types;
import com.mapleleaf.blog.service.Interface.ITypeService;
/**
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年8月15日
 * @Description:
 */
@Service
public class TypeService implements ITypeService {
	
	@Autowired
	private TypesMapper typesMapper;

	@Override
	public Integer insert(Types types) {
		Integer flag = 0;
		flag = typesMapper.insertSelective(types);
		return flag;
	}

	@Override
	public ArrayList<Types> selectTypesList() {
		ArrayList<Types> typesList = null;
		typesList = typesMapper.selectAllTypes();
		return typesList;
	}

	@Override
	public Integer deleteById(Integer typeId) {
		Integer flag = 0;
		flag = typesMapper.deleteById(typeId);
		return flag;
	}

	@Override
	public Types openById(Integer typeId) {
		Types type = typesMapper.openById(typeId);
		return type;
	}

	@Override
	public Integer updateByPrimaryKey(Types types) {
		Integer flag = 0;
		flag = typesMapper.updateByPrimaryKey(types);
		return flag;
	}



}
