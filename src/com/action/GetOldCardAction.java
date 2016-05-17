package com.action;

import com.service.GetOldUserService;

import org.apache.log4j.Logger;
import com.model.entity.CardInfo;
import com.opensymphony.xwork2.Action;

public class GetOldCardAction implements Action {
	private Integer id;
	private CardInfo result = new CardInfo();
	private static Logger logger = Logger.getLogger(GetOldCardAction.class);
	
	public String execute() throws Exception {
		try 
		{	
			setResult(new GetOldUserService().GetOldCard(id));
			return SUCCESS;
		}
		catch (Exception e) {
			logger.error("获取旧京医通卡用户失败！");
			return ERROR;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CardInfo getResult() {
		return result;
	}

	public void setResult(CardInfo result) {
		this.result = result;
	}
}
