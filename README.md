
__项目基于Spring Boot 1.4.1.RELEASE__

_各模块简要说明如下，详细介绍可进入对应模块所在目录查看。_  

|project|desc|  
|---|---|  
|config-repo|Git远程仓库|  
|config-server|Spring Cloud Config Server，从config-repo拉取配置清单|  
|eureka-server|Eureka服务注册中心|  
|eureka-client|Eureka与Config客户端，集成了Swagger2等|  
|rest-demo|数据库增删改查<br>涉及Eureka Client、Spring Data JPA、Spring Data REST、H2、the HAL Browser等|  
|zuul-api-gateway|Zuul服务网关（详细部分待梳理）|  
|eureka-client-feign|Eureka客户端，集成了Feign、Hystrix（详细部分待梳理）|  
|...|...|
