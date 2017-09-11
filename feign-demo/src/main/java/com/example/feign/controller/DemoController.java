package com.example.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.feign.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return demoService.hello(name);
	}
}
