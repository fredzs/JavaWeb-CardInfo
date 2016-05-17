package com.action;

import com.service.GetOldUserService;

import org.apache.log4j.Logger;
import com.model.entity.SscardInfo;
import com.opensymphony.xwork2.Action;

public class GetOldSscardAction implements Action {
	private Integer id;
	private SscardInfo result = new SscardInfo();
	private static Logger logger = Logger.getLogger(GetOldSscardAction.class);
	
	public String execute() throws Exception {
		try 
		{	
			setResult(new GetOldUserService().GetOldSscard(id));
			return SUCCESS;
		}
		catch (Exception e) {
			logger.error("获取旧社保卡用户失败！");
			return ERROR;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SscardInfo getResult() {
		return result;
	}

	public void setResult(SscardInfo result) {
		this.result = result;
	}
}
