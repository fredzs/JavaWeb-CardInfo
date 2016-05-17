package com.action.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.service.SearchUserService;
import com.service.ShowUserService;
import com.util.Pager;
import com.model.entity.CardInfo;
import com.model.result.BandingResult;
import com.opensymphony.xwork2.Action;

public class SearchCardByConditionAction implements Action {
	private String cardEnv;
	private String searchCondition;
	private String searchValue;
	private List<String> searchList = new ArrayList<String>();
	private List<CardInfo> result = new ArrayList<CardInfo>();
	private List<BandingResult> banding_list = new ArrayList<BandingResult>();
	private List<String> cardNumList = new ArrayList<String>();
	private Integer totalNum;
	private Integer index;
	private Pager p = new Pager();
	private static Logger logger = Logger.getLogger(SearchCardByConditionAction.class);
	
	public String execute() throws Exception {
		try {
			p.setPageSize(30);
			if (p.isNeedsTotal()) {
				try {	
					setTotalNum(new SearchUserService().ShowCardAmountByCondition(searchCondition, searchList));
				} catch (Exception e) {
					logger.error("获取京医通卡用户总数失败！");
				}
				p.setTotal(totalNum);
			}	
			index = (p.getPageNow()-1) * (p.getPageSize());
			result = new SearchUserService().findCardByCondition(searchCondition, searchList, index, p.getPageSize());
			cardNumList = new SearchUserService().findCardNumListByCondition(searchCondition, searchList, index, p.getPageSize());
			banding_list = new SearchUserService().findBandingResult(searchCondition, cardEnv, cardNumList, "0");
			new SearchUserService().rewritePassword(banding_list);
			if (banding_list.size() > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			logger.error("查找用户失败！");
			return ERROR;
		}
	}
	
	public String all() throws Exception {
		if (p.isNeedsTotal()) {
			try {	
				setTotalNum(new ShowUserService().ShowCardAmount());
			} catch (Exception e) {
				logger.warn("查找用户失败！");
			}
			p.setTotal(totalNum);
		}	
		try {
			index = (p.getPageNow()-1) * (p.getPageSize());
			result = new ShowUserService().ShowCardByRange(index, p.getPageSize());
			return SUCCESS;
		} catch (Exception e) {
			logger.error("查找用户失败！");
			return ERROR;
		}
	}
	
	/*-----------------------------------------------------------------------*/
	/*--------------------------getters and setters--------------------------*/
	/*-----------------------------------------------------------------------*/
	
	public List<CardInfo> getResult() {
		return result;
	}

	public void setResult(List<CardInfo> result) {
		this.result = result;
	}

	public List<BandingResult> getBanding_list() {
		return banding_list;
	}

	public void setBanding_list(List<BandingResult> banding_list) {
		this.banding_list = banding_list;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Pager getP() {
		return p;
	}

	public void setP(Pager p) {
		this.p = p;
	}

	public List<String> getCardNumList() {
		return cardNumList;
	}

	public void setCardNumList(List<String> cardNumList) {
		this.cardNumList = cardNumList;
	}

	public String getCardEnv() {
		return cardEnv;
	}

	public void setCardEnv(String cardEnv) {
		this.cardEnv = cardEnv;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<String> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<String> searchList) {
		this.searchList = searchList;
	}
	
}
