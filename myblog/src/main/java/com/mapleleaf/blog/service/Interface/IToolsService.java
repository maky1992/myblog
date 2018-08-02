package com.mapleleaf.blog.service.Interface;

import java.util.ArrayList;

import com.mapleleaf.blog.entity.SoftTools;

public interface IToolsService {

	/**
	 * 查询所有工具列表
	 * @return
	 */
	ArrayList<SoftTools> selectToolList();
	
	/**
	 * 添加工具
	 * @param tool
	 * @return
	 */
	Integer addTool(SoftTools tool);
	/**
	 * 根据主键查询工具
	 * @param toolId
	 * @return
	 */
	SoftTools selectByPrimaryKey(Integer toolId);
	/**
	 * 更新工具
	 * @param tool
	 * @return
	 */
	Integer updateTool(SoftTools tool);
	/**
	 * 删除工具
	 * @param toolId
	 * @return
	 */
	Integer deleteTool(Integer toolId);
}
