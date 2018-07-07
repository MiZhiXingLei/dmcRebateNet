package com.dmc.service;

import java.util.List;

import com.dmc.entity.Shops;

/**
 * 业务层
 * @author 徐扬 2018-07-01
 *
 */
public interface ShopsService {

	/**
     * 删除购物车中的商品
     * @param shopid
     * @param prodid
     * @return
     */
    int deleteByPrimaryKey(Long shopid, Long prodid);
    
    /**
     * 批量删除
     * @param shopid
     * @param prodid
     * @return
     */
    int deleteShops(Long shopid, List<Integer> prodid);
    
    /**
     * 清空购物车
     * @param shopid
     * @return
     */
    int deleteAll(Long shopid);

    /**
     * 增加购物车中的商品
     * @param record
     * @return
     */
    int insert(Shops record);

    /**
     * 查询购物车中的商品
     * @param shopid
     * @return
     */
    List<Shops> selectByPrimaryKey(Long shopid, Long prodid);

    /**
     * 查询购物车表中的所有数据
     * @return
     */
    List<Shops> selectAll();
    
    /**
     * 获取商品的总价
     * @param shopid
     * @param prodid
     * @return
     */
    double selectAllSum(Long shopid, List<String> prodid);

    /**
     * 更新购物车中的商品
     * @param record
     * @return
     */
    int updateByPrimaryKey(Shops record);
    
}
