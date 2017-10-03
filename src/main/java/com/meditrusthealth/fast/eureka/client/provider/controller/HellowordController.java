/**
 *  www.meditrusthealth.cn Copyright © MediTrust Health 2017
 */
package com.meditrusthealth.fast.eureka.client.provider.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * </p>
 *
 * @author xiaoyu.wang
 * @date 2017年10月3日 下午3:40:18
 * @version
 */
@RestController
@RequestMapping(value = "/provider")
public class HellowordController {

	private static final Logger LOG = LoggerFactory.getLogger(HellowordController.class);

	@Autowired
	private Registration registration; // 服务注册

	@Autowired
	private DiscoveryClient discoveryClient; // 服务发现客户端

	@GetMapping(value = "/hello")
	public String hello() {
		ServiceInstance instance = serviceInstance();
		LOG.info("provider service, host = " + instance.getHost() + ", service_id = " + instance.getServiceId());
		return "Provider Helloword";
	}

	public ServiceInstance serviceInstance() {
		List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
		LOG.info("list.size:{}", list.size());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
