package com.shop.entity;

/**
 * ��Ʒ�Ͷ����м�ʵ����
 * @author Administrator
 *  orderid  int ,-- ����id ֵ����orderinfo���е�id
	productid int  , -- ��Ʒid��ֵ������product���е�id
	primary key(orderid,productid) -- ��������
 * 
 */
public class Product_orderInfo {

	public Product_orderInfo() {
		
	}

	private int orderid;
	
	private int productid;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Override
	public String toString() {
		return "Product_orderInfo [orderid=" + orderid + ", productid=" + productid + "]";
	}

	public Product_orderInfo(int orderid, int productid) {
		super();
		this.orderid = orderid;
		this.productid = productid;
	}
}
