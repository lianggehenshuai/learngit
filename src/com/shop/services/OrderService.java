package com.shop.services;

import com.shop.dao.OrderDao;
import com.shop.entity.OrderBean;
import com.shop.entity.Product_orderInfo;
import com.shop.utils.DaoFac;

public class OrderService {
/**
 * 订单service层
 */
	OrderDao od = DaoFac.getInstance("OrderDao", OrderDao.class);
	public OrderService() {
		
	}

	/*
	 * 添加订单信息
	 */
	public Boolean addOrderInfo(OrderBean ob)
	{
		return od.addOrderInfo(ob);
	}
	/*
	 * 添加副表
	 */
	public Boolean addProAndOrd(Product_orderInfo pd)
	{
		return od.addSAndOid(pd);
	}
}
