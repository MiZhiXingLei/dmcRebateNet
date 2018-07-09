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
	 * 将商品添加到付款单表，付款状态初始为默认值O
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
     * 获取商品的总价
     * @param userid
     * @return
     */
	@Override
	public double selectAllSum(Long userid) {
		// TODO Auto-generated method stub
		return um.selectAllSum(userid);
	}

	/**
     * 修改商品的数量
     * @param record
     * @return
     */
	@Override
	public int updateNumByPrimaryKey(Userorder record) {
		// TODO Auto-generated method stub
		return um.updateNumByPrimaryKey(record);
	}

}
