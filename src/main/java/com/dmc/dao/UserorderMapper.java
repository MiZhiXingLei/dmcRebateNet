package com.dmc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dmc.entity.Userorder;

@Repository(value="orderMapper")
public interface UserorderMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Userorder record);

    int insertSelective(Userorder record);

    List<Userorder> selectByUserId(Long userid);

    int updateByPrimaryKeySelective(Userorder record);

    int updateByPrimaryKey(Userorder record);
    
    
    List<Userorder> selectAll();
}