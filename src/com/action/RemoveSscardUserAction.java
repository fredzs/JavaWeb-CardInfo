package com.action;

import com.service.RemoveUserService;

import org.apache.log4j.Logger;
import com.opensymphony.xwork2.Action;

public class RemoveSscardUserAction implements Action {
	private Integer id;
	private boolean done;
	private static Logger logger = Logger.getLogger(RemoveSscardUserAction.class);
	
	public String execute() throws Exception {
		try 
		{	
			done = new RemoveUserService().removeSscardUser(id);
			if (!done){
				logger.warn("删除社保卡用户失败！");
				return ERROR;
			}
			return SUCCESS;
		}
		catch (Exception e) {
			logger.error("删除社保卡用户失败！");
			return ERROR;
		}
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
