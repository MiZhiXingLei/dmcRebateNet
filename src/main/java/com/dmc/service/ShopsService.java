package com.dmc.service;

import java.util.List;

import com.dmc.entity.Shops;

/**
 * ҵ���
 * @author ���� 2018-07-01
 *
 */
public interface ShopsService {

	/**
     * ɾ�����ﳵ�е���Ʒ
     * @param shopid
     * @param prodid
     * @return
     */
    int deleteByPrimaryKey(Long shopid, Long prodid);
    
    /**
     * ����ɾ��
     * @param shopid
     * @param prodid
     * @return
     */
    int deleteShops(Long shopid, List<Integer> prodid);
    
    /**
     * ��չ��ﳵ
     * @param shopid
     * @return
     */
    int deleteAll(Long shopid);

    /**
     * ���ӹ��ﳵ�е���Ʒ
     * @param record
     * @return
     */
    int insert(Shops record);

    /**
     * ��ѯ���ﳵ�е���Ʒ
     * @param shopid
     * @return
     */
    List<Shops> selectByPrimaryKey(Long shopid, Long prodid);

    /**
     * ��ѯ���ﳵ���е���������
     * @return
     */
    List<Shops> selectAll();
    
    /**
     * ��ȡ��Ʒ���ܼ�
     * @param shopid
     * @param prodid
     * @return
     */
    double selectAllSum(Long shopid, List<String> prodid);

    /**
     * ���¹��ﳵ�е���Ʒ
     * @param record
     * @return
     */
    int updateByPrimaryKey(Shops record);
    
}
