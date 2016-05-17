package com.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.service.SearchUserService;
import com.util.Pager;
import com.model.result.SearchResult;
import com.opensymphony.xwork2.Action;

public class ShowUserInfoAction implements Action {
	private String cardEnv;
	private String cardType;
	private String cardNum;
	private List<SearchResult> show_result_list = new ArrayList<SearchResult>();
	private Integer totalNum;
	private Pager p = new Pager();
	private Integer index;
	private static Logger logger = Logger.getLogger(ShowUserInfoAction.class);
	
	public String execute() throws Exception {
		try {
			p.setPageSize(20);
			p.setTotal(new SearchUserService().ShowUserAmount(cardEnv));
			index = (p.getPageNow()-1) * (p.getPageSize());
			setShow_result_list(new SearchUserService().ShowUserInfoByRange(cardEnv, index, p.getPageSize()));
			return SUCCESS;
		} catch (Exception e) {
			logger.error("获取该环境卡信息失败！");
			return ERROR;
		}
	}
	public List<SearchResult> getShow_result_list() {
		return show_result_list;
	}
	public boolean setShow_result_list(List<SearchResult> show_result_list) {
		this.show_result_list = show_result_list;
		return true;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Pager getP() {
		return p;
	}
	public void setP(Pager p) {
		this.p = p;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getCardEnv() {
		return cardEnv;
	}
	public void setCardEnv(String cardEnv) {
		this.cardEnv = cardEnv;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
}
