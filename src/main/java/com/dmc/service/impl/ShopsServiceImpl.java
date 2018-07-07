package com.dmc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmc.dao.ShopsMapper;
import com.dmc.entity.Shops;
import com.dmc.service.ShopsService;

/**
 * ҵ���
 * @author ���� 2018-07-01
 *
 */
@Service(value = "shopsservice")
public class ShopsServiceImpl implements ShopsService {

	@Resource(name = "shopsdao")
	private ShopsMapper sm;
	
	/**
     * ɾ�����ﳵ�е���Ʒ
     * @param shopid
     * @param prodid
     * @return
     */
	public int deleteByPrimaryKey(Long shopid, Long prodid) {
		// TODO Auto-generated method stub
		return sm.deleteByPrimaryKey(shopid, prodid);
	}
	
	/**
     * ����ɾ��
     * @param shopid
     * @param prodid
     * @return
     */
	public int deleteShops(Long shopid, List<Integer> prodid) {
		// TODO Auto-generated method stub
		return sm.deleteShops(shopid, prodid);
	}

	/**
     * ��չ��ﳵ
     * @param shopid
     * @return
     */
	public int deleteAll(Long shopid) {
		// TODO Auto-generated method stub
		return sm.deleteAll(shopid);
	}

	/**
     * ���ӹ��ﳵ�е���Ʒ
     * @param record
     * @return
     */
	public int insert(Shops record) {
		// TODO Auto-generated method stub
		return sm.insert(record);
	}

	/**
     * ��ѯ���ﳵ�е���Ʒ
     * @param shopid
     * @return
     */
	public List<Shops> selectByPrimaryKey(Long shopid, Long prodid) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(shopid, prodid);
	}

	/**
     * ��ѯ���ﳵ���е���������
     * @return
     */
	public List<Shops> selectAll() {
		// TODO Auto-generated method stub
		return sm.selectAll();
	}

	/**
     * ��ȡ��Ʒ���ܼ�
     * @param shopid
     * @param prodid
     * @return
     */
	public double selectAllSum(Long shopid, List<String> prodid) {
		// TODO Auto-generated method stub
		return sm.selectAllSum(shopid, prodid);
	}
	
	/**
     * ���¹��ﳵ�е���Ʒ
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Shops record) {
		// TODO Auto-generated method stub
		return sm.updateByPrimaryKey(record);
	}

}
