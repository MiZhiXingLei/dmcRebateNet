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
 * 前端控制器
 * @author 徐扬 2018年6月24日
 *
 */
@Controller
@RequestMapping("/member")
@SessionAttributes(value = { "members" })
public class MemberController {

	@Resource(name = "memberservice")
	private MemberService ms;

	/**
	 * 单个查询--login
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
	 * 分页+模糊查询
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "queryByPage", method = RequestMethod.GET)
	@ResponseBody
	public Map<Object, Object> queryByPage(HttpServletRequest request) {
		// 获取请求次数
		String draw = "0";
		draw = request.getParameter("draw");
		// 获取用户修改状态
		String memberDel = request.getParameter("memberDel");
		// 获取用户输入的数据
		String memberLike = request.getParameter("memberLike");
		// 获取开始日期
		String preDate = request.getParameter("preDate");
		// 获取结束日期
		String nextDate = request.getParameter("nextDate");
		// 数据起始位置
		int start = Integer.parseInt(request.getParameter("start"));
		// 数据长度
		String length = request.getParameter("length");
		int pagesize = Integer.parseInt(length);

		// 定义列名
		String[] cols = { "", "userId", "userName", "userPhoto", "userSex", "userRegist", "userEmail", "userBlance",
				"userRtime" };
		// 获取客户端需要那一列排序
		String orderColumn = "0";
		orderColumn = request.getParameter("order[0][column]"); // 需要的参数
		orderColumn = cols[Integer.parseInt(orderColumn)];
		// 获取排序方式 默认为asc
		String orderDir = "asc";
		orderDir = request.getParameter("order[0][dir]");
		// 获取用户过滤框里的字符
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
	 * 进入用户列表的方法
	 * 
	 * @return
	 */
	@RequestMapping("toQueryAll")
	public String toQueryAll() {
		return "memberlist";
	}

	/**
	 * 增加成员
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
		// 生成加盐密码
		String memberWidthPwd = null;

		// 将request 转换为 MultipartHttpServletRequest
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		// 得到上传的文件
		MultipartFile file = req.getFile("memberPhoto");
		// 判断文件是否存在
		if (file != null) {
			newPath = processFile(file);
		} else {
			if ("男".equals(memberSex)) {
				newPath = "../imgs/boy.png";
			} else if ("女".equals(memberSex)) {
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
	 * 修改成员
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
		// 将request 转换为 MultipartHttpServletRequest
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		// 得到上传的文件
		MultipartFile file = req.getFile("memberPhoto");
		// 判断文件是否存在
		if (file != null) {
			newPath = processFile(file);
		} else {
			if ("男".equals(memberSex)) {
				newPath = "../imgs/boy.png";
			} else if ("女".equals(memberSex)) {
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
	 * 修改成员密码
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
	 * 修改成员状态
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
	 * 修改成员删除状态
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
	 * 修改成员删除状态（批量修改）
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
	 * 删除成员
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
	 * 批量删除的方法
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
	 * 检测文件的类型是否匹配
	 * 
	 * @param request
	 * @param filetype
	 *            指定文件的类型
	 * @return
	 */
	@RequestMapping(value = "checkFile", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkFileType(HttpServletRequest request, String filetype) {
		// 将request 转换为 MultipartHttpServletRequest
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		// 得到上传的文件
		MultipartFile file = req.getFile("file");
		// 获取上传文件的类型
		String fileType = file.getContentType();
		if (fileType.contains(filetype)) {
			return true;
		}
		return false;
	}

	/**
	 * 存储文件的通用方法（任何类型）
	 * 
	 * @param file
	 * @param filetype
	 *            指定文件类型
	 * @return 返回文件的可读路径
	 */
	public String saveFile(MultipartFile file, String filetype) {
		// 获取文件名
		String filename = file.getOriginalFilename();
		// 获取唯一参数
		String str = filetype + UUID.randomUUID().toString();
		// 获取文件存储的绝对路径
		String path = "E:/upload/file/" + str + filename;
		// 获取可读的文件路径
		String newPath = "http://127.0.0.1:8080/file/" + str + filename;
		// 创建目标文件
		File destFile = new File(path);
		try {
			// 直接使用封装好的 copyInputStreamToFile 实现文件的上传功能
			FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newPath;
	}

	/**
	 * 分类处理不同的文件
	 * 
	 * @param file
	 * @return 返回文件的可读路径
	 */
	public String processFile(MultipartFile file) {
		// 可读文件路径
		String newPath = null;
		// 指定文件的类型
		String filetype = null;
		// 获取文件的类型
		String fileType = file.getContentType();
		// 分类型处理不同的文件
		if (fileType.contains("image/")) { // 图片类型
			filetype = "image/";
			newPath = saveFile(file, filetype);
		} else if (fileType.contains("video/")) { // 视频类型
			filetype = "video/";
			newPath = saveFile(file, filetype);
		} else if (fileType.contains("audio/")) { // 音频类型
			filetype = "audio/";
			newPath = saveFile(file, filetype);
		} else if (fileType.contains("application/")) { // 文本类型
			filetype = "application/";
			newPath = saveFile(file, filetype);
		}
		return newPath;
	}

	/* 这里开始是苏辉锟的代码***************************************** */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	/**
	 * 注册用户的方法
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
	 * 发送用户的验证码
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
	 * 用户登入
	 */
	/**
	 * 单个查询--login
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