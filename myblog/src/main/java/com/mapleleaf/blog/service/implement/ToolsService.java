package com.mapleleaf.blog.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapleleaf.blog.dao.SoftToolsMapper;
import com.mapleleaf.blog.entity.SoftTools;
import com.mapleleaf.blog.service.Interface.IToolsService;

@Service
public class ToolsService implements IToolsService {
	
	@Autowired
	private SoftToolsMapper softToolsMapper;

	@Override
	public ArrayList<SoftTools> selectToolList() {
		ArrayList<SoftTools> list = null;
		list = softToolsMapper.selectAllTools();
		return list;
	}

	@Override
	public Integer addTool(SoftTools tool) {
		Integer flag = softToolsMapper.insertSelective(tool);
		return flag;
	}

	@Override
	public SoftTools selectByPrimaryKey(Integer toolId) {
		
		return softToolsMapper.selectByPrimaryKey(toolId);
	}

	@Override
	public Integer updateTool(SoftTools tool) {
		
		return softToolsMapper.updateByPrimaryKeySelective(tool);
	}

	@Override
	public Integer deleteTool(Integer toolId) {
		return softToolsMapper.deleteByPrimaryKey(toolId);
	}

}
