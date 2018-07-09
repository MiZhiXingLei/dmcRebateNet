package com.dmc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmc.entity.Userorder;
import com.dmc.service.UserorderService;

@Controller
@RequestMapping("/userOrder")
public class UserorderController {
	
	@Resource(name="userOrderService")
	private UserorderService us;
	
	@RequestMapping(value="showOrder",method=RequestMethod.GET)
	@ResponseBody
	public List<Userorder> showOrder(Long userId){
		System.out.println(userId);
		List<Userorder> list = us.selectByUserId(userId);
		System.out.println("list:"+list);
		return list;
	}
	
	@RequestMapping(value="showOrder2",method=RequestMethod.GET)
	@ResponseBody
	public List<Userorder> showOrder2(){
		List<Userorder> list = us.selectAll();
		System.out.println("≤‚ ‘");
		System.out.println("list:"+list);
		return list;
	}
	
	
}
