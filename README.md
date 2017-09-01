
## Spring Cloud Example  

[![Build Status](https://travis-ci.org/luoml/spring-cloud-example.png?branch=master)](https://travis-ci.org/luoml/spring-cloud-example)

Spring Cloud相关DEMO，包含zuul\eureka\swagger2\feign\hystrix\spring cloud config\spring data rest等。  

GitHub：<https://github.com/luoml/spring-cloud-example.git>  


_项目基于Spring Boot 1.5.2.RELEASE，Spring Cloud Dalston.RELEASE，各模块简要说明如下：_  

|project|desc|  
|---|---|  
|[config-repo](config-repo/README.md)|Git远程仓库|  
|[config-server](config-server/README.md)|Spring Cloud Config Server，从config-repo拉取配置清单|  
|[eureka-server](eureka-server/README.md)|Eureka服务注册中心|  
|[eureka-client](eureka-client/README.md)|Eureka与Config客户端，集成了Swagger2等|  
|[rest-demo](rest-demo/README.md)|数据库增删改查<br>涉及Eureka Client、Spring Data JPA、Spring Data REST、H2、the HAL Browser等|  
|[feign-demo](feign-demo/README.md)|Eureka客户端，集成了Feign、Hystrix等|  
|[api-gateway](api-gateway/README.md)|Zuul服务网关|  
|[admin-server](admin-server/README.md)|监控基于Spring Boot的应用|  
|...|...|  