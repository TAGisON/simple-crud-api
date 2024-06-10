package com.example.learning_CRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.learning_CRUD.entity.Employee;
import com.example.learning_CRUD.services.EmployeeServices;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping("/employee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        String response = employeeServices.createNewEmployee(employee);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeServices.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeServices.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        String response = employeeServices.updateEmployeeById(id, employeeDetails);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        String response = employeeServices.deleteEmployeeById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/employee")
    public ResponseEntity<String> deleteAllEmployees() {
        String response = employeeServices.deleteAllEmployees();
        return ResponseEntity.ok(response);
    }
}