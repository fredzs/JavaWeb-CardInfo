package com.model.entity;
// Generated 2016-4-15 15:29:12 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TAppUserInfo generated by hbm2java
 */
public class TAppUserInfo implements java.io.Serializable {
	private static final long serialVersionUID = 2826958471145097710L;
	private String id;
	private String openId;
	private String name;
	private String password;
	private String phone;
	private String idtype;
	private String idno;
	private String image;
	private String compressImage;
	private Boolean status;
	private Date createTime;
	private Date updateTime;
	private Integer userChannel;
	private Integer authentication;
	private String authOpenid;

	public TAppUserInfo() {
	}

	public TAppUserInfo(String id, Date createTime, Date updateTime) {
		this.id = id;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public TAppUserInfo(String id, String openId, String name, String password, String phone, String idtype,
			String idno, String image, String compressImage, Boolean status, Date createTime, Date updateTime,
			Integer userChannel, Integer authentication, String authOpenid) {
		this.id = id;
		this.openId = openId;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.idtype = idtype;
		this.idno = idno;
		this.image = image;
		this.compressImage = compressImage;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.userChannel = userChannel;
		this.authentication = authentication;
		this.authOpenid = authOpenid;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdtype() {
		return this.idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getIdno() {
		return this.idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCompressImage() {
		return this.compressImage;
	}

	public void setCompressImage(String compressImage) {
		this.compressImage = compressImage;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUserChannel() {
		return this.userChannel;
	}

	public void setUserChannel(Integer userChannel) {
		this.userChannel = userChannel;
	}

	public Integer getAuthentication() {
		return this.authentication;
	}

	public void setAuthentication(Integer authentication) {
		this.authentication = authentication;
	}

	public String getAuthOpenid() {
		return this.authOpenid;
	}

	public void setAuthOpenid(String authOpenid) {
		this.authOpenid = authOpenid;
	}

}
