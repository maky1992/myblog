package com.mapleleaf.blog.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapleleaf.blog.dao.ArticlesMapper;
import com.mapleleaf.blog.dao.DiaryMapper;
import com.mapleleaf.blog.entity.Diary;
import com.mapleleaf.blog.service.Interface.IDiaryService;
@Service
public class DiaryService implements IDiaryService{
	@Autowired
	private DiaryMapper diaryMapper;
	/**
	 * 查询所有日记
	 * @return
	 */
	@Override
	public ArrayList<Diary> selectDiaryList() {
		ArrayList<Diary> typesList = null;
		typesList = diaryMapper.selectDiaryList();
		return typesList;
	}
}
