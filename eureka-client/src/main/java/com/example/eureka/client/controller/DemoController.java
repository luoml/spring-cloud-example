package com.example.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@Autowired
    private DiscoveryClient client;
	
	@Value("${demo.env}")
	private String env;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        ServiceInstance localInstance = client.getLocalServiceInstance();
        return "Hello! It's " + env  + ". " + localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
    }
}
