package com.mapleleaf.blog.dao;

import java.util.ArrayList;

import com.mapleleaf.blog.entity.Articles;
import com.mapleleaf.blog.entity.Diary;

public interface DiaryMapper {
    int deleteByPrimaryKey(Integer diaryId);

    int insert(Diary record);

    int insertSelective(Diary record);

    Diary selectByPrimaryKey(Integer diaryId);

    int updateByPrimaryKeySelective(Diary record);

    int updateByPrimaryKeyWithBLOBs(Diary record);

    int updateByPrimaryKey(Diary record);
    /**
	 * 查询所有日记
	 * @return
	 */
	ArrayList<Diary> selectDiaryList();
}