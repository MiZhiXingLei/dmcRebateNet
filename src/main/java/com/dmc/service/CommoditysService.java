package com.dmc.service;

import com.dmc.entity.Commoditys;

/**
 * �ӿ���Ʒ����ҵ���
 * @author gousq
 *
 */
public interface CommoditysService {

	
	/**
     * ȷ���Ƿ������Ʒ
     * @param comid
     * @return
     */
    Commoditys selectById(Long comid);
	
	 /**
     * ������Ʒ
     * @param record
     * @return
     */
    int insert(Commoditys record); 
    
}
