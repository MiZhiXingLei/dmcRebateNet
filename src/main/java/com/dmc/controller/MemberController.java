package com.dmc.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.dmc.entity.Member;
import com.dmc.service.MemberService;
import com.dmc.util.SmsDemo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ǰ�˿�����
 * @author ���� 2018��6��24��
 *
 */
@Controller
@RequestMapping("/member")
@SessionAttributes(value = { "members" })
public class MemberController {

	@Resource(name = "memberservice")
	private MemberService ms;

	/**
	 * ������ѯ--login
	 * 
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	@ResponseBody
	@ModelAttribute(value = "members")
	public Member login(String memberName, String memberPwd, String memberDel) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberName", memberName);
		map.put("memberPwd", memberPwd);
		map.put("memberDel", memberDel);
		Member member = ms.getMember(map);
		return member;
	}

	/**
	 * ��ҳ+ģ����ѯ
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "queryByPage", method = RequestMethod.GET)
	@ResponseBody
	public Map<Object, Object> queryByPage(HttpServletRequest request) {
		// ��ȡ�������
		String draw = "0";
		draw = request.getParameter("draw");
		// ��ȡ�û��޸�״̬
		String memberDel = request.getParameter("memberDel");
		// ��ȡ�û����������
		String memberLike = request.getParameter("memberLike");
		// ��ȡ��ʼ����
		String preDate = request.getParameter("preDate");
		// ��ȡ��������
		String nextDate = request.getParameter("nextDate");
		// ������ʼλ��
		int start = Integer.parseInt(request.getParameter("start"));
		// ���ݳ���
		String length = request.getParameter("length");
		int pagesize = Integer.parseInt(length);

		// ��������
		String[] cols = { "", "userId", "userName", "userPhoto", "userSex", "userRegist", "userEmail", "userBlance",
				"userRtime" };
		// ��ȡ�ͻ�����Ҫ��һ������
		String orderColumn = "0";
		orderColumn = request.getParameter("order[0][column]"); // ��Ҫ�Ĳ���
		orderColumn = cols[Integer.parseInt(orderColumn)];
		// ��ȡ����ʽ Ĭ��Ϊasc
		String orderDir = "asc";
		orderDir = request.getParameter("order[0][dir]");
		// ��ȡ�û����˿�����ַ�
		String searchValue = request.getParameter("search[value]");
		if (searchValue == null) {
			searchValue = "";
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberLike", searchValue);
		map.put("memberLikes", memberLike);
		map.put("preDate", preDate);
		map.put("nextDate", nextDate);
		map.put("memberDel", memberDel);
		map.put("method", orderColumn + " " + orderDir);
		map.put("start", start);
		map.put("size", pagesize);
		List<Member> list = ms.getByPage(map);
		int recordsTotal = ms.getRecordsTotal(memberDel);
		int recordsFiltered = ms.getRecordsFiltered(map);
		// page.getResultList().forEach(System.out::println);
		Map<Object, Object> info = new HashMap<Object, Object>();
		info.put("data", list);
		info.put("draw", draw);
		info.put("recordsTotal", recordsTotal);
		info.put("recordsFiltered", recordsFiltered);
		return info;
	}

	/**
	 * �����û��б�ķ���
	 * 
	 * @return
	 */
	@RequestMapping("toQueryAll")
	public String toQueryAll() {
		return "memberlist";
	}

	/**
	 * ���ӳ�Ա
	 * 
	 * @param user
	 * 
	 * @return
	 */
	@RequestMapping(value = "addMember", method = RequestMethod.POST)
	@ResponseBody
	public boolean updMember(HttpServletRequest request, String memberName, String memberPwd, String memberSex,
			String memberPhone, String memberEmail, String memberRemark) {
		String newPath = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// ���ɼ�������
		String memberWidthPwd = null;

		// ��request ת��Ϊ MultipartHttpServletRequest
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		// �õ��ϴ����ļ�
		MultipartFile file = req.getFile("memberPhoto");
		// �ж��ļ��Ƿ����
		if (file != null) {
			newPath = processFile(file);
		} else {
			if ("��".equals(memberSex)) {
				newPath = "../imgs/boy.png";
			} else if ("Ů".equals(memberSex)) {
				newPath = "../imgs/girl.png";
			} else {
				newPath = "../imgs/boy.png";
			}
		}
		Member member = new Member(memberName, memberPwd, memberSex, memberPhone, memberEmail, newPath, memberRemark, 1,
				df.format(new Date()), 1, 0, memberWidthPwd, 1, 0.0, 0);
		boolean flag = ms.addMember(member);
		return flag;
	}

