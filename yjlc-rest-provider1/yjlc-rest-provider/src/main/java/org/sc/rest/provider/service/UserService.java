package org.sc.rest.provider.service;

import java.util.Map;

import org.sc.rest.provider.model.SendCodeModel;
import org.sc.rest.provider.model.User;
import org.sc.rest.provider.server.base.PageBean;

public interface UserService {

	public User getId(int id);
	
	public int inser(User user);
	
	public User get(User user);
	
	public PageBean<User> getPage(User user);
	/**
	 * 描述: 多表查询
	 * 参数: @param user
	 * 参数: @return
	 * 返回值类型: PageBean<User>
	 * 作者: 扫地僧 
	 * 日期: 2017-4-4 下午1:17:37
	 */
	public PageBean<Map<String,Object>> getListByPage(User user);
	
    boolean sendSmsCode(SendCodeModel sendCodeModel);
	
}
