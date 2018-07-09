package com.dmc.dao;

import com.dmc.entity.orderlist;

public interface orderlistMapper {
    int deleteByPrimaryKey(Long orderid);

    int insert(orderlist record);

    int insertSelective(orderlist record);

    orderlist selectByPrimaryKey(Long orderid);

    int updateByPrimaryKeySelective(orderlist record);

    int updateByPrimaryKey(orderlist record);
}