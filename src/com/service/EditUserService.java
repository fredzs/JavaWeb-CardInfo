package com.service;

import com.model.dao.CardInfoDAO;
import com.model.dao.SscardInfoDAO;

public class EditUserService {
	public boolean editCardUser(Integer id, String userName, Byte idType, String cardNum, String idNum, String telephone, Byte cardStatus, Byte cardCondition) {
		return new CardInfoDAO().update(id, userName, idType, cardNum, idNum, telephone, cardStatus, cardCondition);
	}
	public boolean editSscardUser(Integer id, String userName, String idNum, String sscardNum, Byte sscardCondition) {
		return new SscardInfoDAO().update(id, idNum, sscardNum, userName, sscardCondition);
	}
}