	/**
	 * �޸ĳ�Ա
	 * 
	 * @param user
	 * 
	 * @return
	 */
	@RequestMapping(value = "updMember", method = RequestMethod.POST)
	@ResponseBody
	public boolean updMember(HttpServletRequest request, int memberId, String memberName, String memberSex,
			String memberPhone, String memberEmail, String memberRemark, double memberBlance, int memberSco) {
		String newPath = null;
		// ��request ת��Ϊ MultipartHttpServletRequest
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		// �õ��ϴ����ļ�
		MultipartFile file = req.getFile("memberPhoto");
		// �ж��ļ��Ƿ����
		if (file != null) {
			newPath = processFile(file);
		} else {
			if ("��".equals(memberSex)) {
				newPath = "../imgs/boy.png";
			} else if ("Ů".equals(memberSex)) {
				newPath = "../imgs/girl.png";
			} else {
				newPath = "../imgs/boy.png";
			}
		}
		Member member = new Member(memberId, memberName, memberSex, memberPhone, memberEmail, newPath, memberRemark,
				memberBlance, memberSco);
		boolean flag = ms.updMemberOther(member);
		return flag;
	}

	/**
	 * �޸ĳ�Ա����
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "updMemberPwd/{memberId}/{memberPwd}", method = RequestMethod.PUT)
	@ResponseBody
	public boolean updMemberPwd(@PathVariable(value = "memberId") String memberId,
			@PathVariable(value = "memberPwd") String memberPwd) {
		boolean flag = ms.updMemberPwd(memberPwd, memberId);
		return flag;
	}

	/**
	 * �޸ĳ�Ա״̬
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "updMemberStatus/{memberId}/{memberStatus}", method = RequestMethod.PUT)
	@ResponseBody
	public boolean updMemberStatus(@PathVariable(value = "memberId") String memberId,
			@PathVariable(value = "memberStatus") String memberStatus) {
		boolean flag = ms.updMemberStatus(memberStatus, memberId);
		return flag;
	}

	/**
	 * �޸ĳ�Աɾ��״̬
	 * 
	 * @param memberId
	 * @param memberStatus
	 * @return
	 */
	@RequestMapping(value = "updMemberDel/{memberId}/{memberDel}", method = RequestMethod.PUT)
	@ResponseBody
	public boolean updMemberDel(@PathVariable(value = "memberId") String memberId,
			@PathVariable(value = "memberDel") String memberDel) {
		boolean flag = ms.updMemberDel(memberDel, memberId);
		return flag;
	}

