# eureka-client  
本模块用于演示Eureka Client、Swagger2、Config Client等  

|url|desc|  
|:---|:---|   
|http://localhost:8081/swagger-ui.html|Eureka客户端接口列表|  
|http://localhost:8081/health|返回应用程序的健康指标，Actuator提供功能之一|   

## 启用Eureka Client  
* 引入Maven依赖  

``` maven
<!-- eureka　客户端 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```

* 配置Eureka服务注册地址  

_以下是bootstrap.yml中eureka相关配置_  
``` yml
eureka:
  instance:
    leaseRenewalIntervalInSeconds: 10
    leaseExpirationDurationInSeconds: 30
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```

_注：增加leaseRenewalIntervalInSeconds和leaseExpirationDurationInSeconds配置，可修复EurekaServer界面以下警告：_  
```
EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
```

* 启用EurekaClient  

_增加@EnableDiscoveryClient，启用服务注册与发现_  
``` java
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
```

## 启用Swagger2
* 引入Maven依赖  

_本项目swagger版本采用2.5.0；_  
_在测试过程中发现，使用2.6.0版本时，当服务注册到服务中心，会出现服务名为UNKNOWN的情况_  
``` maven
<!-- swagger2 -->
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>${swagger2.version}</version>
</dependency>
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>${swagger2.version}</version>
</dependency>
```

* 配置并启用Swagger2  

_增加@EnableSwagger2注解，启用Swagger2_  
``` java
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
```


## 配置Config Client
* 引入Maven依赖  

``` maven
<!-- spring cloud config　客户端 -->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

* 配置ConfigServer地址  

_spring.application.name指定该工程的服务名_  
_spring.profiles.active读取指定环境的配置文件（如：application-dev.properties、eureka-client-dev.properties）_  
_spring.cloud.config.uri指定ConfigServer的地址_  
_server.port指定端口_  

``` yml
spring:
  application:
    name: eureka-client
  profiles:
    active: dev
  cloud:
    config:
      uri: ${config.server.uri:http://localhost:8888} 

server:
  port: 8081
```

* 获取远程服务器文件属性值  

_通过@Value("${属性名}")获取属性值，见DemoController类hello()_  
``` java
@Value("${demo.env}")
private String env;
```

## 其他
### Actuator

_Actuator提供了很多生产级的特性，如：监控、度量、健康指标等信息_
``` maven
<!-- 指标监控等 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

### Devtools

_devtools能够实现代码的热部署，可在开发测试阶段启用；如下，只需引入Maven依赖_
``` maven
<!-- 热部署 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
</dependency>
```