package com.shop.dao;

import com.shop.entity.CustGoodsBean;
import com.shop.utils.PersonalException;

/**
 * 
 * @author Administrator
 * �������ջ���ַ
 * 
 */
public interface CusGoodsDao {

	/**
	 * ����ջ���ַ
	 * @param cb
	 * @return
	 * @throws PersonalException
	 */
	public CustGoodsBean addCusGoods(CustGoodsBean cb)throws PersonalException;
	
	/**
	 * ��ѯ�ջ���ַ
	 * ��������
	 */
	public CustGoodsBean queryCus(String name)throws PersonalException;
}
