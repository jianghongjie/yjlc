package org.sc.rest.provider.service.impl;

import java.util.List;
import java.util.Map;

import org.sc.rest.provider.mapper.UserMapper;
import org.sc.rest.provider.model.SendCodeModel;
import org.sc.rest.provider.model.User;
import org.sc.rest.provider.server.base.PageBean;
import org.sc.rest.provider.server.config.SmsProperties;
import org.sc.rest.provider.server.jedis.JedisWrap;
import org.sc.rest.provider.server.sms.SmsClientSend;
import org.sc.rest.provider.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.yjlc.commons.exception.ServiceException;

@Service
public class UserServiceImpl implements UserService {
	
	final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	JedisWrap jedisWrap;
	
	@Autowired
	SmsProperties smsProperties;
	
	
	@Override
	public User getId(int id) {
		User resultTest = userMapper.selectByPrimaryKey(id);
		return resultTest;
	}
	@Override
	@Transactional
	public int inser(User user) {
		jedisWrap.setObject("jhj", user);
		return userMapper.insert(user);
	}
	@Override
	public User get(User user) {
		// TODO Auto-generated method stub
		if(user==null){
			throw new ServiceException("对象为空，不予处理");
		}
		User users = new User();
		users.setAge("20");
		users.setId(1);
		users.setName("Spring Cloud");
//		return userMapper.selectByPrimaryKey(user.getId());
		return users;
	}
	@Override
	public PageBean<User> getPage(User user) {
	    PageHelper.startPage(user.getPageNum(), user.getPageSize());
		List<User> list = userMapper.selectAll();
		return new PageBean<User>(list);
    }
	@Override
	public PageBean<Map<String,Object>> getListByPage(User user) {
	    PageHelper.startPage(user.getPageNum(), user.getPageSize());
		List<Map<String,Object>> list = userMapper.getListByPage();
		return new PageBean<Map<String,Object>>(list);
	}
	@Override
	public boolean sendSmsCode(SendCodeModel sendCodeModel) {
		LOGGER.info("<==============开始发送验证码==============>");
		boolean flag = true;
		// 封装参数
		try {
			LOGGER.info(jedisWrap.get("18157176175"));
			//new SmsClientSend().sendSms(smsProperties,sendCodeModel.getCusMobile(), "新版短信测试");
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
}
