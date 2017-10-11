package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import com.shop.dao.OrderDao;
import com.shop.entity.OrderBean;
import com.shop.entity.Product_orderInfo;
import com.shop.utils.ConnectionFac;
import com.shop.utils.PersonalException;

public class OrderDaoImpl implements OrderDao {

	QueryRunner qr = new QueryRunner();
	public OrderDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addOrderInfo(OrderBean ob)throws PersonalException {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String sql = "insert into orderinfo(orderno,orderstatus,paystatus,ordertime,paytime,addrinfo,mash)values(?,?,?,?,?,?,?)";
		ResultSetHandler<Long> rsh = new ScalarHandler<>();
		Object obj[] = {ob.getOrderNo(),ob.getOrderstatus(),ob.getPaystatus(),ob.getOrdertime(),ob.getPaytime(),ob.getAddrinfo(),ob.getMash()};
		try {
			int val = qr.insert(conn, sql, rsh, obj).intValue();
			if(val>0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonalException("添加订单失败", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}

	
/*	 public static void main(String[] args) {
		System.out.println(new OrderDaoImpl().addOrderInfo(new OrderBean("sss", 1, 2, 13131, 145646, 22, "ssss")));
	}*/

	@Override
	public Boolean addSAndOid(Product_orderInfo po) throws PersonalException {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String sql = "insert into product_orderInfo(orderid,productid) values(?,?)";
	/*	ResultSetHandler<Long> rsh = new ScalarHandler<>();*/
		PreparedStatement pstmt = null;
	/*	ResultSet rs = null;*/
		try {
		/*	long val = qr.insert(conn, sql, rsh, po.getOrderid(),po.getProductid());*/
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, po.getOrderid());
			pstmt.setInt(2, po.getProductid());
			int val = pstmt.executeUpdate();
			if(val>0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonalException("添加副表失败", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return false;
}
	public static void main(String[] args) {
		System.out.println(new OrderDaoImpl().addSAndOid(new Product_orderInfo(10,2)));
	}
}