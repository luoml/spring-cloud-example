package com.example.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Eureka Client 与 Eureka Server配合，可实现服务注册与发现。
 * 通过 EnableDiscoveryClient注解 或 EnableEurekaClient注解，都可启用Eureka客户端用以注册与发现服务，
 * 区别在于：EnableEurekaClient仅可用于Eureka，而EnableDiscoveryClient却用于Eureka、Consul、Zookeeper等。
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
