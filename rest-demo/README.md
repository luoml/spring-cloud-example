# rest-demo  
本模块主要演示了数据库的增删改查等操作。  
1. _采用嵌入式的H2数据库_  
2. _使用Spring Data JPA进行数据持久化_  
3. _通过Spring Data Rest将Spring Data JPA的Repository自动转换成REST服务_  
4. _同时，引入the HAL Browser，便于可视化测试_  

|url|desc|  
|:---|:---|   
|http://localhost:8082/h2|访问h2控制台|  
|http://localhost:8082/api|返回接口清单|  

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
_增加@RepositoryRestResource注解，可通过path重定义Repository访问路径_  
``` java
@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Integer> {	
	User findByName(@Param("name") String name);	
	List<User> findByAddress(@Param("address") String address);	
}
```

## 配置Spring Data REST  

* 引入Maven依赖    
``` maven
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
```

_当然，也可直接引入the HAL Browser依赖，这样，测试起来将会更方便、更直观。_  
``` maven
<dependency>
	<groupId>org.springframework.data</groupId>
	<artifactId>spring-data-rest-hal-browser</artifactId>
</dependency>
```

* 配置REST相关参数  
_也可不配置，使用默认配置_  
``` properties
spring.data.rest.basePath = /api
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
