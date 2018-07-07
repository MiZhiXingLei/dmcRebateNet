package com.dmc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dmc.entity.Member;

/**
 * �־ò�
 * 
 * @author ���� 2018��6��27��
 *
 */
@Repository(value = "memberdao")
public interface MemberMapper {

	/**
	 * ��ȷ��ѯ���
	 * 
	 * @param map
	 * @return
	 */
	public List<Member> queryMembers(Map<String, Object> map);

	/**
	 * ��ȷ��ѯ������Ա
	 * 
	 * @param map
	 * @return
	 */
	public Member queryMember(Map<String, Object> map);

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param map
	 * @return
	 */
	public List<Member> queryByPage(Map<String, Object> map);

	/**
	 * ��ѯ�ܼ�¼��
	 * 
	 * @param map
	 * @return
	 */
	public int queryRecordsTotal(String memberDel);

	/**
	 * ��ѯ���˺�ļ�¼��
	 * 
	 * @param map
	 * @return
	 */
	public int queryRecordsFiltered(Map<String, Object> map);

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
	public boolean updMemberDel(@Param("memberDel") String memberDel, @Param("memberId") String memberId);

	/**
	 * �޸ĳ�Աɾ��״̬(�����޸�)
	 * 
	 * @param memberIds
	 * @param memberDel
	 * @return
	 */
	public boolean updMembersDel(@Param("memberIds") List<Integer> memberIds, @Param("memberDel") String memberDel);

	/**
	 * ��ɾ��
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
	public boolean updMemberStatus(@Param("memberStatus") String memberStatus, @Param("memberId") String memberId);

	/**
	 * �޸ĳ�Ա����
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberPwd(@Param("memberPwd") String memberPwd, @Param("memberId") String memberId);

}
