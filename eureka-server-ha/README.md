# eureka-server-ha
演示 Eureka Server 双节点集群  

| method | url | desc |  
| :--- |:---|:---|   
| GET | http://peer1:8761 | 服务注册中心 peer1 |  
| GET | http://peer2:8762 | 服务注册中心 peer2 |  


## 启用Eureka Server  
* 引入Maven依赖  

``` maven
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
```

* 配置Eureka Server集群    

配置系统hosts文件，Windows系统hosts文件路径：C:\Windows\System32\drivers\etc\hosts  
```
127.0.0.1 peer1 peer2 localhost
```

``` yml
---
spring:
  profiles: peer1
server:
  port: 8761
eureka:
  instance:
    hostname: peer1
  client:
    registerWithEureka: true   # 是否将自己注册到服务中心，默认为true
    fetchRegistry: true        # 是否从服务中心获取注册信息，默认为true
    serviceUrl:
      defaultZone: http://peer2:8762/eureka/ # 将自己注册到peer2这个服务中心上去

---
spring:
  profiles: peer2
server:
  port: 8762
eureka:
  instance:
    hostname: peer2
  client:
    registerWithEureka: true
    fetchRegistry: true
    serviceUrl:
      defaultZone: http://peer1:8761/eureka/
```

* 启用Eureka Server  

``` java
@EnableEurekaServer
```

分别以 `--spring.profiles.active=peer1` 和  `--spring.profiles.active=peer2` 的方式启动两个 Eureka Server 节点。
