package com.example.eureka.client.feign.service.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.eureka.client.feign.vo.User;

@Component
public class UserServiceRestClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public User getUser(int id) {
		User user = restTemplate.exchange( "http://db-rest/api/user/{id}", HttpMethod.GET, null, new ParameterizedTypeReference<User>() { }, id).getBody();
		return user; 
	}
}
