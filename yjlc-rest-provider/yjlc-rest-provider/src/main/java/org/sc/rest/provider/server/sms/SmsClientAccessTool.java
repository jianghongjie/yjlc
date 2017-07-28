package org.sc.rest.provider.server.sms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.yjlc.commons.log.LogUtil;

public class SmsClientAccessTool
{

	private static LogUtil log = LogUtil.getInstance(SmsClientAccessTool.class);
	private static SmsClientAccessTool smsClientToolInstance;

	public static synchronized SmsClientAccessTool getInstance()
	{
		if (smsClientToolInstance == null)
		{
			smsClientToolInstance = new SmsClientAccessTool();
		}
		return smsClientToolInstance;
	}

	/**
	 * 描述: 短信post提交 参数: @param sendUrl 参数: @param sendParam 参数: @param
	 * backEncodType 参数: @return 返回值类型: String 作者: 扫地僧 日期: 2017-4-15 下午11:43:19
	 */
	public String doAccessHTTPPost(String sendUrl, String sendParam, String backEncodType)
	{
		StringBuffer receive = new StringBuffer();
		BufferedWriter wr = null;
		try
		{
			if (backEncodType == null || backEncodType.equals(""))
			{
				backEncodType = "UTF-8";
			}

			URL url = new URL(sendUrl);
			HttpURLConnection URLConn = (HttpURLConnection) url.openConnection();

			URLConn.setDoOutput(true);
			URLConn.setDoInput(true);
			((HttpURLConnection) URLConn).setRequestMethod("POST");
			URLConn.setUseCaches(false);
			URLConn.setAllowUserInteraction(true);
			HttpURLConnection.setFollowRedirects(true);
			URLConn.setInstanceFollowRedirects(true);

			URLConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			URLConn.setRequestProperty("Content-Length", String.valueOf(sendParam.getBytes().length));

			DataOutputStream dos = new DataOutputStream(URLConn.getOutputStream());
			dos.writeBytes(sendParam);

			BufferedReader rd = new BufferedReader(new InputStreamReader(URLConn.getInputStream(), backEncodType));
			String line;
			while ((line = rd.readLine()) != null)
			{
				receive.append(line).append("\r\n");
			}
			rd.close();
		} catch (java.io.IOException e)
		{
			receive.append("访问产生了异常-->").append(e.getMessage());
			e.printStackTrace();
		} finally
		{
			if (wr != null)
			{
				try
				{
					wr.close();
				} catch (IOException ex)
				{
					ex.printStackTrace();
				}
				wr = null;
			}
		}
		log.info("短信发送返回：" + receive.toString());
		return receive.toString();
	}

	/**
	 * 描述: 短信get提交 参数: @param sendUrl 参数: @param backEncodType 参数: @return
	 * 返回值类型: String 作者: 扫地僧 日期: 2017-4-15 下午11:43:01
	 */
	public String doAccessHTTPGet(String sendUrl, String backEncodType)
	{
		StringBuffer receive = new StringBuffer();
		BufferedReader in = null;
		try
		{
			if (backEncodType == null || backEncodType.equals(""))
			{
				backEncodType = "UTF-8";
			}
			URL url = new URL(sendUrl);
			HttpURLConnection URLConn = (HttpURLConnection) url.openConnection();

			URLConn.setDoInput(true);
			URLConn.setDoOutput(true);
			URLConn.connect();
			URLConn.getOutputStream().flush();
			in = new BufferedReader(new InputStreamReader(URLConn.getInputStream(), backEncodType));

			String line;
			while ((line = in.readLine()) != null)
			{
				receive.append(line).append("\r\n");
			}

		} catch (IOException e)
		{
			receive.append("访问产生了异常-->").append(e.getMessage());
			e.printStackTrace();
		} finally
		{
			if (in != null)
			{
				try
				{
					in.close();
				} catch (java.io.IOException ex)
				{
					ex.printStackTrace();
				}
				in = null;

			}
		}

		log.info("短信发送返回：" + receive.toString());
		return receive.toString();
	}
}
