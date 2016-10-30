# config-server
项目启动后，访问地址：http://localhost:{server.port}/{spring.application.name}/{spring.active.profiles}/{trunk/branch/...}，如：<http://localhost:8888/eureka-client/dev>

* pom.xml

``` maven
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```

* ConfigServerApplication.java 
`@EnableConfigServer`

* bootstrap.yml

```yml
spring:
  application:
    name: config-server
  profiles:
    active: default    
  cloud:
    config:
      server:
        git:
          uri: https://github.com/luoml/spring-cloud-example
          searchPaths: config-repo
    
server:
  port: 8888

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```