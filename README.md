
## Spring Cloud Example  
Spring Cloud相关DEMO，包含zuul\eureka\swagger2\feign\hystrix\spring cloud config\spring data rest等。  


GitHub：<https://github.com/luoml/spring-cloud-example.git>  
GitBook：<https://www.gitbook.com/book/luoml/spring-cloud-example/details>  
[从这里开始](https://luoml.gitbooks.io/spring-cloud-example/content/)  


_项目基于Spring Boot 1.4.1.RELEASE，各模块简要说明如下：_  

|project|desc|  
|---|---|  
|config-repo|Git远程仓库|  
|config-server|Spring Cloud Config Server，从config-repo拉取配置清单|  
|eureka-server|Eureka服务注册中心|  
|eureka-client|Eureka与Config客户端，集成了Swagger2等|  
|rest-demo|数据库增删改查<br>涉及Eureka Client、Spring Data JPA、Spring Data REST、H2、the HAL Browser等|  
|feign-demo|Eureka客户端，集成了Feign、Hystrix等|  
|api-gateway|Zuul服务网关|  
|...|...|  



