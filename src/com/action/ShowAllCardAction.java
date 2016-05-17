package com.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.service.ShowUserService;
import com.util.Pager;
import com.model.entity.CardInfo;
import com.model.result.BandingResult;
import com.opensymphony.xwork2.Action;

public class ShowAllCardAction implements Action {
	private List<CardInfo> result = new ArrayList<CardInfo>();
	private List<BandingResult> banding_list = new ArrayList<BandingResult>();
	private List<String> cardNo = new ArrayList<String>();
	private String cardEnv;
	private Integer totalNum = 0;
	private Pager p = new Pager();
	private Integer index;
	private static Logger logger = Logger.getLogger(ShowAllCardAction.class);
	
	public String execute() throws Exception {
		if (p.isNeedsTotal()) {
			try {	
				setTotalNum(new ShowUserService().ShowCardAmount());
			} catch (Exception e) {
				logger.error("获取京医通卡用户总数失败！");
			}
			p.setTotal(totalNum);
		}	
		try {
			index = (p.getPageNow()-1) * (p.getPageSize());
			result = new ShowUserService().ShowCardByRange(index, p.getPageSize());
			cardNo = new ShowUserService().ShowCardNoByRange(index, p.getPageSize());
			banding_list = new ShowUserService().ShowBandingResult(cardEnv, cardNo, "0");
			new ShowUserService().rewritePassword(banding_list);
			return SUCCESS;
		} catch (Exception e) {
			logger.error("获取全部京医通卡用户失败！");
			return ERROR;
		}
	}

	public String index() throws Exception {
		return SUCCESS;
	}
	public List<CardInfo> getResult() {
		return result;
	}

	public void setResult(List<CardInfo> result) {
		this.result = result;
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

	public List<BandingResult> getBanding_list() {
		return banding_list;
	}

	public void setBanding_list(List<BandingResult> banding_list) {
		this.banding_list = banding_list;
	}

	public List<String> getCardNo() {
		return cardNo;
	}

	public void setCardNo(List<String> cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardEnv() {
		return cardEnv;
	}

	public void setCardEnv(String cardEnv) {
		this.cardEnv = cardEnv;
	}
	
}
