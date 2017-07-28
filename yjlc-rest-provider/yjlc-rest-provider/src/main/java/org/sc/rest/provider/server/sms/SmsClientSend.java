package org.sc.rest.provider.server.sms;

import java.net.URLEncoder;

import org.sc.rest.provider.server.config.SmsProperties;
import org.springframework.beans.factory.annotation.Autowired;

import com.yjlc.commons.log.LogUtil;

public class SmsClientSend
{

	
	private static LogUtil log = LogUtil.getInstance(SmsClientSend.class);

	public String sendSms(SmsProperties smsConfig, String mobile, String content)
	{
		return sendSms(smsConfig,mobile, content, null, null, null, null, null, null, null, "POST", "UTF-8", "UTF-8");
	}

	private String sendSms(SmsProperties smsConfig,String mobile, String content, String action, String sendTime, String checkContent, String taskName, String countNumber, String mobileNumber, String telephoneNumber, String sendType, String codingType, String backEncodType)
	{
		if ("false".equals(smsConfig.getOpen()))
		{
			return null;
		}
		try
		{
			if ((codingType == null) || (codingType.equals("")))
			{
				codingType = "UTF-8";
			}
			if ((backEncodType == null) || (backEncodType.equals("")))
			{
				backEncodType = "UTF-8";
			}
			StringBuffer send = new StringBuffer();
			if ((action != null) && (!action.equals("")))
			{
				send.append("action=").append(action);
			} else
			{
				send.append("action=send");
			}
			send.append("&userid=").append(smsConfig.getUserid());
			send.append("&account=").append(URLEncoder.encode(smsConfig.getAccount(), codingType));
			send.append("&password=").append(URLEncoder.encode(smsConfig.getPassword(), codingType));
			send.append("&mobile=").append(mobile);
			send.append("&content=").append(URLEncoder.encode(content, codingType));
			if ((sendTime != null) && (!sendTime.equals("")))
			{
				send.append("&sendTime=").append(URLEncoder.encode(sendTime, codingType));
			}
			if ((checkContent != null) && (!checkContent.equals("")))
			{
				send.append("&checkContent=").append(checkContent);
			}
			if ((taskName != null) && (!taskName.equals("")))
			{
				send.append("&taskName=").append(URLEncoder.encode(taskName, codingType));
			}
			if ((countNumber != null) && (!countNumber.equals("")))
			{
				send.append("&countNumber=").append(countNumber);
			}
			if ((mobileNumber != null) && (!mobileNumber.equals("")))
			{
				send.append("&mobileNumber=").append(mobileNumber);
			}
			if ((telephoneNumber != null) && (!telephoneNumber.equals("")))
			{
				send.append("&telephoneNumber=").append(telephoneNumber);
			}
			if ((sendType != null) && (sendType.toLowerCase().equals("get")))
			{
				return SmsClientAccessTool.getInstance().doAccessHTTPGet(smsConfig.getUrl() + "?" + send.toString(), backEncodType);
			}
			log.info("发送短信内容：" + content + ";接收信息的手机号为：" + mobile);
			return SmsClientAccessTool.getInstance().doAccessHTTPPost(smsConfig.getUrl(), send.toString(), backEncodType);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return "error";
	}
}
