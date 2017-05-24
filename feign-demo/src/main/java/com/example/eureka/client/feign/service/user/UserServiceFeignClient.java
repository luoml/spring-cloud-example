package com.example.eureka.client.feign.service.user;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.example.eureka.client.feign.config.FeignConfiguration;

@FeignClient(value = "db-rest", configuration=FeignConfiguration.class, fallback = UserServiceFeignClientFallback.class)
public interface UserServiceFeignClient extends UserService {

}
