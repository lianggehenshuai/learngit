package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 买家收货信息实现类
 */
import com.shop.dao.CusGoodsDao;
import com.shop.entity.CustGoodsBean;
import com.shop.utils.ConnectionFac;
import com.shop.utils.PersonalException;

public class CusGoodsDaoImpl implements CusGoodsDao {

	QueryRunner qr = new QueryRunner();
	public CusGoodsDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 添加买家收货地址
	 */
	@Override
	public CustGoodsBean addCusGoods(CustGoodsBean cb) throws PersonalException {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String sql = "insert into aonsumer_addr(name,addr,phone,provice,city,area,allAddr) values(?,?,?,?,?,?,?)";
		ResultSetHandler<Long> rsh = new ScalarHandler<>();
		Object obj[] = {cb.getName(),cb.getAddr(),cb.getPhone(),cb.getProvice(),cb.getCity(),cb.getArea(),cb.getAllAddr()};
		try {
			int val = qr.insert(conn, sql, rsh, obj).intValue();
			if(val>0)
			{
				return new CustGoodsBean(cb.getName(),cb.getAddr(),cb.getPhone(),cb.getProvice(),cb.getCity(),cb.getArea(),cb.getAllAddr());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonalException("添加地址失败", e);
		}finally
		{
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	/*	 public static void main(String[] args) {
			System.out.println(new CusGoodsDaoImpl().addCusGoods(new CustGoodsBean("尹浩亮","山西省","1326464646","晋中市","寿阳县","河底村","16")));
		}*/

		 /**
		  * 查询收货地址根据名字
		  */
		@Override
		public CustGoodsBean queryCus(String name) throws PersonalException {
			Connection conn = ConnectionFac.getInstance().getConnection();
			String sql = "select id,name,addr,phone,provice,city,area,allAddr from aonsumer_addr where name=?";
			ResultSetHandler<CustGoodsBean> rsh = new BeanHandler<>(CustGoodsBean.class);
			try {
				CustGoodsBean cgb = qr.query(conn, sql, rsh, name);
				if(cgb!=null)
				{
					return cgb;
				}
			} catch (SQLException e) {
				throw new PersonalException("查询地址失败", e);
			}finally
			{
				DbUtils.closeQuietly(conn);
			}
			return null;
		}
		public static void main(String[] args) {
			System.out.println(new CusGoodsDaoImpl().queryCus("李华栋"));
		}
}
