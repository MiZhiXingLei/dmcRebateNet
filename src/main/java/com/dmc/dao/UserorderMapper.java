package com.dmc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dmc.entity.Userorder;

@Repository(value="orderMapper")
public interface UserorderMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Userorder record);

    int insertSelective(Userorder record);
    
    /**
     * ��ȡ��Ʒ���ܼ�
     * @param userid
     * @return
     */
    double selectAllSum(Long userid);

    List<Userorder> selectByUserId(Long userid);

    int updateByPrimaryKeySelective(Userorder record);

    int updateByPrimaryKey(Userorder record);
    
    /**
     * �޸���Ʒ������
     * @param record
     * @return
     */
    int updateNumByPrimaryKey(Userorder record);
    
    List<Userorder> selectAll();
}