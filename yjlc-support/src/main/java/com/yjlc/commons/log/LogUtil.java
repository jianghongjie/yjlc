package com.yjlc.commons.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Title:LogUtil
 * </p>
 * <p>
 * Description:日志工具类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * <p>
 * Company: xsolr
 * </p>
 * 
 * @author xsolr
 * @version v1.0 2014-9-28
 */

public class LogUtil
{
	/** 日志对象 */
	private Logger logger = LoggerFactory.getLogger(LogUtil.class);

	/**
	 * 得到当前实例对象
	 * 
	 * @return 当前实例对象
	 * @param objects
	 *            class
	 */

	public static LogUtil getInstance(Object... objects)
	{
		LogUtil log = new LogUtil();
		if (null != objects && objects.length > 0 && objects[0] instanceof Class)
		{
			log.logger = LoggerFactory.getLogger((Class<?>) objects[0]);
		}
		return log;
	}

	/**
	 * 打印DEBUG级别日志
	 * 
	 * @param message
	 *            日志信息
	 */

	public void debug(Object message)
	{
		logger.debug("☆☆☆【" + message + "】☆☆☆");
	}

	/**
	 * 打印ERROR级别日志
	 * 
	 * @param message
	 *            日志信息
	 */

	public void error(Object message, Object... objects)
	{
		if (null != objects && objects.length > 0 && objects[0] instanceof Throwable)
		{
			logger.error("◆◆◆【" + message + "】◆◆◆", (Throwable) objects[0]);
		} else
		{
			logger.error("◆◆◆【" + message + "】◆◆◆");
		}
	}

	/**
	 * 打印INFO级别日志
	 * 
	 * @param message
	 *            日志信息
	 */
	public void info(Object message)
	{
		logger.info("★★★【" + message + "】★★★");
	}

	/**
	 * 打印WARN级别日志
	 * 
	 * @param message
	 *            日志信息
	 */
	public void warn(Object message)
	{
		logger.warn("※※※【" + message + "】※※※");
	}

	/**
	 * 是否有DEBUG级别
	 * 
	 * @return true/false
	 */
	public boolean isDebugEnabled()
	{
		return logger.isDebugEnabled();
	}
}