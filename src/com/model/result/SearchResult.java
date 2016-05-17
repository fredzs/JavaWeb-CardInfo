package com.model.result;

public class SearchResult {
	private String name;
	private String phone;
	private Integer authentication;
	
	public SearchResult() {
	}
	
	public SearchResult(String name, String phone, Integer authentication) {
		super();
		this.name = name;
		this.phone = phone;
		this.authentication = authentication;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Integer authentication) {
		this.authentication = authentication;
	}
	
	
}
