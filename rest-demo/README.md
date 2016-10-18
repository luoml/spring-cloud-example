# rest-demo  
<http://localhost:8088/api> 
<http://localhost:8088/h2-console>

* pom.xml

``` maven
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.data</groupId>
	<artifactId>spring-data-rest-hal-browser</artifactId>
</dependency>
```

* RestDemoApplication.java
`@SpringBootApplication`

* application.properties

``` properties
server.port=8088

spring.data.rest.basePath = /api

spring.datasource.driverClassName=org.h2.Driver
# save memory
#spring.datasource.url = jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
# save file (absolute path)
#spring.datasource.url = jdbc:h2:file:E:\\h2\\test
# save file (~ is current user dir)
spring.datasource.url=jdbc:h2:file:~/.h2/test
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

# H2 Web Console (H2ConsoleProperties)
# Enable the console.
spring.h2.console.enabled=true
# Path at which the console will be available.
spring.h2.console.path=/h2-console
# Enable trace output.
spring.h2.console.settings.trace=false
# Enable remote access.
spring.h2.console.settings.web-allow-others=false
```

* Add the following configuration can return the primary key
 
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
