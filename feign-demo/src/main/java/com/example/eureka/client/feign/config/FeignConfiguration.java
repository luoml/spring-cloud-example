package com.example.eureka.client.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignConfiguration {
	
	@Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

