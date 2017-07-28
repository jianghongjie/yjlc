package com.yjlc.commons.util;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String data = "admin1"; 
        System.out.println(data); 
        String digest = new ShaUtil().getDigestOfString(data.getBytes()); 
        System.out.println(digest); 
	}

}
