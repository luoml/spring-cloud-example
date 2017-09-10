package com.example.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Value("${demo.env}")
	private String env;

	@GetMapping("/hello")
    public String hello() {
        return "Hello! It's " + env;
    }
}
