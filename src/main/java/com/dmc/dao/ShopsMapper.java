package com.dmc.dao;

import com.dmc.entity.Shops;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 持久层
 * @author 徐扬 2018-07-01
 *
 */
@Repository(value = "shopsdao")
public interface ShopsMapper {
    
	/**
     * 删除购物车中的商品
     * @param shopid
     * @param prodid
     * @return
     */
    int deleteByPrimaryKey(@Param("shopid") Long shopid, @Param("prodid") Long prodid);
    
    /**
     * 批量删除
     * @param shopid
     * @param prodid
     * @return
     */
    int deleteShops(@Param("shopid") Long shopid, @Param("prodid") List<Integer> prodid);
    
    /**
     * 清空购物车
     * @param shopid
     * @return
     */
    int deleteAll(@Param("shopid") Long shopid);

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
    List<Shops> selectByPrimaryKey(@Param("shopid") Long shopid, @Param("prodid") Long prodid);

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
    double selectAllSum(@Param("shopid") Long shopid, @Param("prodid") List<String> prodid);

    /**
     * 更新购物车中的商品
     * @param record
     * @return
     */
    int updateByPrimaryKey(Shops record);
    
}