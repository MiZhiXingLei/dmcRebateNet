package com.dmc.entity;

/**
 * ���ﳵʵ����
 * @author   ����   2018-07-01
 *
 */
public class Shops {
    
    private Long shopid; //���ﳵ���
    private Long prodid;  //��Ʒ���
    private Integer qty; //��Ʒ����
    private Double prototamt; //��Ʒ�ܼ�
    private Commoditys commoditys; //��Ʒ
    
    public Shops() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Shops [shopid=" + shopid + ", prodid=" + prodid + ", qty=" + qty + ", prototamt="
				+ prototamt + ", commoditys=" + commoditys + "]";
	}

	public Shops(Long shopid, Long prodid, Integer qty, Double prototamt) {
		super();
		this.shopid = shopid;
		this.prodid = prodid;
		this.qty = qty;
		this.prototamt = prototamt;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

	public Long getProdid() {
		return prodid;
	}

	public void setProdid(Long prodid) {
		this.prodid = prodid;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Double getPrototamt() {
		return prototamt;
	}

	public void setPrototamt(Double prototamt) {
		this.prototamt = prototamt;
	}

	public Commoditys getComoditys() {
		return commoditys;
	}

	public void setComoditys(Commoditys comoditys) {
		this.commoditys = comoditys;
	}
   
}