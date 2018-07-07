package com.dmc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmc.dao.MemberMapper;
import com.dmc.entity.Member;
import com.dmc.service.MemberService;

/**
 * 业务层
 * @author 徐扬   2018年6月27日
 *
 */
@Service("memberservice")
public class MemberServiceImpl implements MemberService{

	@Resource(name = "memberdao")
	private MemberMapper dao;

	/**
	 * 精确查询单个成员
	 * 
	 * @param map
	 * @return
	 */
	public Member getMember(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.queryMember(map);
	}

	/**
	 * 分页查询 + 模糊查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Member> getByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.queryByPage(map);
	}

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getRecordsTotal(String memberDel) {
		// TODO Auto-generated method stub
		return dao.queryRecordsTotal(memberDel);
	}

	/**
	 * 查询过滤后的记录数
	 * 
	 * @param map
	 * @return
	 */
	public int getRecordsFiltered(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.queryRecordsFiltered(map);
	}
	
	/**
	 * 增加成员
	 * 
	 * @param member
	 * @return
	 */
	public boolean addMember(Member member) {
		// TODO Auto-generated method stub
		return dao.addMember(member);
	}

	/**
	 * 修改成员删除状态
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
	 * 修改成员删除状态(批量修改)
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
	 * 删除成员(单个)
	 * 
	 * @param memberId
	 * @return
	 */
	public boolean delMember(String memberId) {
		// TODO Auto-generated method stub
		return dao.delMember(memberId);
	} 
	
	/**
	 * 删除成员(可批量删除)
	 * 
	 * @param memberId
	 * @return
	 */
	public boolean delMembers(List<Integer> memberIds) {
		// TODO Auto-generated method stub
		return dao.delMembers(memberIds);
	}

	/**
	 * 修改成员的其他属性
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberOther(Member member) {
		// TODO Auto-generated method stub
		return dao.updMemberOther(member);
	}

	/**
	 * 修改成员状态
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberStatus(String memberStatus, String memberId) {
		// TODO Auto-generated method stub
		return dao.updMemberStatus(memberStatus, memberId);
	}

	/**
	 * 修改成员密码
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberPwd(String memberPwd, String memberId) {
		// TODO Auto-generated method stub
		return dao.updMemberPwd(memberPwd, memberId);
	}
	
}
