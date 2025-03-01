package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.employeedto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.employeeservices.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//UC-01 Add Validation to Name Field
import jakarta.validation.Valid;


//UC-02 Use Lombok Library for Logging
import lombok.extern.slf4j.Slf4j;
@Slf4j

@RestController
@RequestMapping("/request")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //Using all required REST APIs
    //UC-03 Ability for the Services Layer to store the Employee Payroll Data
    //UC-01 Add Validation to Name Field
    //Save the employee
    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        log.info("Received request to save employee: {}", employeeDTO);
        return employeeService.addEmployee(employeeDTO);
    }

    //Get the employee
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        log.info("Fetching all employee records.");
        return employeeService.getAllEmployees();
    }

    //Get the employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmployeeDTO>> getEmployeeById(@PathVariable Long id) {
        log.info("Fetching the employee details with id {}", id);
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    //Update the employee details by ID
    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        log.info("Successfully undated the information with Name: {}",employeeDTO.getName());
        return employeeService.updateEmployee(id, employeeDTO);
    }

    //Delete the employee using ID
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        log.info("Deleting the employee with id {} : ", id);
        employeeService.deleteEmployee(id);
        log.info("Successfully deleted the employee details");
    }
}
