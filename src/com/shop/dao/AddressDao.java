package com.shop.dao;

import java.util.List;

import com.shop.entity.AddressBean;
import com.shop.utils.PersonalException;

/**
 * 地址dao层
 * @author Administrator
 *
 */
public interface AddressDao {

	/**
	 * 添加地址
	 * @param ab
	 * @return
	 */
	public Boolean addAddress(AddressBean ab)throws PersonalException;
	
	/**
	 * 查询地址
	 * @return
	 */
	public List<AddressBean> queryAdd()throws PersonalException;
	
	/**
	 * 根据省份查询
	 **/
	public List<AddressBean> queryAdd(String provience)throws PersonalException;
	
	/**
	 * 根据区县查询
	 **/
	public List<AddressBean> queryAddByCity(String city)throws PersonalException;
}
