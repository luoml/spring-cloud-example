package com.example.eureka.client.feign.service.demo;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "eureka-client", fallback = DemoServiceFeignClientFallback.class)
public interface DemoServiceFeignClient extends DemoService {
	
}
