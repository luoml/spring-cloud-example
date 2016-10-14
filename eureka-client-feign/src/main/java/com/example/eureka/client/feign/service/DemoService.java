package com.example.eureka.client.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.eureka.client.feign.service.DemoService.DemoServiceFallback;

import feign.Feign;

@FeignClient(value = "eureka-client", fallback = DemoServiceFallback.class)
public interface DemoService {
	
	@RequestMapping(value = "hello", 
			method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, 
            consumes = MediaType.APPLICATION_JSON_VALUE)
	public String hello();
	
	public class DemoServiceFallback implements DemoService {

		@Override
		public String hello() {
			return "DemoFeign.hello() fallback.";
		}		
	}
	
	@Configuration
    public class FooConfiguration {
        @Bean
        @Scope("prototype")
        public Feign.Builder feignBuilder() {
            return Feign.builder();
        }

        @Bean
        public DemoServiceFallback fb(){
            return new DemoServiceFallback();
        }

    }
}
