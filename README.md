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
          
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false   #不注册自己
    fetchRegistry: false        #不从注册中心取信息

server:
  port: 8761
```

# eureka-client
<http://localhost:8761/>

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
  port: 8888

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```