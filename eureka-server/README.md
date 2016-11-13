# eureka-server
本模块用于演示Eureka Server  

|url|desc|  
|:---|:---|   
|http://localhost:8761|Eureka服务中心|  


## 启用Eureka Server  
* 引入Maven依赖  

``` maven
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
```

* 配置Eureka Server  

``` yml
# eureka.client.registerWithEureka 不注册自己到Eureka服务中心
# eureka.client.fetchRegistry 从Eureka服务中心获取注册信息
# eureka.client.serviceUrl.defaultZone 设置Eureka服务中心地址
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```

* 启用Eureka Server  

_增加@EnableEurekaServer，启用Eureka Server_  
``` java
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
```
