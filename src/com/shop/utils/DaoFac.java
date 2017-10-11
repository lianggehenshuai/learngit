package com.shop.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ͨ����ȡ�����ļ���ʵ����ʵ�������
 */

public class DaoFac {

	//���췽��˽�л�
	private DaoFac() {
	}

	//��̬ʵ���������ļ�
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
	 * ͨ������ͷ��ͣ���ȡʵ�����ʵ��
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String daoName, Class<T> cls) {
		T t = null;
		//�ǿ��ж�
		if (null == daoName || "".equals(daoName)) {
			return t;
		}
		String className = ps.getProperty(daoName);
		//�ǿ��ж�
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
