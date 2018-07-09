package com.dmc.service;

import java.util.List;

import com.dmc.entity.Userorder;


public interface UserorderService {

	/**
	 * 添加商品到付款列表
	 * @param uo
	 * @return
	 */
	int insert(Userorder uo);
	
	/**
	 * 查询用户未付款的商品
	 */
	List<Userorder> selectByUserId(Long userId);
	
	
	List<Userorder> selectAll();
}
