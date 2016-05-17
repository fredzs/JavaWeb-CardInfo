package com.util;

import java.util.HashMap;
import java.util.Map;


public class SearchConditionMap {

	private static Map<String, String> cardConditon = new HashMap<String, String>();
	private static Map<String, String> sscardConditon = new HashMap<String, String>();
	
	static{
		cardConditon.put("cardNum", "cardno");
		cardConditon.put("userName", "userName");
	}
	
	static{
		sscardConditon.put("sscardNum", "sscardno");
		sscardConditon.put("userName", "userName");
	}

	public static Map<String, String> getCardConditon() {
		return cardConditon;
	}

	public static void setCardConditon(Map<String, String> cardConditon) {
		SearchConditionMap.cardConditon = cardConditon;
	}

	public static Map<String, String> getSscardConditon() {
		return sscardConditon;
	}

	public static void setSscardConditon(Map<String, String> sscardConditon) {
		SearchConditionMap.sscardConditon = sscardConditon;
	}

	
}
