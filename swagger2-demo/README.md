# swagger2-demo  
演示Swagger2  
[Swagger](http://swagger.io) 是一种和语言无关的规范和框架，用于定义服务接口，主要用于描述RESTful API  

| url | desc |  
| :--- | :--- |   
| http://localhost:8084/swagger-ui.html | Swagger2 API |  


## 启用Swagger2
* 引入Maven依赖  

``` maven
<!-- swagger2 -->
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.5.0</version>
</dependency>
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.5.0</version>
</dependency>
```

* 配置并启用Swagger2  

_增加 Swagger2 配置类_  

``` java
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())	//创建API基本信息
				.groupName("")	//指定分组，对应(/v2/api-docs?group=)
				.pathMapping("")	//base地址，最终会拼接Controller中的地址
				.select()		//控制要暴露的接口
				.apis(RequestHandlerSelectors.basePackage("com.example.swagger2.controller"))	//通过指定扫描包暴露接口
				.paths(PathSelectors.any())	//设置过滤规则暴露接口
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Title")
				.description("Description")
				.version("Version")
				.termsOfServiceUrl("Terms Of Service Url")
				.license("License")
				.licenseUrl("License Url")
				.build();
	}
}
```

Swagger具体用法可参考 DemoController