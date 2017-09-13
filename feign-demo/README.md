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

## 配置Feign日志

_增加Feign配置类 (FeignConfiguration.java)，配置日志级别。 _

```
/**
 * 设置Feign日志级别 ，需要配合 logging.level.<package.FeignClientClassName>=debug 使用（必须是debug级别）
 * NONE		不记录 (DEFAULT)
 * BASIC	仅记录请求方式、URL及 响应状态码、执行时间
 * HEADERS	记录日志基本信息与请求头、响应头
 * FULL		记录请求头、响应头、正文及元数据
 */
@Bean
public Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
}
```

_在配置文件中设置  FeignClient接口类 的日志级别为 DEBUG（注意：必须为 DEBUG），格式为：logging.level.<自定义FeignClient接口全路径名>=DEBUG_

```
logging:
  level:
    com.example.feign.service.DemoService: DEBUG
```