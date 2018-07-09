package com.dmc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmc.dao.UserorderMapper;
import com.dmc.entity.Userorder;
import com.dmc.service.UserorderService;

@Service(value="userOrderService")
public class UserorderServiceImpl implements UserorderService {

	@Resource(name="orderMapper")
	private UserorderMapper um;
	
	/**
	 * ����Ʒ��ӵ����������״̬��ʼΪĬ��ֵO
	 */
	@Override
	public int insert(Userorder uo) {
		// TODO Auto-generated method stub
		return um.insert(uo);
	}

	@Override
	public List<Userorder> selectByUserId(Long userId) {
		// TODO Auto-generated method stub
		return um.selectByUserId(userId);
	}

	@Override
	public List<Userorder> selectAll() {
		// TODO Auto-generated method stub
		return um.selectAll();
	}

	/**
     * ��ȡ��Ʒ���ܼ�
     * @param userid
     * @return
     */
	@Override
	public double selectAllSum(Long userid) {
		// TODO Auto-generated method stub
		return um.selectAllSum(userid);
	}

	/**
     * �޸���Ʒ������
     * @param record
     * @return
     */
	@Override
	public int updateNumByPrimaryKey(Userorder record) {
		// TODO Auto-generated method stub
		return um.updateNumByPrimaryKey(record);
	}

}
