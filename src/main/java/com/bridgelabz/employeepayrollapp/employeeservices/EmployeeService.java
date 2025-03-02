package com.bridgelabz.employeepayrollapp.employeeservices;

import com.bridgelabz.employeepayrollapp.employeedto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private UserRepository employeeRepository;

    private final ModelMapper modelMapper; // ModelMapper for DTO conversion

    // Constructor-based injection for ModelMapper
    public EmployeeService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // UC-03 Ability for the Services Layer to store the Employee Payroll Data
    // Add Employee
    public ResponseEntity<EmployeeDTO> saveEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            log.warn("Invalid Employee data received!");
            return ResponseEntity.badRequest().build(); // Handle invalid input gracefully
        }

        log.info("Adding new employee: {}", employeeDTO);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
        EmployeeDTO savedEmployee = modelMapper.map(savedEntity, EmployeeDTO.class);

        log.info("Saved new employee: {}", savedEmployee.getName());
        return ResponseEntity.ok(savedEmployee);
    }

    // Get All Employees
    public List<EmployeeDTO> getAllEmployees() {
        log.info("Fetching all employees from the database.");
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class)) // Mapping entity to DTO
                .collect(Collectors.toList());
    }

    // Get Employee By ID
    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id)
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class)); // Mapping entity to DTO
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            log.warn("Employee with ID {} not found!", id);
            return false; // Return false if the employee doesn't exist
        }

        log.info("Deleting employee with ID: {}", id);
        employeeRepository.deleteById(id);
        return true;
    }

    // Update Employee
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(employeeDTO.getName());
            emp.setDepartment(employeeDTO.getDepartment());
            emp.setSalary(employeeDTO.getSalary());
            EmployeeEntity updatedEntity = employeeRepository.save(emp);
            log.info("Employee details updated for ID: {}", id);
            return modelMapper.map(updatedEntity, EmployeeDTO.class); // Mapping entity to DTO
        }).orElse(null);
    }
}
