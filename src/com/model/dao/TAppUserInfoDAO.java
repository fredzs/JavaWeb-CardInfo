package com.model.dao;
// Generated 2016-4-15 15:29:12 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import com.model.result.BandingResult;
import com.model.result.SearchResult;
import com.util.*;

/**
 * Home object for domain model class TAppUserInfo.
 * @see com.model.entity.TAppUserInfo
 * @author Hibernate Tools
 */
public class TAppUserInfoDAO {
 	HibernateUtil util = new HibernateUtil(); 
 	Long startTime, endTime;
	private static Logger logger = Logger.getLogger(TAppUserInfoDAO.class);
	
	@SuppressWarnings("unchecked")
	public List<SearchResult> findCard(String env, String cardno, String cardType) {
		HibernateUtil.init(env);
		Session session = util.getSession();
        try {  
        	String queryString = "SELECT name, phone, authentication FROM t_app_user_info as A, t_card_info as B WHERE ( B.app_userid=A.id AND B." + cardType + " = '" + cardno + "')";
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addScalar("name", StringType.INSTANCE)
															 .addScalar("phone", StringType.INSTANCE)
															 .addScalar("authentication", IntegerType.INSTANCE)
															 .setResultTransformer(Transformers.aliasToBean(SearchResult.class))
															 .list();
																//.setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return result;
        } catch (Exception e) {  
        	logger.error("TAppUserInfoDAO.findCard()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }   
	}
	
	@SuppressWarnings("unchecked")
	public List<SearchResult> findByRange(String env, Integer index, Integer offset) {
		HibernateUtil.init(env);
		Session session = util.getSession();
        try {  
        	String queryString = "SELECT name, phone, authentication FROM t_app_user_info AS U INNER JOIN t_card_info AS C ON U.id = C.app_userid LIMIT " + index + "," + offset;
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addScalar("name", StringType.INSTANCE)
															 .addScalar("phone", StringType.INSTANCE)
															 .addScalar("authentication", IntegerType.INSTANCE)
															 .setResultTransformer(Transformers.aliasToBean(SearchResult.class))
															 .list();
																//.setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return result;
        } catch (Exception e) {  
        	logger.error("TAppUserInfoDAO.findByRange()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
	
	public List<BandingResult> findBanding(String env, List<String> cardNumList, String searchCondition) {
		HibernateUtil.init(env);
		Session session = util.getSession();
		List<BandingResult> bandingList = new ArrayList<BandingResult>();
        try {  
        	for(int i=0;i<cardNumList.size();i++){
	        	String queryString = "SELECT U.id, U.`name`, U.phone, U.password FROM t_app_user_info AS U INNER JOIN t_card_info AS C ON U.id = C.app_userid and C." + searchCondition + " = '" + cardNumList.get(i) + "'";
	        	startTime = System.currentTimeMillis();
				@SuppressWarnings("rawtypes")
				List result = session.createSQLQuery(queryString).addScalar("id", StringType.INSTANCE)
																 .addScalar("name", StringType.INSTANCE)
																 .addScalar("phone", StringType.INSTANCE)
																 .addScalar("password", StringType.INSTANCE)
																 .setResultTransformer(Transformers.aliasToBean(BandingResult.class))
																 .list();
																	//.setCacheable(true).list();
				endTime = System.currentTimeMillis();
				logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
				if (result.size() != 0) {
					BandingResult bandingResult = (BandingResult) result.get(0);
					bandingList.add(bandingResult);
				} else{
					BandingResult b = new BandingResult("","","","");
					bandingList.add(b);
				}
        	}
            return bandingList;
        } catch (Exception e) {  
        	logger.error("TAppUserInfoDAO.findBanding()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
	
	public Integer amount(String env) {
		HibernateUtil.init(env);
		Session session = util.getSession();
        try {  
        	String queryString = "SELECT count(1) FROM t_app_user_info AS U INNER JOIN t_card_info AS C ON U.id = C.app_userid";
        	SQLQuery sqlQuery = session.createSQLQuery(queryString);
        	startTime = System.currentTimeMillis();
        	sqlQuery.addScalar("COUNT(1)", StringType.INSTANCE);
        	//Integer amount = Integer.parseInt(sqlQuery.setCacheable(true).list().get(0).toString());
        	Integer amount = Integer.parseInt(sqlQuery.list().get(0).toString());
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n语句执行时间为:" + (endTime - startTime) + "毫秒。");  
            return amount;
        } catch (Exception e) {  
        	logger.error("TAppUserInfoDAO.findByRange()方法发生异常:");  
            e.printStackTrace();  
            throw e; // 异常
        } finally {  
            util.closeSession(session);  
        }  
	}
	
	public List<SearchResult> findByCardNo(String env, String cardno) {
		return findCard(env, cardno, "cardno");   
	}
	
	public List<SearchResult> findBySscardNo(String env, String sscardno) {
        return findCard(env, sscardno, "sscardno");   
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		TAppUserInfoDAO.logger = logger;
	}
	
}
