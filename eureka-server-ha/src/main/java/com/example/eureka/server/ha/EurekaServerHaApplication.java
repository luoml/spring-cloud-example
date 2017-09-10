package com.example.eureka.server.ha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication //等同于@Configuration　+　@EnableAutoConfiguration和 　+　@ComponentScan
public class EurekaServerHaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerHaApplication.class, args);
	}
}
