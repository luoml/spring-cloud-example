package com.example.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.rest.entity.User;

@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByName(@Param("name") String name);
}
