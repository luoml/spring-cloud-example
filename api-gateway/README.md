# api-gateway
本模块演示api gateway，通过Zuul实现。  

|url|desc|  
|:---|:---|   
|http://localhost:8080/swagger/hello|访问eureka-client服务的hello方法|  
|http://localhost:8080/rest/api/user|获取db-rest服务的User列表|  
|...|...|

## 启用Zuul  
* 引入Maven依赖  
``` maven
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-zuul</artifactId>
</dependency>
```

* 配置接口  

_serviceId指定服务名_  
_url指定服务地址_
``` properties
zuul.routes.eureka-client.path = /swagger/**
zuul.routes.eureka-client.serviceId = eureka-client

zuul.routes.rest-demo.path = /rest/**
zuul.routes.rest-demo.url = http://localhost:8082/
```

_最好还设置下Hystrix的全局超时时间，如下，设置默认超时时间为60s_  
``` yml
hystrix:
  command:
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 60000
```

* 启用Zuul  

_增加@EnableZuulProxy注解，启用Zuul_
``` java
@EnableZuulProxy
@SpringBootApplication
public class ZuulApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}
}
```
