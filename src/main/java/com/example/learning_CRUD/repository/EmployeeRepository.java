package com.example.learning_CRUD.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.learning_CRUD.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
