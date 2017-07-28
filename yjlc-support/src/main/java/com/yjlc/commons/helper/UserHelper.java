package com.yjlc.commons.helper;

import com.yjlc.commons.util.TokenManager;

public class UserHelper {

	public static String createTk(String userid) {
		return TokenManager.generate(userid).toString();
	
	}
	public static void main(String[] args) {
		System.out.println(createTk("10005"));
	}
}
