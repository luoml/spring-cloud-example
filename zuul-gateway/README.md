# zuul-gateway
演示api gateway，通过Zuul实现。  

| method | url | desc |  
| :--- | :--- | :--- |   
| GET | http://localhost:8080/service/hello/feign-demo | 路由至feign-demo服务 |  
| GET | http://localhost:8080/api/hello?name=eureka-client | 路由至eureka-client服务 |  


## 启用Zuul  
* 引入Maven依赖  

_Zuul starter并没有包含服务发现的客户端，所以还需要引入服务发现依赖_

``` maven
<!-- eureka -->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>

<!-- zuul -->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-zuul</artifactId>
</dependency>
```

* 配置路由  

``` yml
# 移除前缀    http://localhost:8080/service/hello/xxx ==> http://feign-demo/hello/xxx
# 不移除前缀 http://localhost:8080/api/hello?name=xxx  ==> http://eureka-client/api/hello?name=xxx
zuul:
  routes:
    feign-demo:                 # 名称自定义 
      path: /service/**         # 访问前缀
      serviceId: feign-demo     # 服务名
    eureka-client: 
      path: /api/**
      serviceId: eureka-client
      stripPrefix: false        # 不移除前缀，默认为true

# 设置Hystrix的全局超时时间，默认为60s
hystrix:
  command:
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 60000
```

* 启用Zuul  

``` java
@EnableZuulProxy
```
