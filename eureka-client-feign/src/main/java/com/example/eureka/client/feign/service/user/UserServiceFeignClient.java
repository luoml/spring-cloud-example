package com.example.eureka.client.feign.service.user;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "db-rest", fallback = UserServiceFeignClientFallback.class)
public interface UserServiceFeignClient extends UserService {

}
