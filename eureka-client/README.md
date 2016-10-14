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
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
    healthcheck:
      enabled: true
```