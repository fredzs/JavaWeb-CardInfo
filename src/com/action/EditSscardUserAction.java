package com.action;

import com.service.EditUserService;

import org.apache.log4j.Logger;
import com.opensymphony.xwork2.Action;

public class EditSscardUserAction implements Action {
	private Integer id;
	private String userName;
	private String idNum;
	private String sscardNum;
	private Byte sscardCondition;
	private boolean done;
	private static Logger logger = Logger.getLogger(EditSscardUserAction.class);
	
	public String execute() throws Exception {
		try 
		{	
			done = new EditUserService().editSscardUser(id, userName, idNum, sscardNum, sscardCondition);
			if (!done){
				logger.warn("修改社保卡用户失败！");
				return ERROR;
			}
			return SUCCESS;
		}
		catch (Exception e) {
			logger.error("修改社保卡用户失败！");
			return ERROR;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getSscardNum() {
		return sscardNum;
	}

	public void setSscardNum(String sscardNum) {
		this.sscardNum = sscardNum;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Byte getSscardCondition() {
		return sscardCondition;
	}

	public void setSscardCondition(Byte sscardCondition) {
		this.sscardCondition = sscardCondition;
	}
	
}
