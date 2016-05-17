package com.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.service.ShowUserService;
import com.util.Pager;
import com.model.entity.SscardInfo;
import com.model.result.BandingResult;
import com.opensymphony.xwork2.Action;

public class ShowAllSscardAction implements Action {
	private List<SscardInfo> result = new ArrayList<SscardInfo>();
	private List<BandingResult> banding_list = new ArrayList<BandingResult>();
	private List<String> sscardNo = new ArrayList<String>();
	private String cardEnv;
	private Integer totalNum;
	private Pager p = new Pager();
	private Integer index;
	private static Logger logger = Logger.getLogger(ShowAllSscardAction.class);
	
	public String execute() throws Exception {
		if (p.isNeedsTotal()) {
			try {	
				setTotalNum(new ShowUserService().ShowSscardAmount());
			} catch (Exception e) {
				logger.error("获取社保卡用户总数失败！");
			}
			p.setTotal(totalNum);
		}	
		index = (p.getPageNow()-1) * (p.getPageSize());
		try {
			result = new ShowUserService().ShowSscardByRange(index, p.getPageSize());
			sscardNo = new ShowUserService().ShowSscardNoByRange(index, p.getPageSize());
			banding_list = new ShowUserService().ShowBandingResult(cardEnv, sscardNo, "1");
			new ShowUserService().rewritePassword(banding_list);
			return SUCCESS;
		} catch (Exception e) {
			logger.error("获取全部社保卡用户失败！");
			return ERROR;
		}
	}
	
	public List<SscardInfo> getResult() {
		return result;
	}

	public void setResult(List<SscardInfo> result) {
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

	public List<String> getSscardNo() {
		return sscardNo;
	}

	public void setSscardNo(List<String> sscardNo) {
		this.sscardNo = sscardNo;
	}

	public List<BandingResult> getBanding_list() {
		return banding_list;
	}

	public void setBanding_list(List<BandingResult> banding_list) {
		this.banding_list = banding_list;
	}

	public String getCardEnv() {
		return cardEnv;
	}

	public void setCardEnv(String cardEnv) {
		this.cardEnv = cardEnv;
	}
	
}
