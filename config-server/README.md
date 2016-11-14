# config-server  
本模块主要演示Spring Cloud Config Server。  
ConfigServer用于管理Git或SVN配置，当其收到来自客户端的配置获取请求后，会将远程仓库的配置clone到本地的临时目录，然后从本地读取配置并返回。  

|url|desc|  
|:---|:---|   
|http://localhost:8888/{application}/{profile}[/{label}]|配置访问地址（变量含义见config-repo说明）|  
|http://localhost:8888/eureka-client/dev|获取eureka-client服务的dev环境配置|   

* 引入Maven依赖

``` maven
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

* 配置仓库地址

_spring.cloud.config.server.git.uri配置git仓库地址，集中管理服务配置信息_  
_searchPaths指定扫描路径_
``` yml
spring:
  application:
    name: config-server 
  cloud:
    config:
      server:
        git:
          uri: ${config.repo.uri:https://github.com/luoml/spring-cloud-example}
          searchPaths: config-repo
    
server:
  port: 8888
```

* 启用ConfigServer

_增加@EnableConfigServer，启用Config Server_  
``` java
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
```

## 运行截图
* eureka-client dev配置  
![Spring Data REST](../images/config-server/dev.jpg)    

* eureka-client 默认配置  
![the HAL Browser](../images/config-server/default.jpg)  
