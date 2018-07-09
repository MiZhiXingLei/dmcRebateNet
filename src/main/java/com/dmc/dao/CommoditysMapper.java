package com.dmc.dao;

import com.dmc.entity.Commoditys;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 持久层
 * @author 徐扬 2018-07-03
 *
 */
@Repository(value = "commoditysMapper")
public interface CommoditysMapper {
    
	/**
	 * 删除商品
	 * @param comid
	 * @return
	 */
    int deleteByPrimaryKey(Long comid);

    /**
     * 增加商品
     * @param record
     * @return
     */
    int insert(Commoditys record);

    /**
     * 查询商品
     * @param comid
     * @return
     */
    Commoditys selectByPrimaryKey(Long comid);

    /**
     * 查询所有商品
     * @return
     */
    List<Commoditys> selectAll();

    /**
     * 更新商品
     * @param record
     * @return
     */
    int updateByPrimaryKey(Commoditys record);
}