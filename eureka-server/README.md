# eureka-server
<http://localhost:8761/>

* pom.xml

``` maven
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

* EurekaServerApplication.java
`@EnableEurekaServer`

* bootstrap.yml

```yml
spring:
  application:
    name: eureka-server
  profiles:
    active: default 
              
server:
  port: ${PORT:8761}
  
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

logging:
#  file: logs/eureka-server.log
  level:
    org.springframework.web: INFO
```
