package com.dmc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/**
	 * 修改商品的数量
	 * @param orderId
	 * @param ordercount
	 * @param orderPrototamt
	 * @return
	 */
	@RequestMapping(value="updateNum/{orderId}/{ordercount}/{orderPrototamt}",method=RequestMethod.PUT)
	@ResponseBody
	public boolean updateNum(@PathVariable(value = "orderId") Integer orderId, @PathVariable(value = "ordercount") Integer ordercount, 
			@PathVariable(value = "orderPrototamt") Double orderPrototamt){
		Userorder record = new Userorder(orderId, ordercount, orderPrototamt);
		return us.updateNumByPrimaryKey(record) > 0;
	}
	
	/**
	 * 获取商品的总价
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="queryAllSum",method=RequestMethod.GET)
	@ResponseBody
	public double queryAllSum(Long userId) {
		return us.selectAllSum(userId);
	}
	
	@RequestMapping(value="showOrder2",method=RequestMethod.GET)
	@ResponseBody
	public List<Userorder> showOrder2(){
		List<Userorder> list = us.selectAll();
		System.out.println("测试");
		System.out.println("list:"+list);
		return list;
	}
	
	
}
