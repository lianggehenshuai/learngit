package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.shop.dao.AddressDao;
import com.shop.entity.AddressBean;
import com.shop.utils.ConnectionFac;
import com.shop.utils.PersonalException;

/**
 * ��ַdaoʵ����
 * @author Administrator
 *
 */
public class AddressDaoImpl implements AddressDao {

	QueryRunner qr = new  QueryRunner();
	public AddressDaoImpl() {
		
	}

	/**
	 * ��ӵ�ַ
	 * @param ab
	 * @return
	 */
	@Override
	public Boolean addAddress(AddressBean ab)throws PersonalException {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String sql = "insert into address(provience,city,area)values(?,?,?)";
		ResultSetHandler<Long> rsh = new ScalarHandler<>();
		Object obj[] = {ab.getProvience(),ab.getCity(),ab.getArea()};
		try {
			int val = qr.insert(conn, sql, rsh, obj).intValue();
			if(val>0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonalException("��ӵ�ַʧ��", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}
	/*public static void main(String[] args) {
		System.out.println(new AddressDaoImpl().addAddress(new AddressBean("ɽ��ʡ", "������", "��ͻȪ")));
	}*/
	@Override
	public List<AddressBean> queryAdd()throws PersonalException {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String sql = "select id,provience,city,area from address";
		ResultSetHandler<List<AddressBean>> list  = new BeanListHandler<>(AddressBean.class);
		try {
			List<AddressBean> li = qr.query(conn, sql, list);
			if(li!=null)
			{
				return li;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonalException("��ӵ�ַʧ��", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	/*public static void main(String[] args) {
		System.out.println(new AddressDaoImpl().queryAdd());
	}*/

	@Override
	public List<AddressBean> queryAdd(String provience) throws PersonalException {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String sql = "select id,provience,city,area from address where provience=?";
		ResultSetHandler<List<AddressBean>> list  = new BeanListHandler<>(AddressBean.class);
		try {
			List<AddressBean> li = qr.query(conn, sql, list, provience);
			if(li!=null)
			{
				return li;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonalException("��ӵ�ַʧ��", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	/*public static void main(String[] args) {
		System.out.println(new AddressDaoImpl().queryAdd("ɽ��ʡ"));
	}*/
	@Override
	public List<AddressBean> queryAddByCity(String city) throws PersonalException {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String sql = "select id,provience,city,area from address where city=?";
		ResultSetHandler<List<AddressBean>> list  = new BeanListHandler<>(AddressBean.class);
		try {
			List<AddressBean> li = qr.query(conn, sql, list, city);
			if(li!=null)
			{
				return li;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonalException("��ӵ�ַʧ��", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(new AddressDaoImpl().queryAddByCity("������"));
	}
}
