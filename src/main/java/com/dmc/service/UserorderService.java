package com.dmc.service;

import java.util.List;

import com.dmc.entity.Userorder;


public interface UserorderService {

	/**
	 * �����Ʒ�������б�
	 * @param uo
	 * @return
	 */
	int insert(Userorder uo);
	
	/**
	 * ��ѯ�û�δ�������Ʒ
	 */
	List<Userorder> selectByUserId(Long userId);
	
	
	List<Userorder> selectAll();
}
