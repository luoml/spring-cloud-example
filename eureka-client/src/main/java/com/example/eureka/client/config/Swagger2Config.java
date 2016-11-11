package com.example.eureka.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration注解　加载此类配置
 * EnableSwagger2注解　启用Swagger2
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())	//创建API基本信息
				.groupName("")	//指定分组，对应(/v2/api-docs?group=)
				.pathMapping("")	//base地址，最终会拼接Controller中的地址
				.select()		//控制要暴露的接口
				.apis(RequestHandlerSelectors.basePackage("com.example.eureka.client.controller"))	//通过指定扫描包暴露接口
				.paths(PathSelectors.any())	//设置过滤规则暴露接口
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Swagger2 测试")
				.description("")
				.version("1.0")
				.termsOfServiceUrl("")
				.license("")
				.licenseUrl("")
				.build();
	}
}
