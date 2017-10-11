package com.shop.utils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 获取数据库连接
 * 连接池
 * */
public final class ConnectionFac {
	//使用单例模式创建数据库连接池
    private static ConnectionFac instance;
    private static ComboPooledDataSource dataSource;
    
    static private Properties ps = new Properties();
	static
	{
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("mysql.properties");
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    private ConnectionFac() throws SQLException, PropertyVetoException {
        dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(ps.getProperty("driver"));//加载驱动
        dataSource.setJdbcUrl(ps.getProperty("url"));//数据库地址
        dataSource.setUser(ps.getProperty("user"));		//用户名
        dataSource.setPassword(ps.getProperty("password")); //密码
        dataSource.setInitialPoolSize(5); //初始化连接数
        dataSource.setMinPoolSize(1);//最小连接数
        dataSource.setMaxPoolSize(10);//最大连接数
        dataSource.setMaxStatements(50);//最长等待时间
        dataSource.setMaxIdleTime(60);//最大空闲时间，单位毫秒
    }
    //获取实例
    public static void main(String[] args) {
		System.out.println(ConnectionFac.getInstance().getConnection());
	}
    public static final ConnectionFac getInstance() {
        if (instance == null) {
            try {
                instance = new ConnectionFac();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    //获取连接
    public synchronized final Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    
    public static void beginTransaction(Connection conn) {
		try {
			if (conn != null) {
				if (conn.getAutoCommit()) {
					conn.setAutoCommit(false); //手动提交
				}
			}
		}catch(SQLException e) {}
	}
	
	public static void commitTransaction(Connection conn) {
		try {
			if (conn != null) {
				if (!conn.getAutoCommit()) {
					conn.commit();
				}
			}
		}catch(SQLException e) {}
	}
	
	public static void rollbackTransaction(Connection conn) {
		try {
			if (conn != null) {
				if (!conn.getAutoCommit()) {
					conn.rollback();
				}
			}
		}catch(SQLException e) {}
	}
	
	public static void resetConnection(Connection conn) {
		try {
			if (conn != null) {
				if (conn.getAutoCommit()) {
					conn.setAutoCommit(false);
				}else {
					conn.setAutoCommit(true);
				}
			}
		}catch(SQLException e) {}
	}
}