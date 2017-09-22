package com.mapleleaf.blog.service.Interface;

import java.util.ArrayList;

import com.mapleleaf.blog.entity.Diary;

public interface IDiaryService {
	/**
	 * 查询所有日记
	 * @return
	 */
	ArrayList<Diary> selectDiaryList();

}
