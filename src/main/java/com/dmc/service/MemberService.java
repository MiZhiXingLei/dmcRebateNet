package com.dmc.service;

import java.util.List;
import java.util.Map;

import com.dmc.entity.Member;

public interface MemberService {

	/**
	 * ��ȷ��ѯ������Ա
	 * 
	 * @param args
	 * @return
	 */
	public Member getMember(Map<String, Object> map);
	
	/**
	 * ��ҳ��ѯ + ģ����ѯ
	 * 
	 * @param map
	 * @return
	 */
	public List<Member> getByPage(Map<String, Object> map);
	
	/**
	 * ��ѯ�ܼ�¼��
	 * 
	 * @return
	 */
	public int getRecordsTotal(String memberDel);
	
	/**
	 * ��ѯ���˺�ļ�¼��
	 * 
	 * @param map
	 * @return
	 */
	public int getRecordsFiltered(Map<String, Object> map);
	
	/**
	 * ���ӳ�Ա
	 * 
	 * @param member
	 * @return
	 */
	public boolean addMember(Member member);

	/**
	 * �޸ĳ�Աɾ��״̬
	 * 
	 * @param memberDel
	 * @param memberId
	 * @return
	 */
	public boolean updMemberDel(String memberDel, String memberId);

	/**
	 * �޸ĳ�Աɾ��״̬(�����޸�)
	 * 
	 * @param memberIds
	 * @param memberDel
	 * @return
	 */
	public boolean updMembersDel(List<Integer> memberIds, String memberDel);
	
	/**
	 * ɾ����Ա(����)
	 * 
	 * @param memberId
	 * @return
	 */
	public boolean delMember(String memberId);
	
	/**
	 * ɾ����Ա(������ɾ��)
	 * 
	 * @param memberIds
	 * @return
	 */
	public boolean delMembers(List<Integer> memberIds);

	/**
	 * �޸ĳ�Ա����������
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberOther(Member member);

	/**
	 * �޸ĳ�Ա״̬
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberStatus(String memberStatus, String memberId);

	/**
	 * �޸ĳ�Ա����
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberPwd(String memberPwd, String memberId);
}
