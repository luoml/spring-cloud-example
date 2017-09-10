# config-client  
演示配置中心客户端  

| method | url | desc |  
| :--- | :--- | :--- |   
| GET | http://localhost:8083/hello | 测试拉取config-client-dev配置信息 |  

* 引入Maven依赖  

``` maven
<!-- spring cloud config　client -->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

* 配置ConfigServer地址  

``` yml
spring:
  application:
    name: config-client  # 对应config server所获取配置文件的{application}
  cloud:
    config:
      uri: http://localhost:8888

server:
  port: 8083
```

* 获取远程服务器文件属性值  

_通过@Value("${属性名}")获取属性值，见DemoController类hello()_  

``` java
@Value("${demo.env}")
private String env;
```