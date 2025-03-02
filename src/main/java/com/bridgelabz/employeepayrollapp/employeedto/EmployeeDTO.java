package com.bridgelabz.employeepayrollapp.employeedto;

// UC-01 Lombok Library to auto-generate getters and setters for the DTO
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    // UC-01 Add Validation to Name Field
    // Providing regular expression for username
    // UC-02 Provide user-friendly error response in case validation fails
    @NotBlank(message = "Name cannot be empty!")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Name must start with a capital letter and be at least 3 characters long")
    private String name;

    @NotBlank(message = "Department cannot be empty!") // Ensuring department is not blank
    private String department;

    @NotBlank(message = "Salary cannot be empty!") // Ensuring salary is not blank
    private String salary;
}
