# zuul-api-gateway
<http://localhost:8080/demo/hello>  
<http://localhost:8080/demo2/hello>

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
    <artifactId>spring-cloud-starter-zuul</artifactId>
</dependency>
```

* ZuulApiGatewayApplication.java
`@EnableZuulProxy`

* bootstrap.yml

``` yml
spring:
  application:
    name: zuul-api-gateway
  cloud:
    config:
      uri: ${config.server.uri:http://localhost:8888}

server:
  port: 8080

logging:
  level:
    ROOT: INFO
    org.springframework.web: INFO
```

* application.properties

``` properties
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/

zuul.routes.demo.path = /demo/**
zuul.routes.demo.serviceId = eureka-client-feign

zuul.routes.demo2.path = /demo2/**
zuul.routes.demo2.url = http://localhost:8181/
``` 