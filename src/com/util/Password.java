package com.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.result.BandingResult;

public class Password {

	private static Map<String, String> passwordMap = new HashMap<String, String>();
	
	static{
		passwordMap.put("078563f337ec6d6fedf131ddc857db19", "123451");
		passwordMap.put("343B1C4A3EA721B2D640FC8700DB0F36", "qqqqqq");
		passwordMap.put("4297f44b13955235245b2497399d7a93", "123123");
		passwordMap.put("46f94c8de14fb36680850768ff1b7f2a", "123qwe");
		passwordMap.put("591593dd3513b72b631d560846cee0eb", "338817");
		passwordMap.put("5f8591a3d4fe06393cad53edff27ba05", "111111q");
		passwordMap.put("670b14728ad9902aecba32e22fa4f6bd", "000000");
		passwordMap.put("96e79218965eb72c92a549dd5a330112", "111111");
		passwordMap.put("b6e02c87f5a1c7a8392bfdf3869b2116", "wenzheng1314");
		passwordMap.put("c57562653c783faeb8b6cd917ef258c1", "l123456");
		passwordMap.put("e10adc3949ba59abbe56e057f20f883e", "123456");
		passwordMap.put("e882b72bccfc2ad578c27b0d9b472a14", "pppppp");
//		passwordMap.put("15ab03806dc57df13392f93b58aa1170", "");
//		passwordMap.put("27fc301048dc9475787262ed8887bf48", "");
//		passwordMap.put("a9b3c6f02b8bb664f662ec362b795c80", "");
//		passwordMap.put("c31599bf4d63e421fdf025eba2641560", "");
//		passwordMap.put("f29d526079ed8967b8a8c1f441a3337f", "");
//		passwordMap.put("fb3fc23b612de4016c442d59de02e7df", "");
	}

	public static void rewrite(List<BandingResult> list) {
		for (int i = 0; i < list.size(); i++) {
			String oldPassword = list.get(i).getPassword();
			if (Password.getPasswordMap().containsKey(oldPassword)) {
				list.get(i).setPassword(Password.getPasswordMap().get(oldPassword));
			}
		}
	}
	public static Map<String, String> getPasswordMap() {
		return passwordMap;
	}

	public static void setPasswordMap(Map<String, String> passwordMap) {
		Password.passwordMap = passwordMap;
	}
	
}
