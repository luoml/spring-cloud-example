package com.example.eureka.client.feign.service.demo;

import org.springframework.stereotype.Component;

@Component
public class DemoServiceFeignClientFallback implements DemoServiceFeignClient {
	
	@Override
	public String hello() {
		return "hello.Fallback";
	}
}
