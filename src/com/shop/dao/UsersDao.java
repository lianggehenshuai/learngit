package com.shop.dao;

import com.shop.entity.UsersBean;

/**
 * �˻�dao��
 * @author Yy
 *
 */
public interface UsersDao {

	/**
	 * ����˻�
	 */
	public UsersBean addUser(UsersBean ub);
	
	/**
	 * �����û�����������в�ѯ
	 */
	
	public Boolean queryUser(UsersBean ub);
}
