package com.model.dao;
// Generated 2016-4-15 15:29:12 by Hibernate Tools 3.4.0.CR1

import javax.naming.InitialContext;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import com.model.entity.TCardInfo;

/**
 * Home object for domain model class TCardInfo.
 * @see com.model.entity.TCardInfo
 * @author Hibernate Tools
 */
public class TCardInfoDAO {

	private static Logger logger = Logger.getLogger(TCardInfoDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void delete(TCardInfo persistentInstance) {
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public TCardInfo findById(java.lang.String id) {
		try {
			TCardInfo instance = (TCardInfo) sessionFactory.getCurrentSession().get("entity.TCardInfo", id);
			if (instance == null) {
				logger.debug("get successful, no instance found");
			} else {
				logger.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}
}
