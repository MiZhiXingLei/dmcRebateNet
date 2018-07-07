package com.dmc.service;

import java.util.List;
import java.util.Map;

import com.dmc.entity.Member;

public interface MemberService {

	/**
	 * 精确查询单个成员
	 * 
	 * @param args
	 * @return
	 */
	public Member getMember(Map<String, Object> map);
	
	/**
	 * 分页查询 + 模糊查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Member> getByPage(Map<String, Object> map);
	
	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getRecordsTotal(String memberDel);
	
	/**
	 * 查询过滤后的记录数
	 * 
	 * @param map
	 * @return
	 */
	public int getRecordsFiltered(Map<String, Object> map);
	
	/**
	 * 增加成员
	 * 
	 * @param member
	 * @return
	 */
	public boolean addMember(Member member);

	/**
	 * 修改成员删除状态
	 * 
	 * @param memberDel
	 * @param memberId
	 * @return
	 */
	public boolean updMemberDel(String memberDel, String memberId);

	/**
	 * 修改成员删除状态(批量修改)
	 * 
	 * @param memberIds
	 * @param memberDel
	 * @return
	 */
	public boolean updMembersDel(List<Integer> memberIds, String memberDel);
	
	/**
	 * 删除成员(单个)
	 * 
	 * @param memberId
	 * @return
	 */
	public boolean delMember(String memberId);
	
	/**
	 * 删除成员(可批量删除)
	 * 
	 * @param memberIds
	 * @return
	 */
	public boolean delMembers(List<Integer> memberIds);

	/**
	 * 修改成员的其他属性
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberOther(Member member);

	/**
	 * 修改成员状态
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberStatus(String memberStatus, String memberId);

	/**
	 * 修改成员密码
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberPwd(String memberPwd, String memberId);
}
