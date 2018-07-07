package com.dmc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dmc.entity.Member;

/**
 * 持久层
 * 
 * @author 徐扬 2018年6月27日
 *
 */
@Repository(value = "memberdao")
public interface MemberMapper {

	/**
	 * 精确查询多个
	 * 
	 * @param map
	 * @return
	 */
	public List<Member> queryMembers(Map<String, Object> map);

	/**
	 * 精确查询单个成员
	 * 
	 * @param map
	 * @return
	 */
	public Member queryMember(Map<String, Object> map);

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Member> queryByPage(Map<String, Object> map);

	/**
	 * 查询总记录数
	 * 
	 * @param map
	 * @return
	 */
	public int queryRecordsTotal(String memberDel);

	/**
	 * 查询过滤后的记录数
	 * 
	 * @param map
	 * @return
	 */
	public int queryRecordsFiltered(Map<String, Object> map);

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
	public boolean updMemberDel(@Param("memberDel") String memberDel, @Param("memberId") String memberId);

	/**
	 * 修改成员删除状态(批量修改)
	 * 
	 * @param memberIds
	 * @param memberDel
	 * @return
	 */
	public boolean updMembersDel(@Param("memberIds") List<Integer> memberIds, @Param("memberDel") String memberDel);

	/**
	 * 真删除
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
	public boolean updMemberStatus(@Param("memberStatus") String memberStatus, @Param("memberId") String memberId);

	/**
	 * 修改成员密码
	 * 
	 * @param map
	 * @return
	 */
	public boolean updMemberPwd(@Param("memberPwd") String memberPwd, @Param("memberId") String memberId);

}
