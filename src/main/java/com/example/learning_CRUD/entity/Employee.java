package com.example.learning_CRUD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Employee name cannot be null")
    @NotBlank(message = "Employee name cannot be blank")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Employee name should contain only letters")
    private String name;

    @NotNull(message = "Salary cannot be null")
    private Double salary;

    private String city;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "age should be more than or equal to 18")
    @Max(value = 80, message = "age should be less than or equal to 80")
    private Integer age;
}