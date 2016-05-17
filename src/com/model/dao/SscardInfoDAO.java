package com.model.dao;
// Generated 2016-4-19 12:40:33 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StringType;

import com.model.entity.SscardInfo;
import com.util.HibernateUtil;

/**
 * Home object for domain model class SscardInfo.
 * @see com.model.entity.SscardInfo
 * @author Hibernate Tools
 */
public class SscardInfoDAO {
	HibernateUtil util = new HibernateUtil();
	Long startTime, endTime;
	private static Logger logger = Logger.getLogger(SscardInfoDAO.class);
	/*--------------------------CURD--------------------------*/
	public boolean add(String userName, String idNum, String sscardNum, Byte sscardCondition) {
		HibernateUtil.init("");
		Session session = util.getSession();  
		boolean bool = false;
        try {  
        	SscardInfo sscardInfo = new SscardInfo(1,idNum, sscardNum, userName, sscardCondition);
        	Transaction tran = session.beginTransaction();//开始事物  
            session.save(sscardInfo);//执行  
            tran.commit();//提交  
            bool = true;
            return bool;
        } catch (Exception e) {  
            logger.error("SscardInfoDAO.add()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
	public boolean remove(Integer id) {
		HibernateUtil.init("");
		Session session = util.getSession();  
		boolean bool = false;
        try {  
        	SscardInfo instance = session.get(SscardInfo.class, id);
        	Transaction tran = session.beginTransaction();//开始事务 
            session.delete(instance);//执行  
            tran.commit();//提交  
            bool = true;
            return bool;
        } catch (Exception e) {  
            logger.error("SscardInfo.remove()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
	public boolean update(Integer id, String userName, String idNum, String sscardNum, Byte sscardCondition) {
		HibernateUtil.init("");
		Session session = util.getSession();  
		boolean bool = false;
        try {  
        	SscardInfo sscardInfo = new SscardInfo(id ,userName, idNum, sscardNum, sscardCondition);
        	Transaction tran = session.beginTransaction();//开始事务  
            session.update(sscardInfo);//执行  
            tran.commit();//提交  
            bool = true;
            return bool;
        } catch (Exception e) {  
            logger.error("SscardInfo.update()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
	public SscardInfo findById(java.lang.Integer id) {
		HibernateUtil.init("");
		Session session = util.getSession();  
		try {
			SscardInfo instance = session.get(SscardInfo.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		} finally {  
            util.closeSession(session);  
        }  
	}
	@SuppressWarnings("unchecked")
	public List<SscardInfo> findByRange(Integer index, Integer offset) {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "SELECT * FROM sscard_info LIMIT " + index + "," + offset;
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addEntity(SscardInfo.class).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return result;
        } catch (Exception e) {  
            logger.error("SscardInfo.findByRange()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}

	@SuppressWarnings("unchecked")
	public List<SscardInfo> findByConditionList(String searchCondition, List<String> searchList, Integer index, Integer offset) {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "SELECT * FROM sscard_info where " + searchCondition +  " in ( " ;
        	int i = 0;
        	for (i = 0; i < searchList.size() - 1; i++) {
        		queryString += "'" + searchList.get(i) + "' , "; 
			}
        	queryString += "'" + searchList.get(i) + "' ) LIMIT " + index + "," + offset; 
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addEntity(SscardInfo.class).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return result;
        } catch (Exception e) {  
            logger.error("SscardInfo.findByCondition()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
	
	public Integer findAmount() {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "SELECT COUNT(1) FROM sscard_info";
        	SQLQuery sqlQuery = session.createSQLQuery(queryString).addScalar("COUNT(1)", StringType.INSTANCE);
        	sqlQuery.setCacheable(true);
        	startTime = System.currentTimeMillis();
        	Integer amount = Integer.valueOf((String) sqlQuery.uniqueResult());
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return amount;
        } catch (Exception e) {  
            logger.error("SscardInfoDAO.amount()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
	
	public Integer findAmountByConditionList(String search_condition, List<String> searchList) {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "SELECT COUNT(*) FROM sscard_info where " + search_condition +  " in ( " ;
        	int i = 0;
        	for (i = 0; i < searchList.size() - 1; i++) {
        		queryString += "'" + searchList.get(i) + "' , "; 
			}
        	queryString += "'" + searchList.get(i) + "' );";
        	SQLQuery sqlQuery = session.createSQLQuery(queryString).addScalar("COUNT(*)", StringType.INSTANCE);
        	sqlQuery.setCacheable(true);
        	startTime = System.currentTimeMillis();
        	Integer amount = Integer.valueOf((String) sqlQuery.uniqueResult());
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return amount;
        } catch (Exception e) {  
            logger.error("SscardInfoDAO.amountByCondition()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}

	@SuppressWarnings("unchecked")
	public List<String> findSscardNumByRange(Integer index, Integer offset) {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "select sscardNum from sscard_info LIMIT " + index + "," + offset;
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addScalar("sscardNum", StringType.INSTANCE).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return result;
        } catch (Exception e) {  
            logger.error("SscardInfoDAO.findSscardNoByRange()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findSscardNumListByConditionList(String searchCondition, List<String> searchList, Integer index, Integer offset) {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "select sscardNum from sscard_info where " + searchCondition +  " in ( " ;
        	int i = 0;
        	for (i = 0; i < searchList.size() - 1; i++) {
        		queryString += "'" + searchList.get(i) + "' , "; 
			}
        	queryString += "'" + searchList.get(i) + "' )" + " LIMIT " + index + "," + offset; 
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addScalar("sscardNum", StringType.INSTANCE).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return result;
        } catch (Exception e) {  
            logger.error("SScardInfoDAO.findSscardNumListByCondition()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
}
