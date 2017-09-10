package com.example.eureka.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/api/hello")
    public String hello(@RequestParam(required=false,defaultValue="test") String name) {
        return "Hello! " + name;
    }
}
