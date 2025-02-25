package com.bridgelabz.employeepayrollapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees") //Providing the table name
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;
    private String salary;

    // Default Constructor
    public EmployeeEntity() {
    }

    // Parameterized Constructor
    public EmployeeEntity(String name, String department, String salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
