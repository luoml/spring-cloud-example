
__项目基于Spring Boot 1.4.1.RELEASE__

|project|desc|  
|---|---|  
|config-repo|Git远程仓库|  
|config-server|Spring Cloud Config Server，从config-repo拉取配置清单|  
|eureka-server|Eureka服务注册中心|  
|eureka-client|Eureka与Config客户端，集成Swagger2等|  
|rest-demo|数据库增删改查，涉及Eureka Client、Spring Data JPA、Spring Data REST、H2、the HAL Browser等|
|...|...|


_以下部分待整理_  
* zuul-api-gateway
Zuul服务网关，智能路由  
<http://localhost:8080/demo/hello>  
<http://localhost:8080/demo/user-feign/1>  
<http://localhost:8080/demo2/hello>  
<http://localhost:8080/demo2/user-feign/1>

* eureka-client-feign
Eureka客户端  
<http://localhost:8181/hello>  
FeignClient访问方式：  
  返回单个对象：<http://localhost:8181/user-feign/1>  
  返回单个对象：<http://localhost:8181/user-feign/getUserByName/张三>  
  返回集合对象：<http://localhost:8181/user-feign/getUserByAddress/test>  
RestTemplate访问方式：<http://localhost:8181/user-rest/1>
