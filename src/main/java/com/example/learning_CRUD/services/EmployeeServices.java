package com.example.learning_CRUD.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learning_CRUD.entity.Employee;
import com.example.learning_CRUD.exceptions.EmployeeNotFoundException;
import com.example.learning_CRUD.repository.EmployeeRepository;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String createNewEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee added to the database, HTTP Response 200 OK";
    }

    public List<Employee> getAllEmployees() {
        List<Employee> empList = new ArrayList<>();
        employeeRepository.findAll().forEach(empList::add);
        return empList;
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee ID " + id + " not found, HTTP Response 404 Not Found"));
    }

    public String updateEmployeeById(long id, Employee employee) {
        Employee existEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee ID " + id + " not found, HTTP Response 404 Not Found "));

        if (employee.getName() != null) {
            existEmployee.setName(employee.getName());
        }
        if (employee.getCity() != null) {
            existEmployee.setCity(employee.getCity());
        }
        if (employee.getAge() != null) {
            existEmployee.setAge(employee.getAge());
        }

        employeeRepository.save(existEmployee);
        return "Employee has been updated, HTTP Response 200 OK";
    }

    public String deleteEmployeeById(long id) {
        Employee existEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee ID " + id + " not found, HTTP Response 404 Not Found"));

        employeeRepository.deleteById(id);
        return "Successfully deleted employee having ID " + id + ", HTTP Response 200 OK";
    }

    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        return "Deleted all employees, HTTP Response 200 OK";
    }
}
