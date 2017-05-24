package com.example.eureka.client.feign.service.demo;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.example.eureka.client.feign.config.FeignConfiguration;

@FeignClient(value = "eureka-client", configuration=FeignConfiguration.class, fallback = DemoServiceFeignClientFallback.class)
public interface DemoServiceFeignClient extends DemoService {
	
}
