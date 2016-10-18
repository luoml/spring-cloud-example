package com.example.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.rest.entity.Department;

@RepositoryRestResource(path = "depart")
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
