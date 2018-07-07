package com.dmc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmc.entity.Shops;
import com.dmc.service.ShopsService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 购物车前端控制器
 * @author 徐扬 2018-07-01
 *
 */
@Controller
@RequestMapping("/shops")
public class ShopsController {

	@Resource(name = "shopsservice")
	private ShopsService ss;
	
	/**
	 * 查询购物车中所有的商品
	 * @param shopid
	 * @return
	 */
	@RequestMapping(value = "queryShops", method = RequestMethod.GET)
	@ResponseBody
	public List<Shops> queryShops(int shopId){
		Long shopid = (long) shopId;
		Long prodid = (long) 0;
		List<Shops> list = ss.selectByPrimaryKey(shopid, prodid);
		return list;
	}
	
	/**
	 * 获得购物车中商品的总价
	 * @param shopid
	 * @return
	 */
	@RequestMapping(value = "queryAllSum/{shopId}", method = RequestMethod.PUT)
	@ResponseBody
	public double queryAllSum(HttpServletRequest request,  @PathVariable(value = "shopId") int shopId) throws IOException {
		Long shopid = (long) shopId;
		ServletInputStream inputStream = request.getInputStream();
		@SuppressWarnings("deprecation")
		String prodsid = IOUtils.toString(inputStream);
		JSONArray jsonarr = new JSONArray();
		jsonarr.add(prodsid);
		JSONArray jsonarrs = (JSONArray) jsonarr.get(0);
		List<String> prod_id = new ArrayList<String>();
		for (int i = 0; i < jsonarrs.size(); i++) {
			prod_id.add(((JSONObject) jsonarrs.get(i)).getString("prod_id"));
		}
		double sum = ss.selectAllSum(shopid, prod_id);
		return sum;
	}
	
	/**
	 * 增加购物车中的商品
	 * @param shopid
	 * @param prodid
	 * @return
	 */
	@RequestMapping(value = "addShops", method = RequestMethod.POST)
	@ResponseBody
	public boolean addShops(int shopId, int prodId, int Qty, double protoTamt) {
		Long shopid = (long) shopId;
		Long prodid = (long) prodId;
		Integer qty = Qty;
		Double prototamt = protoTamt;
		Shops record = new Shops(shopid, prodid, qty, prototamt);
		return ss.insert(record) > 0;
	}
	
	/**
	 * 删除购物车中的商品
	 * @param shopid
	 * @param prodid
	 * @return
	 */
	@RequestMapping(value = "delShop/{shopId}/{prodId}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delShops(@PathVariable(value = "shopId") int shopId,@PathVariable(value = "prodId") int prodId) {
		Long shopid = (long) shopId;
		Long prodid = (long) prodId;
		return ss.deleteByPrimaryKey(shopid, prodid) > 0;
	}
	
	/**
	 * 批量删除的方法
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "delShops/{shopId}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delShops(HttpServletRequest request,  @PathVariable(value = "shopId") int shopId) throws IOException {
		Long shopid = (long) shopId;
		ServletInputStream inputStream = request.getInputStream();
		@SuppressWarnings("deprecation")
		String prodsid = IOUtils.toString(inputStream);
		JSONArray jsonarr = new JSONArray();
		jsonarr.add(prodsid);
		JSONArray jsonarrs = (JSONArray) jsonarr.get(0);
		List<Integer> prod_id = new ArrayList<Integer>();
		for (int i = 0; i < jsonarrs.size(); i++) {
			prod_id.add(((JSONObject) jsonarrs.get(i)).getInt("prod_id"));
		}
		boolean flag = ss.deleteShops(shopid, prod_id) > 0;
		return flag;
	}
	
	/**
	 * 清空购物车
	 * @param shopid
	 * @param prodid
	 * @return
	 */
	@RequestMapping(value = "delAll/{shopId}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delAll(@PathVariable(value = "shopId") int shopId) {
		Long shopid = (long) shopId;
		return ss.deleteAll(shopid) > 0;
	}
	
	/**
	 * 修改购物车中的商品
	 * @param shopid
	 * @param prodid
	 * @param unitprice
	 * @param disprice
	 * @param qty
	 * @param buy
	 * @param prototamt
	 * @return
	 */
	@RequestMapping(value = "updShops/{shopId}/{prodId}/{Qty}/{protoTamt}", method = RequestMethod.PUT)
	@ResponseBody
	public boolean updShops(@PathVariable(value = "shopId") int shopId, @PathVariable(value = "prodId") int prodId, 
			@PathVariable(value = "Qty") int Qty, @PathVariable(value = "protoTamt") double protoTamt) {
		Long shopid = (long) shopId;
		Long prodid = (long) prodId;
		Integer qty = Qty;
		Double prototamt = protoTamt;
		Shops record = new Shops(shopid, prodid, qty, prototamt);
		return ss.updateByPrimaryKey(record) > 0;
	}
	
}
