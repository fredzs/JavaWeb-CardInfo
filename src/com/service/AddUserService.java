package com.service;

import com.model.dao.CardInfoDAO;
import com.model.dao.SscardInfoDAO;

public class AddUserService {
	public boolean addCardUser(String userName, Byte idType, String cardNum, String idNum, String telephone, Byte cardStatus, Byte cardCondition) {
		return new CardInfoDAO().add(userName, idType, cardNum, idNum, telephone, cardStatus, cardCondition);
	}
	public boolean addSscardUser(String userName, String idNum, String sscardNum, Byte sscardCondition) {
		return new SscardInfoDAO().add(userName, idNum, sscardNum, sscardCondition);
	}
}
