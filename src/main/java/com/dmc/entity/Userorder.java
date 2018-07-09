package com.dmc.entity;

import java.io.Serializable;

/**
 * 订单实体类
 * @author gousq
 *
 */
public class Userorder implements Serializable{

	private Integer orderid;

    private String ordername;

    private Double orderprice;

    private Integer ordercount;

    private String orderrank;

    private Long userid;

    private Integer orderstate;
    
    private Double orderprototamt;

    public Double getOrderprototamt() {
		return orderprototamt;
	}

	public void setOrderprototamt(Double orderprototamt) {
		this.orderprototamt = orderprototamt;
	}

	public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername == null ? null : ordername.trim();
    }

    public Double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Double orderprice) {
        this.orderprice = orderprice;
    }

    public Integer getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(Integer ordercount) {
        this.ordercount = ordercount;
    }

    public String getOrderrank() {
        return orderrank;
    }

    public void setOrderrank(String orderrank) {
        this.orderrank = orderrank == null ? null : orderrank.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }
    
	public Userorder() {
		super();
	}

	public Userorder(Integer orderid, Integer ordercount, Double orderprototamt) {
		super();
		this.orderid = orderid;
		this.ordercount = ordercount;
		this.orderprototamt = orderprototamt;
	}

	public Userorder(String ordername, Double orderprice, Integer ordercount, String orderrank, Long userid) {
		super();
		this.ordername = ordername;
		this.orderprice = orderprice;
		this.ordercount = ordercount;
		this.orderrank = orderrank;
		this.userid = userid;
	}
    
    
}