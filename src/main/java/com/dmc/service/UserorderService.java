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
	
	/**
     * ��ȡ��Ʒ���ܼ�
     * @param userid
     * @return
     */
    double selectAllSum(Long userid);
	
    /**
     * �޸���Ʒ������
     * @param record
     * @return
     */
    int updateNumByPrimaryKey(Userorder record);
    
	List<Userorder> selectAll();
}
