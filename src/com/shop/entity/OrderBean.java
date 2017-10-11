package com.shop.entity;

/**
 * 订单实体类
 * @author Administrator
 *   *	create table orderinfo(
	id  int primary key auto_increment,  -- 订单id
	orderno  varchar(50) not null, -- 订单编号
	orderstatus int ,-- 订单状态  1:未付款2：已付款 3.已发货  4已完成
	paystatus   int,  -- 1.线上支付  2.线下支付  3.平邮
	ordertime bigint ,-- 下单时间
	paytime bigint ,-- 付款时间
	addrinfo  int, -- 收货人信息:引用子aosumer_addr表中的id
	mash     varchar(200) -- 备注信息
);
 * 
 * 
 * 
 */
public class OrderBean {

	public OrderBean() {
		
	}
	private int id;
	
	private String orderNo;
	
	private int orderstatus;
	
	private int paystatus;
	
	private long ordertime;
	
	private long paytime;
	
	private int addrinfo;
	
	private String mash;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}

	public int getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}

	public long getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(long ordertime) {
		this.ordertime = ordertime;
	}

	public long getPaytime() {
		return paytime;
	}

	public void setPaytime(long paytime) {
		this.paytime = paytime;
	}

	public int getAddrinfo() {
		return addrinfo;
	}

	public void setAddrinfo(int addrinfo) {
		this.addrinfo = addrinfo;
	}

	public String getMash() {
		return mash;
	}

	public void setMash(String mash) {
		this.mash = mash;
	}

	@Override
	public String toString() {
		return "OrderBean [id=" + id + ", orderNo=" + orderNo + ", orderstatus=" + orderstatus + ", paystatus="
				+ paystatus + ", ordertime=" + ordertime + ", paytime=" + paytime + ", addrinfo=" + addrinfo + ", mash="
				+ mash + "]";
	}

	
	
	public OrderBean(String orderNo, int orderstatus, int paystatus, long ordertime, long paytime, int addrinfo,
			String mash) {
		super();
		this.orderNo = orderNo;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.ordertime = ordertime;
		this.paytime = paytime;
		this.addrinfo = addrinfo;
		this.mash = mash;
	}

	public OrderBean(int id, String orderNo, int orderstatus, int paystatus, long ordertime, long paytime, int addrinfo,
			String mash) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.ordertime = ordertime;
		this.paytime = paytime;
		this.addrinfo = addrinfo;
		this.mash = mash;
	}
	
	
	
}
