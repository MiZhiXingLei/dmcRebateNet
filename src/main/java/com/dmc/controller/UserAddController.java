package com.dmc.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmc.entity.Useradds;
import com.dmc.service.UserAddsService;

@Controller
@RequestMapping("/add")
public class UserAddController {
	@Resource(name = "userAddsServiceImpl")
	private UserAddsService userAddsService;

	@RequestMapping("/location")
	public void addUserAdd(Useradds udd, String s_province, String s_city, String s_county, HttpServletRequest request,
			HttpServletResponse response) {
		boolean b = userAddsService.addUserAdd(udd, s_province, s_city, s_county);
		if (b) {
			try {
				request.getRequestDispatcher("/add/addlist").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@RequestMapping("/addlist")
	public String queryAdd(HttpServletRequest request) {
		long userid = 5l;
		List<Useradds> list = userAddsService.querAdd(userid);
		request.getSession().setAttribute("addlist", list);
		return "redirect:/front/home/pay.jsp";

	}

	@RequestMapping("/dele")
	public void deleAdd(String addid, HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(addid);
		userAddsService.deletAdd(id);
		try {
			request.getRequestDispatcher("/add/addlist").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
