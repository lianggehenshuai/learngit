package com.shop.services;

import com.shop.dao.ProductDao;
import com.shop.entity.PageModel;
import com.shop.entity.ProductBean;
import com.shop.utils.DaoFac;

/**
 * 商品业务逻辑
 * @author Administrator
 *
 */
public class ProductService {

	
	ProductDao pd = DaoFac.getInstance("proDao", ProductDao.class);
	public ProductService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 添加商品业务逻辑
	 * @param pb
	 * @return
	 */
	public Boolean addPro(ProductBean pb)
	{
		return pd.addPro(pb);
	}
	
	/**
	 * 分页查询商品业务逻辑
	 */
	public PageModel<ProductBean>  queryPage(int pageNo,int pageSize)
	{
		return pd.queryPro(pageNo,pageSize);
	}
	
	/**
	 * 修改商品
	 */
	public Boolean upPro(ProductBean pb)
	{
		return pd.updatePro(pb);
	}
	/**
	 * 删除商品
	 */
	public Boolean delPro(int id)
	{
		return pd.delPro(id);
	}
	/**
	 * 根据id查询商品
	 */
	public ProductBean queryProById(int id)
	{
		return pd.queryProById(id);
	}
	/**
	 * 模糊查询
	 */
	public PageModel<ProductBean> queryProByName(String pname)
	{
		return pd.queryProByName(pname);
	}
}

