package com.bridgelabz.employeepayrollapp.employeedto;
//UC-01 Lombok Library to auto generate getters and setters for the DTO
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
//UC-02 Employee payroll application using DTO
public class EmployeeDTO {
    private String name;
    private String department;
    private String salary;
}
