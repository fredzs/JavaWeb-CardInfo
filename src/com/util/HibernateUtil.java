/**
 * 
 */
package com.util;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	// 建Configuration对象
	private static Configuration configuration = new Configuration();
	// 建Session工厂对象
	private static SessionFactory sessionFactory = null;
	private static Logger logger = Logger.getLogger(HibernateUtil.class);
	public static void init(String env) {
		try {
			// 声明Hibernate配置文件所在的路径
			String configFile = "/hibernate/hibernate-";
			if (env.equals("0")) {
				configFile += "test";
			} else if(env.equals("1")) {
				configFile += "test2";
			} else if(env.equals("2")){
				configFile += "test3";
			} else if(env.equals("3")){
				configFile += "dev";
			} else {
				configFile += "info";
			}
			configFile += ".cfg.xml";
			configuration.configure(configFile);
			// 建立一个Session工厂
			sessionFactory = configuration.buildSessionFactory();
			logger.info("初始化SessionFactory,配置文件为：" + configFile);
			return;
		} catch (Exception e) {
			logger.error("创建SessionFactory时发生异常,异常原因如下:");
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * getSession()方法
	 * 
	 * @return Session对象
	 * @throws HibernateException
	 */
	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
		} catch (Exception e) {
			logger.error("开启Session时发生异常,异常原因如下:");
			e.printStackTrace();
			throw e;
		}
		return session;
	}

	/**
	 * closeSession()方法
	 * 
	 * @param session
	 *            要关闭的Session对象
	 */
	public void closeSession(Session session) {
		try {
			if (null != session)
				session.close();
		} catch (Exception e) {
			logger.error("关闭Session时发生异常,异常原因如下:");
			e.printStackTrace();
			throw e;
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}
}