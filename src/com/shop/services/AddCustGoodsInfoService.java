package com.shop.services;

import com.shop.dao.CusGoodsDao;
import com.shop.entity.CustGoodsBean;
import com.shop.utils.DaoFac;

/**
 * �������ջ���Ϣ
 * @author Administrator
 */
public class AddCustGoodsInfoService {

	CusGoodsDao cd = DaoFac.getInstance("CusGoodsDao", CusGoodsDao.class);
	public AddCustGoodsInfoService() {
		
	}
	/*
	 * ����ջ���ַ
	 */
	public CustGoodsBean addCust(CustGoodsBean cgb)
	{
		return cd.addCusGoods(cgb);
	}
	/*
	 * ��ѡ�ջ���ַ��������
	 */
	public CustGoodsBean queryCust(String name)
	{
		return cd.queryCus(name);
	}
}
