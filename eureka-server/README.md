# eureka-server
演示Eureka服务注册中心  

| method |url|desc|  
|:--- |:---|:---|   
| GET |http://localhost:8761|服务注册中心|  


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
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false   # 是否将自己注册到服务中心，默认为true
    fetchRegistry: false        # 是否从服务中心获取注册信息，默认为true
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/ # 设置与Eureka Server交互的地址，默认为http://localhost:8761，多个地址用逗号（,）分隔
```

* 启用Eureka Server  

``` java
@EnableEurekaServer
```
