package com.service;

import com.model.dao.CardInfoDAO;
import com.model.dao.SscardInfoDAO;
import com.model.entity.CardInfo;
import com.model.entity.SscardInfo;

public class GetOldUserService {
	private CardInfo resultCardInfo = new CardInfo();
	private SscardInfo resultSscardInfo = new SscardInfo();
	
	public CardInfo GetOldCard(Integer id){
		setResultCardInfo(new CardInfoDAO().findById(id)); 
		return resultCardInfo;
	}

	public SscardInfo GetOldSscard(Integer id){
		setResultSscardInfo(new SscardInfoDAO().findById(id)); 
		return resultSscardInfo;
	}

	public CardInfo getResultCardInfo() {
		return resultCardInfo;
	}

	public void setResultCardInfo(CardInfo resultCardInfo) {
		this.resultCardInfo = resultCardInfo;
	}

	public SscardInfo getResultSscardInfo() {
		return resultSscardInfo;
	}

	public void setResultSscardInfo(SscardInfo resultSscardInfo) {
		this.resultSscardInfo = resultSscardInfo;
	}
	
}
