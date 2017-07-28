package org.sc.rest.provider.controller;

import org.sc.rest.provider.model.SendCodeModel;
import org.sc.rest.provider.model.User;
import org.sc.rest.provider.server.base.PageBean;
import org.sc.rest.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yjlc.JSONMessage;
/**
 * 描述: TODO(用一句话描述该文件做什么) 
 * 作者: Administrator
 * 公司: 深圳市巨应信息技术有限公司
 * 日期: 2017-3-29 下午9:32:01 
 * 版本号: V4.0
 */
@RestController
@RequestMapping("/sc")
public class ProviderController {
	
	@Autowired
	private UserService userService;

	/**
	 * 
	 * 描述: TODO(用一句话描述该文件做什么) 
	 * 参数: @param id
	 * 参数: @return
	 * 返回值类型: OrderModel
	 * 作者: Administrator  
	 * 日期: 2017-3-30 下午10:06:26
	 */
//	@GetMapping("/order/{id}")
//	public JSONMessage findOrderById(@PathVariable Long id) {
//		return JSONMessage.success(null,providerService.findOrderByOrderId(id));
//	}
	/**
	 * 描述: 
	 * 参数: @param order
	 * 参数: @return
	 * 返回值类型: OrderModel
	 * 作者: Administrator  
	 * 日期: 2017-4-1 下午7:37:09
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public JSONMessage findOrderById(@RequestBody User user) {
		return JSONMessage.success((userService.inser(user)));
	}

	/**
	 * 描述: 測試
	 * 参数: @param order
	 * 参数: @return
	 * 返回值类型: OrderModel
	 * 作者: Administrator  
	 * 日期: 2017-4-1 下午7:37:09
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public User get(@RequestBody User user) {
		return userService.get(user);
	}
	/**
	 * 描述:分页查询单表
	 * 参数: @param user
	 * 参数: @return
	 * 返回值类型: PageInfo<User>
	 * 作者: 扫地僧 
	 * 日期: 2017-4-4 上午11:14:13
	 */
	@RequestMapping(value = "/getPage", method = RequestMethod.POST)
    public PageBean<User> getAll(@RequestBody User user) {
        return userService.getPage(user);
    }
	/**
	 * 描述:分页查询多表联查
	 * 参数: @param user
	 * 参数: @return
	 * 返回值类型: PageInfo<User>
	 * 作者: 扫地僧 
	 * 日期: 2017-4-4 上午11:14:13
	 */
	@RequestMapping(value = "/getListByPage", method = RequestMethod.POST)
    public PageBean<User> getListByPage(@RequestBody User user) {
        return userService.getPage(user);
    }
	
	/**
	 * 描述:短信发送
	 * 参数: @param user
	 * 参数: @return
	 * 返回值类型: PageInfo<User>
	 * 作者: 扫地僧 
	 * 日期: 2017-4-4 上午11:14:13
	 */
	@RequestMapping(value = "/sendCode", method = RequestMethod.POST)
    public JSONMessage sendCode(@RequestBody SendCodeModel sendCodeModel) {
        return JSONMessage.success(userService.sendSmsCode(sendCodeModel));
    }
}
