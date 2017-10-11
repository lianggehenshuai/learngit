package com.shop.dao;

import java.util.List;

import com.shop.entity.AddressBean;
import com.shop.utils.PersonalException;

/**
 * ��ַdao��
 * @author Administrator
 *
 */
public interface AddressDao {

	/**
	 * ��ӵ�ַ
	 * @param ab
	 * @return
	 */
	public Boolean addAddress(AddressBean ab)throws PersonalException;
	
	/**
	 * ��ѯ��ַ
	 * @return
	 */
	public List<AddressBean> queryAdd()throws PersonalException;
	
	/**
	 * ����ʡ�ݲ�ѯ
	 **/
	public List<AddressBean> queryAdd(String provience)throws PersonalException;
	
	/**
	 * �������ز�ѯ
	 **/
	public List<AddressBean> queryAddByCity(String city)throws PersonalException;
}
