package com.shop.dao;

import com.shop.entity.OrderBean;
import com.shop.entity.Product_orderInfo;
import com.shop.utils.PersonalException;

/**
 * ����dao��
 * @author Administrator
 */
public interface OrderDao {

	/**
	 * ��Ӷ�����Ϣ
	 */
	public Boolean addOrderInfo(OrderBean ob)throws PersonalException;
	
	/**
	 * ���������Ʒid�Ͷ���id
	 */
	public Boolean addSAndOid(Product_orderInfo po)throws PersonalException;
}
