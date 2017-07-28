package com.yjlc.commons.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 短链接生成工具类
 * @author 谢平
 * @date 2015-11-9
 */
public class ShortUrlUtil {
	public static HttpClient httpclient = HttpClients.createDefault();

	/**
	 * 生成端连接信息
	 */
	public static String generateShortUrl(String url) {
		try {
//			String shortUrl = getShortUrlFromBaiDu(url);
			String shortUrl = getShortUrlFromSina(url);
			
			return shortUrl;
		} catch (Exception e) {
			return url;
		}
	}

	private static String getShortUrlFromBaiDu(String url)
			throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost httpost = new HttpPost("http://dwz.cn/create.php");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("url", url)); // 用户名称
		httpost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String shortUrl = object.getString("tinyurl");
		return shortUrl;
	}
	
	private static String getShortUrlFromSina(String url)
			throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost httpost = new HttpPost("http://api.t.sina.com.cn/short_url/shorten.json");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("source", "1902188496")); // 用户名称
		params.add(new BasicNameValuePair("url_long", url)); // 用户名称
		httpost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONArray jsonArray = JSON.parseArray(jsonStr);
		JSONObject jsonObj = (JSONObject)jsonArray.get(0) ;
		String shortUrl = jsonObj.getString("url_short");
		return shortUrl;
	}

	/**
	 * 测试生成端连接
	 */
	public static void main(String[] args) {
		String longUrl = "http://192.168.3.7:8999/appInvite/joinToGroup.html?groupId=55d588fccb827c15fc9d47b3&doctorId=387";
		String url = generateShortUrl(longUrl);
		System.out.println(url);
	}
}
