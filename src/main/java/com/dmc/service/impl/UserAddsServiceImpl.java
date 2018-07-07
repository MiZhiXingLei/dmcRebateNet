package com.dmc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.dmc.dao.UseraddsMapper;
import com.dmc.entity.Useradds;
import com.dmc.service.UserAddsService;

@Repository(value = "userAddsServiceImpl")
public class UserAddsServiceImpl implements UserAddsService {
	@Resource(name = "useraddsMapper")
	private UseraddsMapper useraddsMapper;

	@Override
	public boolean addUserAdd(Useradds udd, String s_province, String s_city, String s_county) {
		udd.setUadd((s_province + s_city + s_county).trim());
		udd.setUserid((long) 5);
		udd.setDetailadd(udd.getDetailadd().trim());
		return useraddsMapper.insert(udd) > 0;

	}

	@Override
	public List<Useradds> querAdd(long userid) {
		return useraddsMapper.querUserAdd(userid);
	}

	@Override
	public boolean deletAdd(long addid) {
		return useraddsMapper.deleteByPrimaryKey(addid) > 0;
	}

}
