package com.shop.services;

import java.util.List;

import com.shop.dao.AddressDao;
import com.shop.entity.AddressBean;
import com.shop.utils.DaoFac;

/**
 * 地址业务层
 * @author Administrator
 *
 */
public class AddRessService {

	public AddRessService() {
		// TODO Auto-generated constructor stub
	}
	AddressDao ad = DaoFac.getInstance("AddressDao", AddressDao.class);
	
	/**
	 * 添加地址
	 * @param ab
	 * @return
	 */
	public Boolean addAddress(AddressBean ab)
	{
		return ad.addAddress(ab);
	}
	
	/**
	 * 查询地址
	 * @return
	 */
	
	public List<AddressBean> queryAdd()
	{
		return ad.queryAdd();
	}
	
	
	/**
	 * 根据省份查询地址
	 */
	public List<AddressBean> queryAdd(String provience)
	{
		return ad.queryAdd(provience);
	}
	
	/**
	 * 根据城市查询地址
	 */
	public List<AddressBean> queryAddByCity(String city)
	{
		return ad.queryAddByCity(city);
	}
}
