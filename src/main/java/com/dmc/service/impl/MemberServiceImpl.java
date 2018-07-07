package com.dmc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmc.dao.MemberMapper;
import com.dmc.entity.Member;
import com.dmc.service.MemberService;

/**
 * ҵ���
 * @author ����   2018��6��27��
 *
 */
@Service("memberservice")
public class MemberServiceImpl implements MemberService{

	@Resource(name = "memberdao")
	private MemberMapper dao;

	/**
	 * ��ȷ��ѯ������Ա
	 * 
	 * @param map
	 * @return
	 */
	public Member getMember(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.queryMember(map);
	}

	/**
	 * ��ҳ��ѯ + ģ����ѯ
	 * 
	 * @param map
	 * @return
	 */
	public List<Member> getByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.queryByPage(map);
	}

	/**
	 * ��ѯ�ܼ�¼��
	 * 
	 * @return
	 */
	public int getRecordsTotal(String memberDel) {
		// TODO Auto-generated method stub
		return dao.queryRecordsTotal(memberDel);
	}

	/**
	 * ��ѯ���˺�ļ�¼��
	 * 
	 * @param map
	 * @return
	 */
	public int getRecordsFiltered(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.queryRecordsFiltered(map);
	}
	
	/**
	 * ���ӳ�Ա
	 * 
	 * @param member
	 * @return
	 */
	public boolean addMember(Member member) {
		// TODO Auto-generated method stub
		return dao.addMember(member);
	}

	/**
	 * �޸ĳ�Աɾ��״̬
	 * 
	 * @param memberDel
	 * @param memberId
	 * @return
	 */
	public boolean updMemberDel(String memberDel, String memberId) {
		// TODO Auto-generated method stub
		return dao.updMemberDel(memberDel, memberId);
	}

	/**
	 * �޸ĳ�Աɾ��״̬(�����޸�)
	 * 
	 * @param memberIds
	 * @param memberDel
	 * @return
	 */
	public boolean updMembersDel(List<Integer> memberIds, String memberDel) {
		// TODO Auto-generated method stub
		return dao.updMembersDel(memberIds, memberDel);
	}
	
	/**
	 * ɾ����Ա(����)
	 * 
	 * @param memberId
	 * @return
	 */
	public boolean delMember(String memberId) {
		// TODO Auto-generated method stub
		return dao.delMember(memberId);
	} 
	
	/**
	 * ɾ����Ա(������ɾ��)
	 * 
	 * @param memberId
	 * @return
	 */
	public boolean delMembers(List<Integer> memberIds) {
		// TODO Auto-generated method stub
		return dao.delMembers(memberIds);
	}

	/**
	 * �޸ĳ�Ա����������
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberOther(Member member) {
		// TODO Auto-generated method stub
		return dao.updMemberOther(member);
	}

	/**
	 * �޸ĳ�Ա״̬
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberStatus(String memberStatus, String memberId) {
		// TODO Auto-generated method stub
		return dao.updMemberStatus(memberStatus, memberId);
	}

	/**
	 * �޸ĳ�Ա����
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberPwd(String memberPwd, String memberId) {
		// TODO Auto-generated method stub
		return dao.updMemberPwd(memberPwd, memberId);
	}
	
}
