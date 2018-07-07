package com.dmc.entity;

public class Commoditys {

	private Long comid; // ��Ʒ���
	private Long cdytype; // ��Ʒ����
	private String comname; // ��Ʒ����
	private Double comprice; // ��Ʒ�۸�
	private Double comdisprice; // �ۿۺ�ļ۸�
	private Long comnum; // ��Ʒ���
	private String comimg; // ��ƷͼƬ
	private String comrank; // ��Ʒ���
	private String comdescribe; // ��Ʒ����

	public Commoditys() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Commoditys [comid=" + comid + ", cdytype=" + cdytype + ", comname=" + comname + ", comprice=" + comprice
				+ ", comdisprice=" + comdisprice + ", comnum=" + comnum + ", comimg=" + comimg + ", comrank=" + comrank
				+ ", comdescribe=" + comdescribe + "]";
	}

	public Commoditys(Long cdytype, String comname, Double comprice, Double comdisprice, Long comnum, String comimg,
			String comrank, String comdescribe) {
		super();
		this.cdytype = cdytype;
		this.comname = comname;
		this.comprice = comprice;
		this.comdisprice = comdisprice;
		this.comnum = comnum;
		this.comimg = comimg;
		this.comrank = comrank;
		this.comdescribe = comdescribe;
	}

	public Commoditys(Long comid, Double comprice, Double comdisprice, Long comnum, String comimg, String comrank,
			String comdescribe) {
		super();
		this.comid = comid;
		this.comprice = comprice;
		this.comdisprice = comdisprice;
		this.comnum = comnum;
		this.comimg = comimg;
		this.comrank = comrank;
		this.comdescribe = comdescribe;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public Long getCdytype() {
		return cdytype;
	}

	public void setCdytype(Long cdytype) {
		this.cdytype = cdytype;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public Double getComprice() {
		return comprice;
	}

	public void setComprice(Double comprice) {
		this.comprice = comprice;
	}

	public Double getComdisprice() {
		return comdisprice;
	}

	public void setComdisprice(Double comdisprice) {
		this.comdisprice = comdisprice;
	}

	public Long getComnum() {
		return comnum;
	}

	public void setComnum(Long comnum) {
		this.comnum = comnum;
	}

	public String getComimg() {
		return comimg;
	}

	public void setComimg(String comimg) {
		this.comimg = comimg;
	}

	public String getComrank() {
		return comrank;
	}

	public void setComrank(String comrank) {
		this.comrank = comrank;
	}

	public String getComdescribe() {
		return comdescribe;
	}

	public void setComdescribe(String comdescribe) {
		this.comdescribe = comdescribe;
	}
}