	/**
	 * �޸ĳ�Աɾ��״̬�������޸ģ�
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "updMembersDel/{memberDel}", method = RequestMethod.PUT)
	@ResponseBody
	public boolean updMembersDel(HttpServletRequest request, @PathVariable(value = "memberDel") String memberDel)
			throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		@SuppressWarnings("deprecation")
		String membersid = IOUtils.toString(inputStream);
		JSONArray jsonarr = new JSONArray();
		jsonarr.add(membersid);
		JSONArray jsonarrs = (JSONArray) jsonarr.get(0);
		List<Integer> member_id = new ArrayList<Integer>();
		for (int i = 0; i < jsonarrs.size(); i++) {
			member_id.add(((JSONObject) jsonarrs.get(i)).getInt("member_id"));
		}
		boolean flag = ms.updMembersDel(member_id, memberDel);
		return flag;
	}

	/**
	 * ɾ����Ա
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "delMember/{memberId}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delMember(@PathVariable(value = "memberId") String memberId) {
		boolean flag = ms.delMember(memberId);
		return flag;
	}

	/**
	 * ����ɾ���ķ���
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "delMembers", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delMembers(HttpServletRequest request) throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		@SuppressWarnings("deprecation")
		String membersid = IOUtils.toString(inputStream);
		JSONArray jsonarr = new JSONArray();
		jsonarr.add(membersid);
		JSONArray jsonarrs = (JSONArray) jsonarr.get(0);
		List<Integer> member_id = new ArrayList<Integer>();
		for (int i = 0; i < jsonarrs.size(); i++) {
			member_id.add(((JSONObject) jsonarrs.get(i)).getInt("member_id"));
		}
		boolean flag = ms.delMembers(member_id);
		return flag;
	}

	/**
	 * ����ļ��������Ƿ�ƥ��
	 * 
	 * @param request
	 * @param filetype
	 *            ָ���ļ�������
	 * @return
	 */
	@RequestMapping(value = "checkFile", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkFileType(HttpServletRequest request, String filetype) {
		// ��request ת��Ϊ MultipartHttpServletRequest
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		// �õ��ϴ����ļ�
		MultipartFile file = req.getFile("file");
		// ��ȡ�ϴ��ļ�������
		String fileType = file.getContentType();
		if (fileType.contains(filetype)) {
			return true;
		}
		return false;
	}

	/**
	 * �洢�ļ���ͨ�÷������κ����ͣ�
	 * 
	 * @param file
	 * @param filetype
	 *            ָ���ļ�����
	 * @return �����ļ��Ŀɶ�·��
	 */
	public String saveFile(MultipartFile file, String filetype) {
		// ��ȡ�ļ���
		String filename = file.getOriginalFilename();
		// ��ȡΨһ����
		String str = filetype + UUID.randomUUID().toString();
		// ��ȡ�ļ��洢�ľ���·��
		String path = "E:/upload/file/" + str + filename;
		// ��ȡ�ɶ����ļ�·��
		String newPath = "http://127.0.0.1:8080/file/" + str + filename;
		// ����Ŀ���ļ�
		File destFile = new File(path);
		try {
			// ֱ��ʹ�÷�װ�õ� copyInputStreamToFile ʵ���ļ����ϴ�����
			FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newPath;
	}

	/**
	 * ���ദ��ͬ���ļ�
	 * 
	 * @param file
	 * @return �����ļ��Ŀɶ�·��
	 */
	public String processFile(MultipartFile file) {
		// �ɶ��ļ�·��
		String newPath = null;
		// ָ���ļ�������
		String filetype = null;
		// ��ȡ�ļ�������
		String fileType = file.getContentType();
		// �����ʹ���ͬ���ļ�
		if (fileType.contains("image/")) { // ͼƬ����
			filetype = "image/";
			newPath = saveFile(file, filetype);
		} else if (fileType.contains("video/")) { // ��Ƶ����
			filetype = "video/";
			newPath = saveFile(file, filetype);
		} else if (fileType.contains("audio/")) { // ��Ƶ����
			filetype = "audio/";
			newPath = saveFile(file, filetype);
		} else if (fileType.contains("application/")) { // �ı�����
			filetype = "application/";
			newPath = saveFile(file, filetype);
		}
		return newPath;
	}

	/* ���￪ʼ���ջ�￵Ĵ���***************************************** */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	/**
	 * ע���û��ķ���
	 * 
	 * @param member
	 * @param code
	 * @return
	 */
	public String addUser(Member member, String code, HttpServletRequest request) {
		HttpSession session = request.getSession();
		boolean b = false;
		String recode = (String) session.getAttribute("code");
		if (recode.equals(code)) {
			member.setMemberGrade(1);
			member.setMemberDel(1);
			b = ms.addMember(member);
		}
		if (b) {
			return "redirect:/front/home/login.jsp";
		} else {
			return "redirect:/front/home/register.jsp";
		}

	}

	@RequestMapping(value = "isuser", method = RequestMethod.POST)
	@ResponseBody
	public String isUser(String memberName) {
		System.out.println(memberName);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberName", memberName);
		map.put("memberDel", 1);
		Member member = ms.getMember(map);
		System.out.println(member);
		if (member == null) {
			return "true";
		}

		return "false";

	}

	/**
	 * �����û�����֤��
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping(value = "code", method = RequestMethod.POST)
	@ResponseBody
	public String getCode(String code, HttpServletRequest request) throws InterruptedException {
		String cd = code;
		try {
			List list = SmsDemo.sendSms(cd);
			SendSmsResponse senendSmsResponse = (SendSmsResponse) list.get(0);
			Thread.sleep(3000L);
			QuerySendDetailsResponse getr = SmsDemo.querySendDetails(senendSmsResponse.getBizId(), cd);

			HttpSession session = request.getSession();
			session.setAttribute("code", list.get(1));
			return senendSmsResponse.getCode();

		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";

	}
	/**
	 * �û�����
	 */
	/**
	 * ������ѯ--login
	 * 
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	@RequestMapping(value = "logins", method = RequestMethod.POST)
	@ResponseBody
	public String logins(String memberName, String memberPwd,HttpServletRequest request) {
		System.out.println(1);
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberName", memberName);
		map.put("memberPwd", memberPwd);
		map.put("memberDel", 1);
		Member member = ms.getMember(map);
		if(member != null) {
		   session.setAttribute("member", member);
		   return "ok";
		}
		return "no";
	}
}