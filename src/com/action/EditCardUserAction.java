package com.action;

import com.service.EditUserService;

import org.apache.log4j.Logger;
import com.opensymphony.xwork2.Action;

public class EditCardUserAction implements Action {
	private Integer id;
	private String userName;
	private Byte idType;
	private String cardNum;
	private String idNum;
	private String telephone;
	private Byte cardStatus;
	private Byte cardCondition;
	private boolean done;
	private static Logger logger = Logger.getLogger(EditCardUserAction.class);
	
	public String execute() throws Exception {
		try 
		{	
			done = new EditUserService().editCardUser(id, userName, idType, cardNum, idNum, telephone, cardStatus, cardCondition);
			if (!done){
				logger.warn("修改京医通卡用户失败！");
				return ERROR;
			}
			return SUCCESS;
		}
		catch (Exception e) {
			logger.error("修改京医通卡用户失败！");
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
	public Byte getIdType() {
		return idType;
	}
	public void setIdType(Byte idType) {
		this.idType = idType;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public Byte getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(Byte cardStatus) {
		this.cardStatus = cardStatus;
	}
	public Byte getCardCondition() {
		return cardCondition;
	}
	public void setCardCondition(Byte cardCondition) {
		this.cardCondition = cardCondition;
	}
	
}
