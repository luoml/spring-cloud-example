# Spring Boot 1.4.1.RELEASE

## eureka-server
服务注册中心  
<http://localhost:8761/>

## zuul-api-gateway
服务网关，智能路由  
<http://localhost:8080/demo/hello>  
<http://localhost:8080/demo/user-feign/1>  
<http://localhost:8080/demo2/hello>  
<http://localhost:8080/demo2/user-feign/1>

## eureka-client-feign
客户端负载均衡  
<http://localhost:8181/hello>  
FeignClient访问方式：
  返回单个对象：<http://localhost:8181/user-feign/1>  
  返回单个对象：<http://localhost:8181/user-feign/getUserByName/张三>  
  返回集合对象：<http://localhost:8181/user-feign/getUserByAddress/test>  
RestTemplate访问方式：<http://localhost:8181/user-rest/1>

## eureka-client
业务层微服务  
<http://localhost:8081/hello>

## rest-demo
数据库层微服务，采用spring data rest + h2 + the hal browser  
接口访问：<http://localhost:8088/api>  
数据库访问：<http://localhost:8088/h2-console>

## config-server
分布式配置中心  
<http://localhost:8888/config-server/default/master>

## config-repo
用于存储配置信息