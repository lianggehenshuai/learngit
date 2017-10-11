package com.shop.dao;

import java.util.Map;

import com.shop.entity.PageModel;
import com.shop.entity.ProductBean;
import com.shop.utils.PersonalException;



/**
 * ��Ʒdao��
 * @author Administrator
 *
 */
public interface ProductDao {

	
	/**
	 * �����Ʒ
	 * @param pd
	 * @return
	 * @throws PerException
	 */
	public Boolean addPro(ProductBean pb)throws PersonalException;
	
	
	/**
	 * ��ҳ��ѯ��Ʒ
	 * @param pageNo
	 * @param pageSize
	 * ��ѯ��Ʒ
	 */
	public PageModel<ProductBean> queryPro(int pageNo,int pageSize)throws PersonalException;
	
	
	/**
	 * ������Ʒ���Ʋ�ѯ��Ʒ����ҳ
	 */
	public PageModel<ProductBean> queryProByName(String pname)throws PersonalException;
	
	/**
	 * ����id��ѯ��Ʒ
	 */
	public ProductBean queryProById(int id)throws PersonalException;
	
	/**
	 * ����������ȡ��Ʒ���
	 */
	
	public Map<Integer, String> getTypeList();
	
	
	public Map<Integer, String> getTypeById(int id);
	
	
	/**
	 * �޸���Ʒ
	 */
	public Boolean updatePro(ProductBean pb)throws PersonalException;
	
	/**
	 * ɾ����Ʒ
	 */
	public Boolean delPro(int id)throws PersonalException;
}
