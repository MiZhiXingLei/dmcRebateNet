package com.dmc.dao;

import java.util.List;

import com.dmc.entity.Useradds;

public interface UseraddsMapper {
	int deleteByPrimaryKey(Long addid);

	int insert(Useradds record);

	int insertSelective(Useradds record);

	Useradds selectByPrimaryKey(Long addid);

	int updateByPrimaryKeySelective(Useradds record);

	int updateByPrimaryKey(Useradds record);

	List<Useradds> querUserAdd(long userid);
}