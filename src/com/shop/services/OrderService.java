package com.shop.services;

import com.shop.dao.OrderDao;
import com.shop.entity.OrderBean;
import com.shop.entity.Product_orderInfo;
import com.shop.utils.DaoFac;

public class OrderService {
/**
 * ����service��
 */
	OrderDao od = DaoFac.getInstance("OrderDao", OrderDao.class);
	public OrderService() {
		
	}

	/*
	 * ��Ӷ�����Ϣ
	 */
	public Boolean addOrderInfo(OrderBean ob)
	{
		return od.addOrderInfo(ob);
	}
	/*
	 * ��Ӹ���
	 */
	public Boolean addProAndOrd(Product_orderInfo pd)
	{
		return od.addSAndOid(pd);
	}
}
