package org.sc.rest.consumer.controller;

import org.sc.rest.consumer.config.RibbonConfiguration;
import org.sc.rest.consumer.constants.ProvideUrl;
import org.sc.rest.consumer.model.SendCodeModel;
import org.sc.rest.consumer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yjlc.JSONMessage;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sc")
@RibbonClient(name = "yjlc-provider", configuration = RibbonConfiguration.class)//name是provider的服务名
public class ConsumerController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RestTemplate restTemplate;

	// 从属性文件中读取服务提供的URL
	@Value("${provide.url}")
	private String provideUrl;
	
	
	@Autowired  
    private LoadBalancerClient loadBalancerClient; 
	
//	@Autowired
//	private DiscoveryClient discoveryClient;

	// discoveryClient获取服务列表中，应用名为sc-eureka-first-provider一个服务注册信息
	//实例化eureka服务消费端，查询Eureka Server中的服务实例列表
//	public String serviceUrl() {
//		List<ServiceInstance> list = discoveryClient
//				.getInstances("sc-eureka-first-provider");
//		if (list != null && list.size() > 0) {
//			return String.valueOf(list.get(0).getUri());
//		}
//		return null;
//	}
	
	
	
	/**
	 * 描述: 保存
	 * 参数: @param user
	 * 参数: @return
	 * 返回值类型: JSONMessage
	 * 作者: 扫地僧 
	 * 日期: 2017-4-2 下午10:04:32
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public JSONMessage insert(@RequestBody User user) {
		return JSONMessage.success(this.restTemplate.postForObject(this.provideUrl + ProvideUrl.SC_INSERT, user, Object.class));
	}
	/**
	 * 描述: 根据ID获取
	 * 参数: @param user
	 * 参数: @return
	 * 返回值类型: JSONMessage
	 * 作者: 扫地僧 
	 * 日期: 2017-4-2 下午10:04:19
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ApiOperation(value="查询用户", notes="根据User对象查询用户")
	public JSONMessage get(@RequestBody User user) {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("springboot-h2");  
		logger.info("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"  
                + serviceInstance.getPort());// 打印当前调用服务的信息  
		logger.info("服务提供者端口："+this.provideUrl);
		return JSONMessage.success("OK", this.restTemplate.postForObject(this.provideUrl + ProvideUrl.SR_GET, user, Object.class));
	}
	
	/**
	 * 描述: 分页查询
	 * 参数: @param user
	 * 参数: @return
	 * 返回值类型: JSONMessage
	 * 作者: 扫地僧 
	 * 日期: 2017-4-2 下午10:04:19
	 */
	@RequestMapping(value = "/getPage", method = RequestMethod.POST)
    public JSONMessage getAll(@RequestBody User user) {
        return JSONMessage.success("OK", this.restTemplate.postForObject(this.provideUrl  + ProvideUrl.SC_GETPAGE, user, Object.class));
    }
	
	/**
	 * 描述: 分页查询
	 * 参数: @param user
	 * 参数: @return
	 * 返回值类型: JSONMessage
	 * 作者: 扫地僧 
	 * 日期: 2017-4-2 下午10:04:19
	 */
	@RequestMapping(value = "/getListByPage", method = RequestMethod.POST)
    public JSONMessage getListByPage(@RequestBody User user) {
        return JSONMessage.success("OK", this.restTemplate.postForObject(this.provideUrl  + ProvideUrl.SC_GETPAGE, user, Object.class));
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
		this.loadBalancerClient.choose("yjlc");//随机访问策略
		return JSONMessage.success("OK", this.restTemplate.postForObject("http://yjlc/"  + ProvideUrl.SC_SEND_SMS, sendCodeModel, Object.class));
    }
}
