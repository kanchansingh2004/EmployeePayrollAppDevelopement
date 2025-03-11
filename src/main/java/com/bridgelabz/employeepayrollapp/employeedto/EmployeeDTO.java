package com.bridgelabz.employeepayrollapp.employeedto;

// UC-01 Lombok Library to auto-generate getters and setters for the DTO
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    // UC-01 Add Validation to Name Field
    // Providing regular expression for username
    // UC-02 Provide user-friendly error response in case validation fails
    private int id;

    @NotBlank(message = "Name cannot be empty!")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}[\sA-Za-z]*$", message = "Name must start with a capital letter and be at least 3 characters long")
    private String name;

    @NotBlank(message = "Department cannot be empty!") // Ensuring department is not blank
    private String department;

    @NotBlank(message = "Salary cannot be empty!") // Ensuring salary is not blank
    @Pattern(regexp = "^[0-9]*$", message = "Only digits are considerable!")
    private String salary;

    @NotBlank(message = "Gender cannot be empty!")
    private String gender;

    @NotNull(message = "start date cannot be empty!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotBlank(message = "profile pic cannot be empty!")
    @Column(nullable = true)
    private String profile_pic;
}
