package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.shop.dao.ProductDao;
import com.shop.entity.PageModel;
import com.shop.entity.ProductBean;
import com.shop.utils.ConnectionFac;
import com.shop.utils.PersonalException;



public class ProDaoImpl implements ProductDao {

	QueryRunner qr = new QueryRunner();
	public ProDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 添加商品方法
	 */
	@Override
	public Boolean addPro(ProductBean pb) throws PersonalException {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String  sql = "insert into product(pnamme,cid,pno,pic,price,online,pdetail)values(?,?,?,?,?,?,?)";
		ResultSetHandler<Long> rsh = new ScalarHandler<Long>();
		Object[] params ={pb.getPnamme(),pb.getCid(),pb.getPno(),pb.getPic(),pb.getPrice(),pb.getOnline(),pb.getPdetail()};
		try {
			int result = qr.insert(conn, sql, rsh, params).intValue();
			if(result>0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new  PersonalException("添加商品出错",e);
		} finally
		{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}
	
	
	/**
	 * 二级联动
	 * 读取xml
	 * 取得区域
	 * @return
	 */
	 public Map<Integer, String> getTypeList() {
		 return getTypeById(0);
	 }
	 
	 /**
	  * 根据pid获得类别
	  * @param id
	  * @return
	  */
	 public Map<Integer, String> getTypeById(int id) {
		 String sql = "select cid, cname from cate  where pid=?";
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 Connection conn = null;
		Map<Integer, String> map = new HashMap();
		 try {
			 conn = 	ConnectionFac.getInstance().getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, id);
			 rs = pstmt.executeQuery();
			 while (rs.next()) {
				 map.put(rs.getInt("cid"), rs.getString("cname"));
			 }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 DbUtils.closeQuietly(conn, pstmt, rs);
		 }
		 return map;
	 }
/*	public static void main(String[] args) {
		Map<Integer,String> m = new ProDaoImpl().getRegionList();
		for (Map.Entry<Integer, String> entry : m.entrySet()) {  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		}  
}*/
/*	public static void main(String[] args) {
		System.out.println(new ProDaoImpl().addPro(new ProductBean("卡通小片2",29,"a0002","images/icon002.png",100.00,0,"卡通图片真好玩")));
	}*/

	 
		/**
		 * 分页查询商品
		 * @param pageNo
		 * @param pageSize
		 * 查询商品
		 */
	@Override
	public PageModel<ProductBean> queryPro(int pageNo, int pageSize) throws PersonalException {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String countSql = "select count(id) from product";
		ResultSetHandler<Long> rsh = new ScalarHandler<>();
		PageModel<ProductBean> pm = new PageModel<>();
		try {
			int counts = qr.query(conn, countSql, rsh).intValue();
			if(counts>0)
			{
				pm.setCounts(counts);
				String sql = "select id,pnamme,cid,pno,pic,price,online,pdetail from product order by id limit ?,?";
				ResultSetHandler<List<ProductBean>> rs = new BeanListHandler<>(ProductBean.class);
				List<ProductBean> list = qr.query(conn, sql, rs, (pageNo-1)*pageSize,pageSize);
				pm.setPageInfo(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonalException("查询出错", e);
		}finally {
			 DbUtils.closeQuietly(conn);
		 }
		return pm;
	}
	public static void main33(String[] args) {
		PageModel<ProductBean> pm = new ProDaoImpl().queryPro(1, 2);
		List li = pm.getPageInfo();
		System.out.println(li.toString());
	}

	/**
	 * 根据商品id查询商品
	 */
	public ProductBean queryProById(int id)throws PersonalException
	{
		Connection conn = ConnectionFac.getInstance().getConnection();
		String sql  = "select * from product where id=?";
		ResultSetHandler<ProductBean> rsh = new BeanHandler<>(ProductBean.class);
		try {
			ProductBean pb = qr.query(conn, sql, rsh, id);
			if(pb!=null)
			{
				return pb;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonalException("查询出错", e);
		}finally {
			DbUtils.closeQuietly(conn);
		 }
		return null;
	}
	
	/**
	 * 修改商品
	 */
		@Override
		public Boolean updatePro(ProductBean pb) throws PersonalException {
			Connection conn = ConnectionFac.getInstance().getConnection();
			String sql = "update product set pnamme=?,cid=?,pno=?,pic=?,price=?,online=?,pdetail=? where id=? ";
			//ResultSetHandler<Long> rs = new ScalarHandler<Long>();
			Object[] obj = {pb.getPnamme(),pb.getCid(),pb.getPno(),pb.getPic(),pb.getPrice(),pb.getOnline(),pb.getPdetail(),pb.getId()};
			
			try {
				int result = qr.update(conn, sql, obj);
				if(result>0)
				{
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally
			{
				DbUtils.closeQuietly(conn);
			}
			return false;
		}

	@Override
	public Boolean delPro(int id) throws PersonalException {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String sql = "delete from product where id=?";
		try {
			int result = qr.update(conn, sql, id);
			if(result>0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		 }
		return false;
	}

	@Override
	public PageModel<ProductBean> queryProByName(String pname) throws PersonalException {
		Connection conn = ConnectionFac.getInstance().getConnection();
		String countSql = "select count(id) from product";
		ResultSetHandler<Long> rsh = new ScalarHandler<>();
		PageModel<ProductBean> pm = new PageModel<>();
		try {
			int counts = qr.query(conn, countSql, rsh).intValue();
			if(counts>0)
			{
				pm.setCounts(counts);
				String sql = "select id,pnamme,cid,pno,pic,price,online,pdetail from product  where pnamme like '%' ? '%' ";
				ResultSetHandler<List<ProductBean>> rs = new BeanListHandler<>(ProductBean.class);
				List<ProductBean> list = qr.query(conn, sql, rs,pname);
				pm.setPageInfo(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonalException("查询出错", e);
		}finally {
			 DbUtils.closeQuietly(conn);
		 }
		return pm;
	}
    public static void main(String[] args) {
		PageModel<ProductBean> pm = new ProDaoImpl().queryProByName("保");
		System.out.println(pm.getPageInfo());
	}
}
