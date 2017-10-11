package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.shop.dao.UsersDao;
import com.shop.entity.UsersBean;
import com.shop.utils.ConnectionFac;
import com.shop.utils.PersonalException;

/**
 * 账户实现层
 * @author Yy
 *
 */
public class UsersDaoImpl implements UsersDao {

	QueryRunner qr = new QueryRunner();
	/**
	 * 添加账户
	 */
	@Override
	public UsersBean addUser(UsersBean ub) {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String sql = "insert into account_consume(loginname,password,registertime,lastLogintime,ip)values(?,?,?,?,?)";
		ResultSetHandler<Long> rsh = new ScalarHandler<>();
		Object[] obj = {ub.getLoginname(),ub.getPassword(),ub.getRegistertime(),ub.getLastLogintime(),ub.getIp()};
		try {
			int result = qr.insert(conn, sql, rsh, obj).intValue();
			if(result>0)
			{
				UsersBean user =new UsersBean(ub.getLoginname(), ub.getPassword(), ub.getRegistertime(), ub.getLastLogintime(), ub.getIp());
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonalException("注册失败", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
/*public static void main(String[] args) {
	System.out.println(new UsersDaoImpl().addUser(new UsersBean("liangge", "111111", 56566446, 56545466, "10.25.151.170")));
}*/
/**
 * 根据用户名和密码进行查询
 */
@Override
public Boolean queryUser(UsersBean ub) {
	Connection conn = ConnectionFac.getInstance().getConnection();
	String sql = "select * from account_consume where loginname=? and password = ?";
	ResultSetHandler<UsersBean> rsh = new BeanHandler<>(UsersBean.class);
	try {
	
		UsersBean user = qr.query(conn, sql, rsh, ub.getLoginname(),ub.getPassword());
		if(user!=null)
		{
			return true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		throw new PersonalException("登录失败", e);
	}finally
	{
		DbUtils.closeQuietly(conn);
	}
	return false;
}
public static void main(String[] args) {
	System.out.println(new UsersDaoImpl().queryUser(new UsersBean("ssssss", "1111")));
}
}
