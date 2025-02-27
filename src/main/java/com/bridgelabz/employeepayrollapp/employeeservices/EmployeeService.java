package com.bridgelabz.employeepayrollapp.employeeservices;

import com.bridgelabz.employeepayrollapp.employeedto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//UC-02 Use Lombok Library for Logging
import lombok.extern.slf4j.Slf4j;
@Slf4j
//UC-01 Services Layer in Employee Payroll App
@Service
public class EmployeeService {
    @Autowired
    private UserRepository employeeRepository;

    // Add Employee
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        log.info("Adding new employee: {}", employeeDTO);
        EmployeeEntity savedEmployee = employeeRepository.save(EmployeeEntity.builder().name(employeeDTO.getName()).department(employeeDTO.getDepartment()).salary(employeeDTO.getSalary()).build());
        log.info("Saved new employee: {}", savedEmployee.getName());

        return new EmployeeDTO(savedEmployee.getName(), savedEmployee.getDepartment(), savedEmployee.getSalary());
    }

    // Get All Employees
    public List<EmployeeDTO> getAllEmployees() {
        log.info("Fetching all employees from the database.");
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees.stream()
                .map(emp -> new EmployeeDTO(emp.getName(), emp.getDepartment(), emp.getSalary()))
                .collect(Collectors.toList());
    }

    // Get Employee By ID
    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);

        return employee.map(emp -> new EmployeeDTO(emp.getName(), emp.getDepartment(), emp.getSalary()));
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with ID: {}", id);
        employeeRepository.deleteById(id);
    }

    // Update Employee
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            EmployeeEntity emp = existingEmployee.get();
            emp.setName(employeeDTO.getName());
            emp.setDepartment(employeeDTO.getDepartment());
            emp.setSalary(employeeDTO.getSalary());
            employeeRepository.save(emp);

            return new EmployeeDTO(emp.getName(), emp.getDepartment(), emp.getSalary());
        } else {
            log.warn("Employee with ID {} not found.", id);
            return null;
        }
    }
}
