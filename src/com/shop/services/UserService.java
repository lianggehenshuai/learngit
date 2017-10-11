package com.shop.services;

import com.shop.dao.UsersDao;
import com.shop.entity.UsersBean;
import com.shop.utils.DaoFac;

/**
 * �˻�service��
 * @author Yy
 *
 */
public class UserService {

	UsersDao ud = DaoFac.getInstance("UsersDao", UsersDao.class);
	/**
	 * ����˻�
	 */
	public UsersBean addUsers(UsersBean ub)
	{
		return ud.addUser(ub);
	}
	/**
	 * ��¼�˻�
	 */
	public Boolean loginUser(UsersBean ub)
	{
		return ud.queryUser(ub);
	}
}
