package com.example.rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.rest.entity.User;

/**
 * Spring Data REST 默认会根据 Repository类 使用的Entity名，按照一定的规则来生成url的path名，规则：Entity名的小写，复数格式，例如cities。 
 * 除了这个面向集合类型的path名，Spring Data REST 还会生成对应单个实体的path，格式为：集合类型path名/{id}，如cities/1。
 * 
 * 如果想更改默认行为，可以通过@RepositoryRestResource注解自定义path名。
 */
@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByName(@Param("name") String name);
	
	List<User> findByAddress(@Param("address") String address);
	
}
