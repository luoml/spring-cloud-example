package com.example.eureka.client.feign.service.user;

import org.springframework.stereotype.Component;

import com.example.eureka.client.feign.vo.User;

@Component
public class UserServiceFeignClientFallback implements UserServiceFeignClient {

	@Override
	public User getUser(int id) {
		return new User("getUser.Fallback", "feignClient return");
	}
	
	@Override
	public User findUserByName(String name) {
		return new User("findUserByName.Fallback", "feignClient return");
	}

	@Override
	public String findUserByAddress(String address) {
		return "fallback";
	}
}
