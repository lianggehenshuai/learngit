package com.shop.dao;

import java.util.Map;

import com.shop.entity.PageModel;
import com.shop.entity.ProductBean;
import com.shop.utils.PersonalException;



/**
 * 商品dao层
 * @author Administrator
 *
 */
public interface ProductDao {

	
	/**
	 * 添加商品
	 * @param pd
	 * @return
	 * @throws PerException
	 */
	public Boolean addPro(ProductBean pb)throws PersonalException;
	
	
	/**
	 * 分页查询商品
	 * @param pageNo
	 * @param pageSize
	 * 查询商品
	 */
	public PageModel<ProductBean> queryPro(int pageNo,int pageSize)throws PersonalException;
	
	
	/**
	 * 根据商品名称查询商品并分页
	 */
	public PageModel<ProductBean> queryProByName(String pname)throws PersonalException;
	
	/**
	 * 根据id查询商品
	 */
	public ProductBean queryProById(int id)throws PersonalException;
	
	/**
	 * 二级联动读取商品类别
	 */
	
	public Map<Integer, String> getTypeList();
	
	
	public Map<Integer, String> getTypeById(int id);
	
	
	/**
	 * 修改商品
	 */
	public Boolean updatePro(ProductBean pb)throws PersonalException;
	
	/**
	 * 删除商品
	 */
	public Boolean delPro(int id)throws PersonalException;
}
