package com.dmc.entity;

/**
 * ��Աʵ����
 * @author ����  2018-6-24
 *
 */
public class Member {

	private long memberId;  //���
	private String memberName; //�û���
	private String memberPwd; //����
	private String memberSex; //�Ա�
	private String memberPhone; //�ֻ���
	private String memberEmail; //����
	private String memberPhoto; //ͷ��
	private String memberRemark; //���
	private int memberStatus; //״̬
	private String memberDate; //ע��ʱ��
	private int memberDel; //�Ƿ���ɾ��״̬
	private long memberShop; //���ﳵ
	private String memberWidthPwd; //����
	private int memberGrade; //�û��ȼ�
	private double memberBlance; //�û����
	private int memberSco; //�û�����

    public Member() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", memberPwd=" + memberPwd
				+ ", memberSex=" + memberSex + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail
				+ ", memberPhoto=" + memberPhoto + ", memberRemark=" + memberRemark + ", memberStatus=" + memberStatus
				+ ", memberDate=" + memberDate + ", memberDel=" + memberDel + ", memberShop=" + memberShop
				+ ", memberWidthPwd=" + memberWidthPwd + ", memberGrade=" + memberGrade + ", memberBlance="
				+ memberBlance + ", memberSco=" + memberSco + "]";
	}

	public Member(String memberName, String memberPwd, String memberSex, String memberPhone, String memberEmail,
			String memberPhoto, String memberRemark, int memberStatus, String memberDate, int memberDel,
			long memberShop, String memberWidthPwd, int memberGrade, double memberBlance, int memberSco) {
		super();
		this.memberName = memberName;
		this.memberPwd = memberPwd;
		this.memberSex = memberSex;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberPhoto = memberPhoto;
		this.memberRemark = memberRemark;
		this.memberStatus = memberStatus;
		this.memberDate = memberDate;
		this.memberDel = memberDel;
		this.memberShop = memberShop;
		this.memberWidthPwd = memberWidthPwd;
		this.memberGrade = memberGrade;
		this.memberBlance = memberBlance;
		this.memberSco = memberSco;
	}

	public Member(long memberId, String memberName, String memberSex, String memberPhone, String memberEmail,
			String memberPhoto, String memberRemark, double memberBlance, int memberSco) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberSex = memberSex;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberPhoto = memberPhoto;
		this.memberRemark = memberRemark;
		this.memberBlance = memberBlance;
		this.memberSco = memberSco;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberSex() {
		return memberSex;
	}

	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhoto() {
		return memberPhoto;
	}

	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}

	public String getMemberRemark() {
		return memberRemark;
	}

	public void setMemberRemark(String memberRemark) {
		this.memberRemark = memberRemark;
	}

	public int getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(int memberStatus) {
		this.memberStatus = memberStatus;
	}

	public String getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(String memberDate) {
		this.memberDate = memberDate;
	}

	public int getMemberDel() {
		return memberDel;
	}

	public void setMemberDel(int memberDel) {
		this.memberDel = memberDel;
	}

	public long getMemberShop() {
		return memberShop;
	}

	public void setMemberShop(long memberShop) {
		this.memberShop = memberShop;
	}

	public String getMemberWidthPwd() {
		return memberWidthPwd;
	}

	public void setMemberWidthPwd(String memberWidthPwd) {
		this.memberWidthPwd = memberWidthPwd;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public double getMemberBlance() {
		return memberBlance;
	}

	public void setMemberBlance(double memberBlance) {
		this.memberBlance = memberBlance;
	}

	public int getMemberSco() {
		return memberSco;
	}

	public void setMemberSco(int memberSco) {
		this.memberSco = memberSco;
	}

}
