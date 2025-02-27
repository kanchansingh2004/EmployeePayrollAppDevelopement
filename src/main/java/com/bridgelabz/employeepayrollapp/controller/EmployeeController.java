package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.employeeservices.EmployeeServices;
import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/request")
public class EmployeeController {
    public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    public EmployeeServices employeeServices;

    @PostMapping
    //Method to save employee details
    public EmployeeEntity setEmployees(@RequestBody EmployeeEntity employee){
        // Log that we're about to save a new employee.  Good for tracking incoming requests.
        logger.info("Received request to save employee details: {}", employee);
        EmployeeEntity savedEmployee = employeeServices.addEmployee(employee);
        // Log the saved employee details.  Helpful for verifying data integrity.
        logger.info("Successfully saved employee with ID: {}", savedEmployee.getId());
        return savedEmployee;
    }

    @GetMapping
    //Method to getAllEmployee
    public List<EmployeeEntity> getEmployee(){
        // Log that we're fetching all employees.
        logger.info("Fetching all employee records.");
        List<EmployeeEntity> employees = employeeServices.getAllEmployee();
        // Log the number of employees retrieved.
        logger.info("Retrieved {} employee records.", employees.size()); //Using template for readability
        return employees;
    }

    @GetMapping("/{id}")
    //Method to getAllEmployeeById
    public ResponseEntity<Optional<EmployeeEntity>> getEmployeeById(@PathVariable Long id){
        // Log the request to retrieve a specific employee.
        logger.info("Fetching employee with ID: {}", id);
        Optional<EmployeeEntity> employee = employeeServices.getEmployeeById(id);

        if(employee.isPresent()) {
            logger.info("Employee with ID {} found: {}", id, employee.get()); // Show the employee data.
            return ResponseEntity.ok(employee);
        } else {
            logger.warn("Employee with ID {} not found.", id); //Use warn because employee not found could be concerning
            return ResponseEntity.ok(employee);
        }

    }

    @DeleteMapping("/{id}")
    //Method to delete employee
    public void deleteEmployeeBy(@PathVariable  Long id){
        // Log the request to delete an employee.
        logger.info("Deleting employee with ID: {}", id);
        employeeServices.deleteEmployee(id);
        //Log that the deletion was successful
        logger.info("Successfully deleted employee with ID: {}", id);
    }

    @PutMapping("/{id}")
    //Method to update employee
    public EmployeeEntity updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employee){
        // Log that we're about to update an employee.
        logger.info("Updating employee with ID: {} with details: {}", id, employee);
        EmployeeEntity updatedEmployee = employeeServices.updateEmployee(id,employee);
        // Log the updated employee details.
        logger.info("Successfully updated employee with ID: {}", updatedEmployee.getId());
        return updatedEmployee;
    }
}