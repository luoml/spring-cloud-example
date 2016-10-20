package com.example.eureka.client.feign.service.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.eureka.client.feign.vo.User;

public interface UserService {
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    User getUser(@PathVariable("id") int id);
	
	@RequestMapping(value = "/api/user/search/findByName?name={name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	User findUserByName(@PathVariable("name") String name);
}
