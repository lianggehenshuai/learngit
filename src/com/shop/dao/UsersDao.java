package com.shop.dao;

import com.shop.entity.UsersBean;

/**
 * 账户dao层
 * @author Yy
 *
 */
public interface UsersDao {

	/**
	 * 添加账户
	 */
	public UsersBean addUser(UsersBean ub);
	
	/**
	 * 根据用户名和密码进行查询
	 */
	
	public Boolean queryUser(UsersBean ub);
}
