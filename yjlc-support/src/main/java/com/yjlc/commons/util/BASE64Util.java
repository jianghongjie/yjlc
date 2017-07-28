package com.yjlc.commons.util;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Calendar;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;




public class BASE64Util {
	
    public static byte[] decodeAsBytes(String input) {
    	byte[] bt = null;    
    	   try {    
    	       sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();    
    	       bt = decoder.decodeBuffer( input );    
    	   } catch (IOException e) {    
    	       e.printStackTrace();    
    	   }    
    	   
    	       return bt;  
    }
	/** 
     * 二进制数据编码为BASE64字符串 
     * @param bytes 
     * @return 
     * author:扫地僧
     * @throws Exception 
     */  
    public static String encode(byte[] buf) {
    	 return new sun.misc.BASE64Encoder().encode(buf);    
    }
    
    public static void main(String[] args) {
		System.out.println(decodeAsBytes("ddd"));
		System.out.println(StringUtils.substring(encode(decodeAsBytes("ddd")), 0, encode(decodeAsBytes("ddd")).length()-1));
	}

}