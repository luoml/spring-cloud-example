# feign-demo
演示通过Feign实现接口调用。    

| method | url | desc |  
| :--- | :--- | :--- |  
| GET | http://localhost:8181/hello/test | 调用 eureka-client 服务的/api/hello?name={name} |  


## 配置FeignClient

* 引入Maven依赖  

``` maven
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-feign</artifactId>
</dependency>
```

* 定义FeignClient接口类  

``` java
@FeignClient(value = "eureka-client")
public interface DemoService {
	
	@GetMapping("/api/hello?name={name}")
	public String hello(@PathVariable("name") String name);
}
```

* 启用FeignClient  

_在Spring Boot启动类增加@EnableFeignClients注解，使其自动扫描@FeignClient_  

``` java
@EnableFeignClients
```