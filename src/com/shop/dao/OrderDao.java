package com.shop.dao;

import com.shop.entity.OrderBean;
import com.shop.entity.Product_orderInfo;
import com.shop.utils.PersonalException;

/**
 * 订单dao层
 * @author Administrator
 */
public interface OrderDao {

	/**
	 * 添加订单信息
	 */
	public Boolean addOrderInfo(OrderBean ob)throws PersonalException;
	
	/**
	 * 副表添加商品id和订单id
	 */
	public Boolean addSAndOid(Product_orderInfo po)throws PersonalException;
}
