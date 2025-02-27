package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.employeedto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.employeeservices.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        logger.info("Received request to save employee: {}", employeeDTO);
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        logger.info("Fetching all employee records.");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmployeeDTO>> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
