package com.dmc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmc.dao.ShopsMapper;
import com.dmc.entity.Shops;
import com.dmc.service.ShopsService;

/**
 * 业务层
 * @author 徐扬 2018-07-01
 *
 */
@Service(value = "shopsservice")
public class ShopsServiceImpl implements ShopsService {

	@Resource(name = "shopsdao")
	private ShopsMapper sm;
	
	/**
     * 删除购物车中的商品
     * @param shopid
     * @param prodid
     * @return
     */
	public int deleteByPrimaryKey(Long shopid, Long prodid) {
		// TODO Auto-generated method stub
		return sm.deleteByPrimaryKey(shopid, prodid);
	}
	
	/**
     * 批量删除
     * @param shopid
     * @param prodid
     * @return
     */
	public int deleteShops(Long shopid, List<Integer> prodid) {
		// TODO Auto-generated method stub
		return sm.deleteShops(shopid, prodid);
	}

	/**
     * 清空购物车
     * @param shopid
     * @return
     */
	public int deleteAll(Long shopid) {
		// TODO Auto-generated method stub
		return sm.deleteAll(shopid);
	}

	/**
     * 增加购物车中的商品
     * @param record
     * @return
     */
	public int insert(Shops record) {
		// TODO Auto-generated method stub
		return sm.insert(record);
	}

	/**
     * 查询购物车中的商品
     * @param shopid
     * @return
     */
	public List<Shops> selectByPrimaryKey(Long shopid, Long prodid) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(shopid, prodid);
	}

	/**
     * 查询购物车表中的所有数据
     * @return
     */
	public List<Shops> selectAll() {
		// TODO Auto-generated method stub
		return sm.selectAll();
	}

	/**
     * 获取商品的总价
     * @param shopid
     * @param prodid
     * @return
     */
	public double selectAllSum(Long shopid, List<String> prodid) {
		// TODO Auto-generated method stub
		return sm.selectAllSum(shopid, prodid);
	}
	
	/**
     * 更新购物车中的商品
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Shops record) {
		// TODO Auto-generated method stub
		return sm.updateByPrimaryKey(record);
	}

}
