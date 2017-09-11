# admin-server  
演示 [Spring Boot Admin](https://github.com/codecentric/spring-boot-admin)，管理和监控基于Spring Boot的应用。  

| url | desc |  
| :--- | :--- |   
| http://localhost:8090 | spring boot admin ui |   

## 启用Spring Boot Admin  
* 引入Maven依赖  

``` maven
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-server</artifactId>
    <version>1.5.0</version>
</dependency>
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-server-ui</artifactId>
    <version>1.5.0</version>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

* 配置 服务发现 及 actuator 等  

``` yml
eureka:
  instance:
    leaseRenewalIntervalInSeconds: 10
    leaseExpirationDurationInSeconds: 30
  client:
    serviceUrl:
      defaultZone: http://peer1:8761/eureka/,http://peer2:8762/eureka/

management:
  security:
    enabled: false  # 关闭actuator安全认证
```

* 启用 服务发现 及 Spring Boot Admin

``` java
@EnableDiscoveryClient
@EnableAdminServer
```