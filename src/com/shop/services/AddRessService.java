package com.shop.services;

import java.util.List;

import com.shop.dao.AddressDao;
import com.shop.entity.AddressBean;
import com.shop.utils.DaoFac;

/**
 * ��ַҵ���
 * @author Administrator
 *
 */
public class AddRessService {

	public AddRessService() {
		// TODO Auto-generated constructor stub
	}
	AddressDao ad = DaoFac.getInstance("AddressDao", AddressDao.class);
	
	/**
	 * ��ӵ�ַ
	 * @param ab
	 * @return
	 */
	public Boolean addAddress(AddressBean ab)
	{
		return ad.addAddress(ab);
	}
	
	/**
	 * ��ѯ��ַ
	 * @return
	 */
	
	public List<AddressBean> queryAdd()
	{
		return ad.queryAdd();
	}
	
	
	/**
	 * ����ʡ�ݲ�ѯ��ַ
	 */
	public List<AddressBean> queryAdd(String provience)
	{
		return ad.queryAdd(provience);
	}
	
	/**
	 * ���ݳ��в�ѯ��ַ
	 */
	public List<AddressBean> queryAddByCity(String city)
	{
		return ad.queryAddByCity(city);
	}
}
