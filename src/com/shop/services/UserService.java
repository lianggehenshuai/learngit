package com.shop.services;

import com.shop.dao.UsersDao;
import com.shop.entity.UsersBean;
import com.shop.utils.DaoFac;

/**
 * 账户service层
 * @author Yy
 *
 */
public class UserService {

	UsersDao ud = DaoFac.getInstance("UsersDao", UsersDao.class);
	/**
	 * 添加账户
	 */
	public UsersBean addUsers(UsersBean ub)
	{
		return ud.addUser(ub);
	}
	/**
	 * 登录账户
	 */
	public Boolean loginUser(UsersBean ub)
	{
		return ud.queryUser(ub);
	}
}
