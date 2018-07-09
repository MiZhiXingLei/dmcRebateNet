package com.dmc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmc.dao.CommoditysMapper;
import com.dmc.entity.Commoditys;
import com.dmc.service.CommoditysService;

@Service(value="commoditysService")
public class CommoditysServiceImpl implements CommoditysService {

	@Resource
	private CommoditysMapper commoditysMapper;
	
	@Override
	public int insert(Commoditys record) {
		// TODO Auto-generated method stub		
		return commoditysMapper.insert(record);
	}

	@Override
	public Commoditys selectById(Long comid) {
		// TODO Auto-generated method stub
		return commoditysMapper.selectByPrimaryKey(comid);
	}
	
	

}
