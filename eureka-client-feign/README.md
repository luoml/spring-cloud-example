# eureka-client-feign
<http://localhost:8181/hello>

* pom.xml

``` maven
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-feign</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
```

* EurekaClientFeignApplication.java
``` java
@EnableFeignClients
@EnableDiscoveryClient
```

* bootstrap.yml

``` yml
spring:
  application:
    name: eureka-client-feign
  profiles:
    active: dev
  cloud:
    config:
      uri: ${config.server.uri:http://localhost:8888}   

server:
  port: 8011

eureka:
  instance:
    leaseRenewalIntervalInSeconds: 1
    leaseExpirationDurationInSeconds: 2
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
    healthcheck:
      enabled: true
```