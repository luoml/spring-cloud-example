# rest-demo  
演示使用 Spring Data JPA + Spring Data REST 构建符合HATEOAS规范的REST应用。  
  
> 1. _采用嵌入式的H2数据库_  
> 2. _使用Spring Data JPA进行数据持久化_  
> 3. _通过Spring Data Rest构建超媒体驱动（hypermedia-driven）的REST服务，利用Spring Data repositories，直接将其方法暴露为REST资源_  
> 4. _引入HAL Browser，以便于可视化测试；HAL-browser是基于hal+json的media type的API浏览器_  

| url | desc |  
| :--- | :--- |   
| http://localhost:8082/h2 | 访问h2控制台 |  
| http://localhost:8082/api | Restful API |  

## 名词释义

__REST__  
REST（Representational state transfer，表达性状态转换）是一组架构约束条件和原则，满足这些约束条件和原则的应用程序或设计就是 RESTful。  


__HATEOAS__  
HATEOAS（Hypermedia as the engine of application state）是 REST 架构风格中最复杂的约束，也是构建成熟 REST 服务的核心。  


__REST Maturity Model__
_REST成熟度模型把 REST服务按照成熟度划分成 4个层次：_
* 第一个层次（Level 0）的 Web服务只是使用 HTTP 作为传输方式，实际上只是远程方法调用（RPC）的一种具体形式。SOAP 和 XML-RPC 都属于此类。
* 第二个层次（Level 1）的 Web服务引入了资源的概念。每个资源有对应的标识符和表达。
* 第三个层次（Level 2）的 Web服务使用不同的 HTTP 方法来进行不同的操作，并且使用 HTTP 状态码来表示不同的结果。如 HTTP GET 方法来获取资源，HTTP DELETE 方法来删除资源。
* 第四个层次（Level 3）的 Web服务使用 HATEOAS。在资源的表达中包含了链接信息。客户端可以根据链接来发现可以执行的动作。  


## 配置H2数据库

* 引入Maven依赖  

``` maven
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>
```

* 配置数据源等参数  

``` properties
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:file:~/.h2/test
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

# 启用H2控制台
spring.h2.console.enabled=true
# 设置H2控制台访问路径
spring.h2.console.path=/h2
```

## 配置Spring Data JPA  

* 引入Maven依赖    

``` maven
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

* 定义实体类

``` java
@Entity
public class User {	
	@Id
	@GeneratedValue
	private Integer id;	
	private String name;
	private String address;
	
	...
}
```

* 定义仓库接口  

``` java
public interface UserRepository extends JpaRepository<User, Integer> {	
	User findByName(@Param("name") String name);	
	List<User> findByAddress(@Param("address") String address);	
}
```

## 配置Spring Data REST  

* 引入Maven依赖    

``` maven
<!-- Spring Data REST；如已引入 HAL Browser，则可以不引入此依赖 -->
<!-- 
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
-->

<!-- HAL Browser -->
<dependency>
	<groupId>org.springframework.data</groupId>
	<artifactId>spring-data-rest-hal-browser</artifactId>
</dependency>
```

* 配置REST相关参数  

```
spring.data.rest.basePath=/api   # 设置REST接口根路径，默认为/
```

_引入@RepositoryRestResource自定义Url的path名_

``` java
@RepositoryRestResource(path = "user")
```

* 配置获取主键ID

_默认情况下，接口查询是不会返回主键ID的；如果希望获取主键，可增加如下配置：_  

``` java
@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(User.class);
		config.exposeIdsFor(Department.class);
	}
}
```