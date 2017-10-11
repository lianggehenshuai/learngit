package com.shop.entity;

import java.io.Serializable;



/**
 * ��װ��Ʒ��
 * @author Administrator
 *
 */
public class ProductBean implements Serializable {


	private static final long serialVersionUID = 1L;

	public ProductBean() {
		
	}
	




	/**
	 * ��Ʒ���
	 */
	private int id;
	
	/**
	 * ��Ʒ����
	 */
	private String  pnamme;
	
	/**
	 * ���
	 */
	private int cid;
	
	/**
	 * ��Ʒ����
	 */
	private String pno;
	
	/**
	 * ��ƷͼƬ��ַ
	 */
	private String pic;
	
	/**
	 * ��Ʒ�۸�
	 */
	private double price;
	
	/**
	 * ��Ʒ�Ƿ�����1:����0
	 */
	private int online;
	
	/**
	 * ��Ʒ����
	 */
	private String pdetail;
	
	/**
	 * ����
	 * @return
	 */
	private int counts;
	
	

	public ProductBean(int id, String pnamme, double price, int counts) {
		super();
		this.id = id;
		this.pnamme = pnamme;
		this.price = price;
		this.counts = counts;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPnamme() {
		return pnamme;
	}

	public void setPnamme(String pnamme) {
		this.pnamme = pnamme;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public String getPdetail() {
		return pdetail;
	}

	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}

	public ProductBean(String pnamme, int cid, String pno, String pic, double price, int online, String pdetail) {
		super();
		this.pnamme = pnamme;
		this.cid = cid;
		this.pno = pno;
		this.pic = pic;
		this.price = price;
		this.online = online;
		this.pdetail = pdetail;
	}

	
	public ProductBean(int id, String pnamme, int cid, String pno, String pic, double price, int online,
			String pdetail) {
		super();
		this.id = id;
		this.pnamme = pnamme;
		this.cid = cid;
		this.pno = pno;
		this.pic = pic;
		this.price = price;
		this.online = online;
		this.pdetail = pdetail;
	}

	@Override
	public String toString() {
		return "ProductBean [id=" + id + ", pnamme=" + pnamme + ", cid=" + cid + ", pno=" + pno + ", pic=" + pic
				+ ", price=" + price + ", online=" + online + ", pdetail=" + pdetail + ", counts=" + counts + "]";
	}

	

	
}
