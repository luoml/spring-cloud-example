# eureka-client  
演示Eureka客户端、Actuator等  

| method | url | desc |  
| :--- | :--- | :--- |   
| GET | http://localhost:8081/api/hello?name=test | 接口测试 |  
| GET | http://localhost:8099/admin/health | 返回应用程序的健康指标，Actuator提供功能之一 |   

## 启用Eureka Client  
* 引入Maven依赖  

``` maven
<!-- eureka　client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```

* 配置Eureka客户端

``` yml
# 如果服务在指定的 失效时间 内仍没有发起心跳请求，将会被剔除EurekaServer
eureka:
  instance:
    leaseRenewalIntervalInSeconds: 10     # 心跳间隔（秒），默认30s
    leaseExpirationDurationInSeconds: 30  # 失效时间，默认90s
  client:
    serviceUrl:
      defaultZone: http://peer1:8761/eureka/,http://peer2:8762/eureka/
```

* 启用服务注册与发现  

``` java
@EnableDiscoveryClient
```

## Actuator

_Actuator提供了很多生产级的特性，如：监控、度量、健康指标等信息。_  
_通过http://{ip}:{port}/{endpoint}的形式访问监控端点，可了解应用程序的运行状况。_

* 引入Maven依赖

``` maven
<!-- actuator -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<!-- security -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

* 配置Actuator

```
management:
  port: 8099        # actuator 暴露接口使用的端口
  context-path: /admin  # actuator 暴露接口的前缀
  security:
    enabled: true   # 启用基本鉴权，默认为true
endpoints:
  health:
    sensitive: true # actuator的health接口是否敏感

security:
  basic:
    enabled: true
    path: /admin      # 拦截/admin
  user:
    name: admin       # 用户名
    password: 123456  # 密码

# 自定义 info 端点
info: 
  app: 
    name: eureka-client
```


## Devtools

_devtools能够实现代码的热部署，可在开发测试阶段启用；如下，只需引入Maven依赖_

``` maven
<!-- 热部署 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
</dependency>
```