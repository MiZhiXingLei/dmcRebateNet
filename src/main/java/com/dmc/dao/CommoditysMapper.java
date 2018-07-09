package com.dmc.dao;

import com.dmc.entity.Commoditys;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * �־ò�
 * @author ���� 2018-07-03
 *
 */
@Repository(value = "commoditysMapper")
public interface CommoditysMapper {
    
	/**
	 * ɾ����Ʒ
	 * @param comid
	 * @return
	 */
    int deleteByPrimaryKey(Long comid);

    /**
     * ������Ʒ
     * @param record
     * @return
     */
    int insert(Commoditys record);

    /**
     * ��ѯ��Ʒ
     * @param comid
     * @return
     */
    Commoditys selectByPrimaryKey(Long comid);

    /**
     * ��ѯ������Ʒ
     * @return
     */
    List<Commoditys> selectAll();

    /**
     * ������Ʒ
     * @param record
     * @return
     */
    int updateByPrimaryKey(Commoditys record);
}