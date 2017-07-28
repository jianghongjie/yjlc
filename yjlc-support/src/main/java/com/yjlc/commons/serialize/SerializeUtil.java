package com.yjlc.commons.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * 描述: 提供对象的序列化和饭序列化的工作 
 * 作者: 扫地僧
 * 公司: 深圳市前海技术有限公司
 * 日期: 2017-4-2 下午8:38:44 
 * 版本号: V1.0
 */
public class SerializeUtil {
	public static byte[] serialize(Object object) {  
		ObjectOutputStream oos = null;  
		ByteArrayOutputStream baos = null;  
		try {  
		//序列化  
		baos = new ByteArrayOutputStream();  
		oos = new ObjectOutputStream(baos);  
		oos.writeObject(object);  
		byte[] bytes = baos.toByteArray();  
		return bytes;  
		} catch (Exception e) {  
		}  
		return null;  
		}  
		  
		public static Object unserialize(byte[] bytes) {  
		ByteArrayInputStream bais = null;  
		try {  
		//反序列化  
		bais = new ByteArrayInputStream(bytes);  
		ObjectInputStream ois = new ObjectInputStream(bais);  
		return ois.readObject();  
		} catch (Exception e) {  
		}  
		return null;  
		}  
}
