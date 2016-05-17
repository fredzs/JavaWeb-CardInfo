package com.action.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.service.SearchUserService;
import com.model.result.SearchResult;
import com.opensymphony.xwork2.Action;

public class SearchUserInfoByIdAction implements Action {
	private String card_env;
	private String card_type;
	private String card_id;
	private boolean done;
	private List<SearchResult> show_result_list = new ArrayList<SearchResult>();
	private static Logger logger = Logger.getLogger(SearchUserInfoByIdAction.class);
	
	public String execute() throws Exception {
		setDone(false);
		try {	
			done = setShow_result_list(new SearchUserService().SearchUserInfoById(card_env, card_type, card_id));
			if (!done){
				logger.warn("查找用户失败！");
				return ERROR;
			}
			return SUCCESS;
		}
		catch (Exception e) {
			logger.error("查找用户失败！");
			return ERROR;
		}
	}
	public String getCard_env() {
		return card_env;
	}
	public void setCard_env(String card_env) {
		this.card_env = card_env;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public List<SearchResult> getShow_result_list() {
		return show_result_list;
	}
	public boolean setShow_result_list(List<SearchResult> show_result_list) {
		this.show_result_list = show_result_list;
		return true;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
}
