package com.bridgelabz.employeepayrollapp.entity;
import com.bridgelabz.employeepayrollapp.employeedto.EmployeeDTO;
import jakarta.persistence.*;

//UC-01 Lombok Library to auto generate getters and setters for the DTO
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor

//mark EmployeeEntity class as a database entity with table name employees
@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private String salary;
}
