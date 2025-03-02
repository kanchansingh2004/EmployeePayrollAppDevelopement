package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.employeedto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.employeeservices.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/request") // Base URL mapping for employee-related requests
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // UC-03 Ability for the Services Layer to store the Employee Payroll Data
    // UC-01 Add Validation to Name Field
    // Save the employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Received request to save employee: {}", employeeDTO);
        return employeeService.saveEmployee(employeeDTO);
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        log.info("Fetching all employee records.");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        log.info("Fetching the employee details with id {}", id);
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Handle case where employee doesn't exist
    }

    // Update employee details by ID
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Updating employee with ID: {}", id);
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }

    // Delete employee using ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        log.info("Deleting the employee with id {}", id);
        boolean isDeleted = employeeService.deleteEmployee(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
