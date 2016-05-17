package com.service;

import java.util.ArrayList;
import java.util.List;
import com.model.dao.CardInfoDAO;
import com.model.dao.SscardInfoDAO;
import com.model.dao.TAppUserInfoDAO;
import com.model.entity.CardInfo;
import com.model.entity.SscardInfo;
import com.model.result.BandingResult;
import com.util.Password;

public class ShowUserService {
	private List<CardInfo> resultCardInfo = new ArrayList<CardInfo>();
	private List<SscardInfo> resultSscardInfo = new ArrayList<SscardInfo>();
	private List<BandingResult> show_result_list = new ArrayList<BandingResult>();
	
	public List<CardInfo> ShowCardByRange(Integer index, Integer offset){
		setResultCardInfo(new CardInfoDAO().findByRange(index, offset)); 
		return resultCardInfo;
	}
	
	public void rewritePassword(List<BandingResult> list){
		Password.rewrite(list);
	}
	
	public List<BandingResult> ShowBandingResult(String env, List<String> cardNoList, String cardType){
		if (cardType.equals("0")) {
			setShow_result_list(new TAppUserInfoDAO().findBanding(env, cardNoList, "cardno")); 
		}
		else {
			setShow_result_list(new TAppUserInfoDAO().findBanding(env,cardNoList, "sscardno")); 
		}
		return show_result_list;
	}
	
	public List<String> ShowCardNoByRange(Integer index, Integer offset){
		return new CardInfoDAO().findCardNumList(index, offset); 
	}
	
	public List<String> ShowSscardNoByRange(Integer index, Integer offset){
		return new SscardInfoDAO().findSscardNumByRange(index, offset); 
	}
	
	public Integer ShowCardAmount(){
		return new CardInfoDAO().findAmount(); 
	}
	
	public List<SscardInfo> ShowSscardByRange(Integer index, Integer offset){
		setResultSscardInfo(new SscardInfoDAO().findByRange(index, offset)); 
		return resultSscardInfo;
	}
	
	public Integer ShowSscardAmount(){
		return new SscardInfoDAO().findAmount(); 
	}
	
	/*-----------------------------------------------------------------------*/
	/*--------------------------getters and setters--------------------------*/
	/*-----------------------------------------------------------------------*/
	
	public List<CardInfo> getResultCardInfo() {
		return resultCardInfo;
	}

	public void setResultCardInfo(List<CardInfo> resultCardInfo) {
		this.resultCardInfo = resultCardInfo;
	}

	public List<SscardInfo> getResultSscardInfo() {
		return resultSscardInfo;
	}

	public void setResultSscardInfo(List<SscardInfo> resultSscardInfo) {
		this.resultSscardInfo = resultSscardInfo;
	}

	public List<BandingResult> getShow_result_list() {
		return show_result_list;
	}

	public void setShow_result_list(List<BandingResult> show_result_list) {
		this.show_result_list = show_result_list;
	}
}
