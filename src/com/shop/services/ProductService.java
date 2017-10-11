package com.shop.services;

import com.shop.dao.ProductDao;
import com.shop.entity.PageModel;
import com.shop.entity.ProductBean;
import com.shop.utils.DaoFac;

/**
 * ��Ʒҵ���߼�
 * @author Administrator
 *
 */
public class ProductService {

	
	ProductDao pd = DaoFac.getInstance("proDao", ProductDao.class);
	public ProductService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * �����Ʒҵ���߼�
	 * @param pb
	 * @return
	 */
	public Boolean addPro(ProductBean pb)
	{
		return pd.addPro(pb);
	}
	
	/**
	 * ��ҳ��ѯ��Ʒҵ���߼�
	 */
	public PageModel<ProductBean>  queryPage(int pageNo,int pageSize)
	{
		return pd.queryPro(pageNo,pageSize);
	}
	
	/**
	 * �޸���Ʒ
	 */
	public Boolean upPro(ProductBean pb)
	{
		return pd.updatePro(pb);
	}
	/**
	 * ɾ����Ʒ
	 */
	public Boolean delPro(int id)
	{
		return pd.delPro(id);
	}
	/**
	 * ����id��ѯ��Ʒ
	 */
	public ProductBean queryProById(int id)
	{
		return pd.queryProById(id);
	}
	/**
	 * ģ����ѯ
	 */
	public PageModel<ProductBean> queryProByName(String pname)
	{
		return pd.queryProByName(pname);
	}
}

