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
        return "Employee added to the database";
    }

    public List<Employee> getAllEmployees() {
        List<Employee> empList = new ArrayList<>();
        employeeRepository.findAll().forEach(empList::add);
        return empList;
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee ID " + id + " not found"));
    }

    public String updateEmployeeById(long id, Employee employee) {
        Employee existEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee ID " + id + " not found"));

        if (employee.getName() != null) {
            existEmployee.setName(employee.getName());
        }
        if (employee.getSalary() != null) {
            existEmployee.setSalary(employee.getSalary());
        }
        if (employee.getCity() != null) {
            existEmployee.setCity(employee.getCity());
        }
        if (employee.getAge() != null) {
            existEmployee.setAge(employee.getAge());
        }

        employeeRepository.save(existEmployee);
        return "Employee has been updated";
    }

    public String deleteEmployeeById(long id) {
        Employee existEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee ID " + id + " not found"));

        employeeRepository.deleteById(id);
        return "Successfully deleted employee having ID " + id;
    }

    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        return "Deleted all employees";
    }
}
