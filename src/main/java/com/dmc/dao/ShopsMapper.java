package com.dmc.dao;

import com.dmc.entity.Shops;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * �־ò�
 * @author ���� 2018-07-01
 *
 */
@Repository(value = "shopsdao")
public interface ShopsMapper {
    
	/**
     * ɾ�����ﳵ�е���Ʒ
     * @param shopid
     * @param prodid
     * @return
     */
    int deleteByPrimaryKey(@Param("shopid") Long shopid, @Param("prodid") Long prodid);
    
    /**
     * ����ɾ��
     * @param shopid
     * @param prodid
     * @return
     */
    int deleteShops(@Param("shopid") Long shopid, @Param("prodid") List<Integer> prodid);
    
    /**
     * ��չ��ﳵ
     * @param shopid
     * @return
     */
    int deleteAll(@Param("shopid") Long shopid);

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
    List<Shops> selectByPrimaryKey(@Param("shopid") Long shopid, @Param("prodid") Long prodid);

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
    double selectAllSum(@Param("shopid") Long shopid, @Param("prodid") List<String> prodid);

    /**
     * ���¹��ﳵ�е���Ʒ
     * @param record
     * @return
     */
    int updateByPrimaryKey(Shops record);
    
}