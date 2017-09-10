# config-server  
演示配置中心  
Spring Cloud Config Server用于管理Git或SVN等配置，当其收到来自客户端的配置获取请求后，会将远程仓库的配置clone到本地的临时目录，然后从本地读取配置并返回。  

| method | url | desc |  
| :--- || :--- | :--- |   
| GET | http://localhost:8888/{application}/{profile}[/{label}] | 配置访问地址（变量含义见config-repo说明）|  
| GET | http://localhost:8888/config-client/dev | 获取config-client服务的dev环境配置 |   

* 引入Maven依赖

``` maven
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

* 配置仓库地址

``` yml
spring:
  application:
    name: config-server 
  cloud:
    config:
      server:
        git:
          uri: ${config.repo.uri:https://github.com/luoml/spring-cloud-example}  # 配置git仓库地址，集中管理服务配置信息
          searchPaths: config-repo    # 指定扫描路径
    
server:
  port: 8888
```

* 启用ConfigServer

``` java
@EnableConfigServer
```