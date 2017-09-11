
## Spring Cloud Example  

[![Build Status](https://travis-ci.org/luoml/spring-cloud-example.png?branch=master)](https://travis-ci.org/luoml/spring-cloud-example)

Spring Cloud相关DEMO，包含zuul\eureka\swagger2\feign\hystrix\spring cloud config\spring data rest等。  

GitHub：<https://github.com/luoml/spring-cloud-example.git>  


_项目基于Spring Boot 1.5.2.RELEASE，Spring Cloud Dalston.RELEASE，各模块简要说明如下：_  

| project | desc |  
| --- | --- |  
| [config-repo](config-repo/README.md) | Git远程配置仓库 |  
| [config-server](config-server/README.md) | 配置服务器，从config-repo拉取配置清单 |  
| [eureka-server](eureka-server/README.md) | Eureka Server 注册中心 |  
| [eureka-server-ha](eureka-server-ha/README.md) | Eureka Server 双节点集群 |  
| [eureka-client](eureka-client/README.md) | Eureka客户端，依赖 eureka-server-ha |  
| [rest-demo](rest-demo/README.md) | REST服务（Spring Data REST + Spring Data JPA） |   
| [config-client](config-client/README.md) | Config客户端，依赖 config-server |  
| [swagger2-demo](swagger2-demo/README.md) | Swagger2 |  
| [feign-demo](feign-demo/README.md) | Feign，依赖 eureka-server-ha \ eureka-client |  
| [api-gateway](api-gateway/README.md) | Zuul服务网关 |  
| [admin-server](admin-server/README.md) | 监控基于Spring Boot的应用 |  
|...|...|  