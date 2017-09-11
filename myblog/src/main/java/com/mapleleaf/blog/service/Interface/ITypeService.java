package com.mapleleaf.blog.service.Interface;

import java.util.ArrayList;

import com.mapleleaf.blog.entity.Types;

/**
 * @author: 韩晋峰
 * @Email :13080304993@163.com
 * @Date: 2017年8月15日
 * @Description:
 */
public interface ITypeService {
	/**
	 * 添加类型
	 * @param types
	 * @return
	 */
	Integer insert(Types types);
	
	/**
	 * 查询所有类型
	 * @return
	 */
	ArrayList<Types> selectTypesList();
	/**
	 * 通过id删除分类
	 * @return
	 */
	Integer deleteById(Integer typeId);
	/**
	 * 通过id查看分类
	 * @return
	 */
	Types openById(Integer typeId);
	/**
	 * 通过id更新分类
	 * @return
	 */
	Integer updateByPrimaryKey(Types types);

}
