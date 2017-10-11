package com.shop.entity;

/**
 * -- ����ջ���Ϣ��
create table aonsumer_addr(
	id    int     primary key auto_increment,
	name  varchar(20)  not null, -- �ջ�������
	addr  varchar(200)   not null, -- �ջ��˵�ַ
	phone  varchar(20)   not null, -- ��ϵ��ʽ
	provice  varchar(20)  ,-- ʡ��
	city  varchar(20), -- ��
	area varchar(40),  -- ��/��
	allAddr  varchar(200) -- ��ϸ��Ϣ
 * @author Administrator
 */
public class CustGoodsBean {

	public CustGoodsBean() {
		
	}
	private int id;
	
	private String name;
	
	private String addr;
	
	private String phone;
	
	private String provice;
	
	private String city;
	
	private String area;
	
	private String allAddr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvice() {
		return provice;
	}

	public void setProvice(String provice) {
		this.provice = provice;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAllAddr() {
		return allAddr;
	}

	public void setAllAddr(String allAddr) {
		this.allAddr = allAddr;
	}

	public CustGoodsBean(String name, String addr, String phone, String provice, String city, String area,
			String allAddr) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.provice = provice;
		this.city = city;
		this.area = area;
		this.allAddr = allAddr;
	}

	
	
	public CustGoodsBean(int id, String name, String addr, String phone, String provice, String city, String area,
			String allAddr) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.provice = provice;
		this.city = city;
		this.area = area;
		this.allAddr = allAddr;
	}

	@Override
	public String toString() {
		return "CustGoodsBean [id=" + id + ", name=" + name + ", addr=" + addr + ", phone=" + phone + ", provice="
				+ provice + ", city=" + city + ", area=" + area + ", allAddr=" + allAddr + "]";
	}
	
	
}
