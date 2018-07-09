package com.dmc.service;

import com.dmc.entity.Commoditys;

/**
 * 接口商品处理业务层
 * @author gousq
 *
 */
public interface CommoditysService {

	
	/**
     * 确认是否存在商品
     * @param comid
     * @return
     */
    Commoditys selectById(Long comid);
	
	 /**
     * 增加商品
     * @param record
     * @return
     */
    int insert(Commoditys record); 
    
}
