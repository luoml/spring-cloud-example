# eureka-client
<http://localhost:8081/hello>  
<http://localhost:8081/health>

* pom.xml

``` maven
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

* EurekaClientApplication.java
`@EnableDiscoveryClient`

* bootstrap.yml

```yml
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

增加`leaseRenewalIntervalInSeconds`和`leaseExpirationDurationInSeconds`配置，可修复以下异常
```
EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
```