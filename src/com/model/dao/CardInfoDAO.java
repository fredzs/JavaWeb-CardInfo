package com.model.dao;
// Generated 2016-4-19 12:40:33 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StringType;
import org.apache.log4j.Logger;
import com.model.entity.CardInfo;
import com.util.HibernateUtil;

/**
 * Home object for domain model class CardInfo.
 * @see com.model.entity.CardInfo
 * @author Hibernate Tools
 */
public class CardInfoDAO {
	HibernateUtil util = new HibernateUtil();
	Long startTime, endTime;
	private static Logger logger = Logger.getLogger(CardInfoDAO.class);
	/*--------------------------CURD--------------------------*/
	public boolean add(String userName, Byte idType, String cardNum, String idNum, String telephone, Byte cardStatus, Byte cardCondition) {
		HibernateUtil.init("");
		Session session = util.getSession();  
		boolean bool = false;
        try {  
        	CardInfo cardInfo = new CardInfo(1,userName, idType, cardNum, idNum, telephone, cardStatus, cardCondition);
        	Transaction tran = session.beginTransaction();//开始事物  
            session.save(cardInfo);//执行  
            tran.commit();//提交  
            bool = true;
            return bool;
        } catch (Exception e) {  
        	logger.error("CardInfoDAO.add()方法发生异常:");  
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
			CardInfo instance = session.get(CardInfo.class, id);
			Transaction tran = session.beginTransaction();//开始事务 
			session.delete(instance);//执行  
			tran.commit();//提交  
			bool = true;
			return bool;
		} catch (Exception e) {  
			logger.error("CardInfoDAO.remove()方法发生异常:");  
			e.printStackTrace();  
			throw e; // 异常
		} finally {  
			util.closeSession(session);  
		}  
	}
	public boolean update(Integer id, String userName, Byte idType, String cardNum, String idNum, String telephone, Byte cardStatus, Byte cardCondition) {
		HibernateUtil.init("");
		Session session = util.getSession();  
		boolean bool = false;
        try {  
        	CardInfo cardInfo = new CardInfo(id ,userName, idType, cardNum, idNum, telephone, cardStatus, cardCondition);
        	Transaction tran = session.beginTransaction();//开始事务  
            session.update(cardInfo);//执行  
            tran.commit();//提交  
            bool = true;
            return bool;
        } catch (Exception e) {  
        	logger.error("CardInfoDAO.update()方法发生异常:");  
            e.printStackTrace();
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
	public CardInfo findById(java.lang.Integer id) {
		HibernateUtil.init("");
		Session session = util.getSession();  
		try {
			CardInfo instance = session.get(CardInfo.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("CardInfoDAO.findById()方法发生异常:");  
			throw re;
		} finally {  
            util.closeSession(session);  
        }  
	}
	@SuppressWarnings("unchecked")
	public List<CardInfo> findByRange(Integer index, Integer offset) {
		HibernateUtil.init("");
		Session session = util.getSession();  
		try {  
			String queryString = "SELECT * FROM card_info LIMIT " + index + "," + offset;
			startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addEntity(CardInfo.class).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
			return result;
		} catch (Exception e) {  
			logger.error("CardInfoDAO.findByRange()方法发生异常:");  
			e.printStackTrace();  
			throw e; // 异常
		} finally {  
			util.closeSession(session);  
		}  
	}
	
	@SuppressWarnings("unchecked")
	public List<CardInfo> findByConditionList(String searchCondition, List<String> searchList, Integer index, Integer offset) {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {
        	String queryString = "SELECT * FROM card_info where " + searchCondition +  " in ( " ;
        	int i = 0;
        	for (i = 0; i < searchList.size() - 1; i++) {
        		queryString += "'" + searchList.get(i) + "' , "; 
			}
        	queryString += "'" + searchList.get(i) + "' ) LIMIT " + index + "," + offset;
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addEntity(CardInfo.class).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return result;
        } catch (Exception e) {  
        	logger.error("CardInfoDAO.findByCardNo()方法发生异常:");  
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
        	String queryString = "SELECT COUNT(1) FROM card_info";
        	SQLQuery sqlQuery = session.createSQLQuery(queryString).addScalar("COUNT(1)", StringType.INSTANCE);
        	sqlQuery.setCacheable(true);
        	startTime = System.currentTimeMillis();
        	Integer amount = Integer.valueOf((String) sqlQuery.uniqueResult());
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return amount;
        } catch (Exception e) {  
        	logger.error("CardInfoDAO.amount()方法发生异常:");  
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
        	String queryString = "SELECT COUNT(*) FROM card_info where " + search_condition +  " in ( " ;
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
        	logger.error("CardInfoDAO.amountByCondition()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}

	@SuppressWarnings("unchecked")
	public List<String> findCardNumList(Integer index, Integer offset) {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "select cardNum from card_info LIMIT " + index + "," + offset;
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addScalar("cardNum", StringType.INSTANCE).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return result;
        } catch (Exception e) {  
        	logger.error("CardInfoDAO.findCardNumByRange()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findCardNumListByConditionList(String searchCondition, List<String> searchList, Integer index, Integer offset) {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "select cardNum from card_info where " + searchCondition +  " in ( " ;
        	int i = 0;
        	for (i = 0; i < searchList.size() - 1; i++) {
        		queryString += "'" + searchList.get(i) + "' , "; 
			}
        	queryString += "'" + searchList.get(i) + "' )" + " LIMIT " + index + "," + offset; 
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addScalar("cardNum", StringType.INSTANCE).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return result;
        } catch (Exception e) {  
        	logger.error("CardInfoDAO.findCardNumListByCondition()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
}
