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
	// ��Configuration����
	private static Configuration configuration = new Configuration();
	// ��Session��������
	private static SessionFactory sessionFactory = null;
	private static Logger logger = Logger.getLogger(HibernateUtil.class);
	public static void init(String env) {
		try {
			// ����Hibernate�����ļ����ڵ�·��
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
			// ����һ��Session����
			sessionFactory = configuration.buildSessionFactory();
			logger.info("��ʼ��SessionFactory,�����ļ�Ϊ��" + configFile);
			return;
		} catch (Exception e) {
			logger.error("����SessionFactoryʱ�����쳣,�쳣ԭ������:");
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * getSession()����
	 * 
	 * @return Session����
	 * @throws HibernateException
	 */
	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
		} catch (Exception e) {
			logger.error("����Sessionʱ�����쳣,�쳣ԭ������:");
			e.printStackTrace();
			throw e;
		}
		return session;
	}

	/**
	 * closeSession()����
	 * 
	 * @param session
	 *            Ҫ�رյ�Session����
	 */
	public void closeSession(Session session) {
		try {
			if (null != session)
				session.close();
		} catch (Exception e) {
			logger.error("�ر�Sessionʱ�����쳣,�쳣ԭ������:");
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