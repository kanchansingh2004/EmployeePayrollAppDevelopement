package com.bridgelabz.employeepayrollapp.employeedto;
//UC-01 Lombok Library to auto generate getters and setters for the DTO
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
//UC-02 Employee payroll application using DTO
public class EmployeeDTO {
    //UC-01 Add Validation to Name Field
    //providing regular expression for username
    //UC-02 provide user-friendly error response in case validation fails
    @NotBlank(message = "Name cannot be empty!")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and be at least 3 characters long")
    //Instance variable
    private String name;
    private String department;
    private String salary;
}
