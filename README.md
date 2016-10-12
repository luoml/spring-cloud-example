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
      
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false   #不注册自己
    fetchRegistry: false        #不从注册中心取信息

server:
  port: 8761
```