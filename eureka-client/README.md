# eureka-client
<http://localhost:8081/hello>

* pom.xml

``` maven
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
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
    active: default    
    
server:
  port: 8081

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```