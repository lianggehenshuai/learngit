package com.shop.entity;

/**
 * -- 地址表,供客户选择
create table address(
	id      int    primary key auto_increment,
	provience varchar(20)    not null,  -- 省份
	city      varchar(40)    not null,   -- 城市
	area      varchar(40)    not null  -- 区/县
);
 * @author Administrator
 *
 */
public class AddressBean {

	public AddressBean() {
		
	}
    private int id;
    
    private String provience;
    
    private String city;
    
    private String area;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvience() {
		return provience;
	}

	public void setProvience(String provience) {
		this.provience = provience;
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

	public AddressBean(int id, String provience, String city, String area) {
		super();
		this.id = id;
		this.provience = provience;
		this.city = city;
		this.area = area;
	}

	public AddressBean(String provience, String city, String area) {
		super();
		this.provience = provience;
		this.city = city;
		this.area = area;
	}

	@Override
	public String toString() {
		return "AddressBean [id=" + id + ", provience=" + provience + ", city=" + city + ", area=" + area + "]";
	}
    
    
    
    
}
