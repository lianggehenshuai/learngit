package com.shop.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 通过读取配置文件，实例化实现类对象
 */

public class DaoFac {

	//构造方法私有化
	private DaoFac() {
	}

	//静态实例化配置文件
	private static Properties ps = new Properties();

	static {

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过反射和泛型，获取实现类的实例
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String daoName, Class<T> cls) {
		T t = null;
		//非空判断
		if (null == daoName || "".equals(daoName)) {
			return t;
		}
		String className = ps.getProperty(daoName);
		//非空判断
		if (className == null || "".equals(className)) {
			return t;
		}
		try {
			Class<?> clazz = Class.forName(className);
			t = (T) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return t;
	}
}
