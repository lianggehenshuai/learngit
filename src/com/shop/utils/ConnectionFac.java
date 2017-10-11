package com.shop.utils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ��ȡ���ݿ�����
 * ���ӳ�
 * */
public final class ConnectionFac {
	//ʹ�õ���ģʽ�������ݿ����ӳ�
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
        dataSource.setDriverClass(ps.getProperty("driver"));//��������
        dataSource.setJdbcUrl(ps.getProperty("url"));//���ݿ��ַ
        dataSource.setUser(ps.getProperty("user"));		//�û���
        dataSource.setPassword(ps.getProperty("password")); //����
        dataSource.setInitialPoolSize(5); //��ʼ��������
        dataSource.setMinPoolSize(1);//��С������
        dataSource.setMaxPoolSize(10);//���������
        dataSource.setMaxStatements(50);//��ȴ�ʱ��
        dataSource.setMaxIdleTime(60);//������ʱ�䣬��λ����
    }
    //��ȡʵ��
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
    //��ȡ����
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
					conn.setAutoCommit(false); //�ֶ��ύ
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