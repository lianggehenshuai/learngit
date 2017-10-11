package com.shop.entity;

/**
 * �˻�ʵ����
 * @author Yy
 * 	id     int  primary key auto_increment,
	loginname varchar(50) not null,
	password varchar(50),
	registertime bigint, -- ע��ʱ��
	lastLogintime bigint,  -- ����¼ʱ��
	ip            varchar(20) -- ip��ַ
	
 */
public class UsersBean {

	private int id;
	
	private String loginname;
	
	private String password;
	
	private long registertime;
	
	private long lastLogintime;
	
	private String ip;
	
	public UsersBean() {
		
	}

	
	
	public UsersBean(String loginname, String password) {
		super();
		this.loginname = loginname;
		this.password = password;
	}



	public UsersBean(int id, String loginname, String password, long registertime, long lastLogintime, String ip) {
		super();
		this.id = id;
		this.loginname = loginname;
		this.password = password;
		this.registertime = registertime;
		this.lastLogintime = lastLogintime;
		this.ip = ip;
	}
	
	public UsersBean(String loginname, String password, long registertime, long lastLogintime, String ip) {
		super();
		this.loginname = loginname;
		this.password = password;
		this.registertime = registertime;
		this.lastLogintime = lastLogintime;
		this.ip = ip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRegistertime() {
		return registertime;
	}

	public void setRegistertime(long registertime) {
		this.registertime = registertime;
	}

	public long getLastLogintime() {
		return lastLogintime;
	}

	public void setLastLogintime(long lastLogintime) {
		this.lastLogintime = lastLogintime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "�˻���ϢΪ: [id=" + id + ", loginname=" + loginname + ", password=" + password + ", registertime="
				+ registertime + ", lastLogintime=" + lastLogintime + ", ip=" + ip + "]";
	}
}
