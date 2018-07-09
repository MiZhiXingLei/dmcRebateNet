package com.dmc.entity;

import java.util.Date;

public class orderlist {
    private Long orderid;

    private Long useUserid;

    private Long userid;

    private Date ordertime;

    private Integer orderstate;

    private Integer orderflowstate;

    private Long ordermoney;

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getUseUserid() {
        return useUserid;
    }

    public void setUseUserid(Long useUserid) {
        this.useUserid = useUserid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    public Integer getOrderflowstate() {
        return orderflowstate;
    }

    public void setOrderflowstate(Integer orderflowstate) {
        this.orderflowstate = orderflowstate;
    }

    public Long getOrdermoney() {
        return ordermoney;
    }

    public void setOrdermoney(Long ordermoney) {
        this.ordermoney = ordermoney;
    }
}