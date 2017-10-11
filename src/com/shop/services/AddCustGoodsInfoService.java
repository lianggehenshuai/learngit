package com.shop.services;

import com.shop.dao.CusGoodsDao;
import com.shop.entity.CustGoodsBean;
import com.shop.utils.DaoFac;

/**
 * 添加买家收货信息
 * @author Administrator
 */
public class AddCustGoodsInfoService {

	CusGoodsDao cd = DaoFac.getInstance("CusGoodsDao", CusGoodsDao.class);
	public AddCustGoodsInfoService() {
		
	}
	/*
	 * 添加收货地址
	 */
	public CustGoodsBean addCust(CustGoodsBean cgb)
	{
		return cd.addCusGoods(cgb);
	}
	/*
	 * 查选收货地址根据名字
	 */
	public CustGoodsBean queryCust(String name)
	{
		return cd.queryCus(name);
	}
}
