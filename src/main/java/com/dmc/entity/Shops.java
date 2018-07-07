package com.dmc.entity;

/**
 * 购物车实体类
 * @author   徐扬   2018-07-01
 *
 */
public class Shops {
    
    private Long shopid; //购物车编号
    private Long prodid;  //商品编号
    private Integer qty; //商品数量
    private Double prototamt; //商品总价
    private Commoditys commoditys; //商品
    
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