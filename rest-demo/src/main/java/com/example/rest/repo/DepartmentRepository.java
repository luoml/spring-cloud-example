package com.example.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
