package com.shop.dao;

import com.shop.entity.CustGoodsBean;
import com.shop.utils.PersonalException;

/**
 * 
 * @author Administrator
 * 添加买家收货地址
 * 
 */
public interface CusGoodsDao {

	/**
	 * 添加收货地址
	 * @param cb
	 * @return
	 * @throws PersonalException
	 */
	public CustGoodsBean addCusGoods(CustGoodsBean cb)throws PersonalException;
	
	/**
	 * 查询收货地址
	 * 根据姓名
	 */
	public CustGoodsBean queryCus(String name)throws PersonalException;
}
