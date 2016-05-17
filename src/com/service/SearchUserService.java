package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.dao.CardInfoDAO;
import com.model.dao.SscardInfoDAO;
import com.model.dao.TAppUserInfoDAO;
import com.model.entity.CardInfo;
import com.model.entity.SscardInfo;
import com.model.result.BandingResult;
import com.model.result.SearchResult;
import com.util.Password;
import com.util.SearchConditionMap;

public class SearchUserService {
	private List<SearchResult> show_result_list = new ArrayList<SearchResult>();
	private List<CardInfo> resultCardInfo = new ArrayList<CardInfo>();
	private List<SscardInfo> resultSscardInfo = new ArrayList<SscardInfo>();
	private List<BandingResult> show_banding_list = new ArrayList<BandingResult>();
	
	public List<SearchResult> SearchUserInfoById(String env, String type, String id){
		if (type.equals("0")) {
			setShow_result_list(new TAppUserInfoDAO().findByCardNo(env, id)); 
		}
		else {
			setShow_result_list(new TAppUserInfoDAO().findBySscardNo(env,id)); 
		}
		return show_result_list;
	}
	
	public List<SearchResult> ShowUserInfoByRange(String env, Integer index, Integer offset){
		setShow_result_list(new TAppUserInfoDAO().findByRange(env, index, offset)); 
		return show_result_list;
	}
	
	// 返回card_info表中满足查询条件的记录数量
	public Integer ShowCardAmountByCondition(String search_condition, List<String> searchList){
		return new CardInfoDAO().findAmountByConditionList(search_condition, searchList); 
	}
	// 返回sscard_info表中满足查询条件的记录数量
	public Integer ShowSscardAmountByCondition(String search_condition, List<String> searchList){
		return new SscardInfoDAO().findAmountByConditionList(search_condition, searchList); 
	}
	
	// 返回card_info表中满足查询条件的所有记录
	public List<CardInfo> findCardByCondition(String search_condition, List<String> searchList, Integer index, Integer offset){
		setResultCardInfo(new CardInfoDAO().findByConditionList(search_condition, searchList, index, offset)); 
		return resultCardInfo;
	}
	// 返回sscard_info表中满足查询条件的所有记录
	public List<SscardInfo> findSscardByCondition(String search_condition, List<String> searchList, Integer index, Integer offset){
		setResultSscardInfo(new SscardInfoDAO().findByConditionList(search_condition, searchList, index, offset)); 
		return resultSscardInfo;
	}
	
	// 返回card_info表中满足查询条件记录的cardNum列表
	public List<String> findCardNumListByCondition(String search_condition, List<String> searchList, Integer index, Integer offset){
		return new CardInfoDAO().findCardNumListByConditionList(search_condition, searchList, index, offset); 
	}
	// 返回sscard_info表中满足查询条件记录的cardNum列表
	public List<String> findSscardNumListByCondition(String search_condition, List<String> searchList, Integer index, Integer offset){
		return new SscardInfoDAO().findSscardNumListByConditionList(search_condition, searchList, index, offset); 
	}
	
	// 根据cardNumList在t_app_userinfo表中查询结果
	public List<BandingResult> findBandingResult(String searchCondition, String env, List<String> cardNumList, String cardType){
		if (cardType.equals("0")) {
			setShow_banding_list(new TAppUserInfoDAO().findBanding(env, cardNumList, SearchConditionMap.getCardConditon().get(searchCondition))); 
		}
		else {
			setShow_banding_list(new TAppUserInfoDAO().findBanding(env, cardNumList, SearchConditionMap.getSscardConditon().get(searchCondition))); 
		}
		return show_banding_list;
	}
	
	// 根据前端页面的显示需求，通过查表，将从数据库中得到的密码MD5值重写成原密码
	public void rewritePassword(List<BandingResult> list){
		Password.rewrite(list);
	}
		
	public Integer ShowUserAmount(String env){
		return new TAppUserInfoDAO().amount(env); 
	}
	
	
	/*-----------------------------------------------------------------------*/
	/*--------------------------getters and setters--------------------------*/
	/*-----------------------------------------------------------------------*/
	
	public List<SearchResult> getShow_result_list() {
		return show_result_list;
	}

	public void setShow_result_list(List<SearchResult> show_result_list) {
		this.show_result_list = show_result_list;
	}

	public List<CardInfo> getResultCardInfo() {
		return resultCardInfo;
	}

	public void setResultCardInfo(List<CardInfo> resultCardInfo) {
		this.resultCardInfo = resultCardInfo;
	}

	public List<SscardInfo> getResultSscardInfo() {
		return resultSscardInfo;
	}

	public void setResultSscardInfo(List<SscardInfo> resultSscardInfo) {
		this.resultSscardInfo = resultSscardInfo;
	}

	public List<BandingResult> getShow_banding_list() {
		return show_banding_list;
	}

	public void setShow_banding_list(List<BandingResult> show_banding_list) {
		this.show_banding_list = show_banding_list;
	}
	
}
