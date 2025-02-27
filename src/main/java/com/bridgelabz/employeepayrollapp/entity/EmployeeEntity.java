package com.bridgelabz.employeepayrollapp.entity;
import com.bridgelabz.employeepayrollapp.employeedto.EmployeeDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private String salary;

    // Default Constructor
    public EmployeeEntity() {}

    // Constructor accepting EmployeeDTO
    public EmployeeEntity( EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.department = employeeDTO.getDepartment();
        this.salary = employeeDTO.getSalary();
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
