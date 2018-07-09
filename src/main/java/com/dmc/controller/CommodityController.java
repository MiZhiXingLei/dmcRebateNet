package com.dmc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmc.entity.Commoditys;
import com.dmc.entity.Userorder;
import com.dmc.service.CommoditysService;
import com.dmc.service.UserorderService;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
	
	@Resource(name="commoditysService")
	private CommoditysService cs;
	
	@Resource(name="userOrderService")
	private UserorderService us;
	
	/**
	 * 添加方法测试,出现了bug，换成反射接受
	 * @param comid
	 * @param comprice
	 * @param comname
	 * @param comnum
	 * @param comimg
	 * @param comrank
	 * @return
	 */
	/*@RequestMapping(value = "addCommodity/{comid}/{comprice}/{comname}/{comnum}/{comimg}/{comrank}", method = RequestMethod.POST)
	@ResponseBody
	public boolean addCommodity(@PathVariable(value="comid") long comid, @PathVariable(value="comprice") double comprice,
			@PathVariable(value="comname") String comname, @PathVariable(value="comnum") int comnum, 
			@PathVariable(value="comimg") String comimg, @PathVariable(value="comrank") String comrank) {
		Commoditys commodity = new Commoditys(comid, comname, comprice, comprice*0.85, comimg, comrank);
		System.out.println(commodity);
		return cs.insert(commodity) > 0;
	}*/
	
	@RequestMapping(value="/addCommodity", method=RequestMethod.POST)
	@ResponseBody
	public boolean addCommodity(Commoditys commodity,  Long userId) {
		System.out.println("userId:"+userId);
		Long comid = (Long)commodity.getComid();
		Commoditys com = cs.selectById(comid);
		System.out.println("commodity.getComprice():"+commodity.getComprice());
		Userorder uo = new Userorder(commodity.getComname(), commodity.getComprice(), Integer.parseInt(commodity.getComnum().toString()),commodity.getComrank(), userId);
		
		if(com==null) {
			boolean flag = cs.insert(commodity)>0;
			us.insert(uo);
			return flag;				
		}else {
			us.insert(uo);
			return true;
		}
	}
	
}
