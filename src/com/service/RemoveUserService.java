package com.service;

import com.model.dao.CardInfoDAO;
import com.model.dao.SscardInfoDAO;

public class RemoveUserService {
	public boolean removeCardUser(Integer id) {
		return new CardInfoDAO().remove(id);
	}
	public boolean removeSscardUser(Integer id) {
		return new SscardInfoDAO().remove(id);
	}
}
