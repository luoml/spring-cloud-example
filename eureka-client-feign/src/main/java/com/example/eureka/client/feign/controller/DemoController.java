package com.example.eureka.client.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.eureka.client.feign.service.demo.DemoServiceFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class DemoController {
	
	@Autowired
	private DemoServiceFeignClient demoServiceFeignClient;
	
	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			@HystrixProperty(name = "execution.timeout.enabled", value = "false") })
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return demoServiceFeignClient.hello();
	}
}
