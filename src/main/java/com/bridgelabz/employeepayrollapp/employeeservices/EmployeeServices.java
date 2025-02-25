package com.bridgelabz.employeepayrollapp.employeeservices;

import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServices.class);

    @Autowired
    public UserRepository userRepository;

    //Method to getAllEmployee
    public List<EmployeeEntity> getAllEmployee(){
        // Log that we are retrieving all employees
        logger.info("Fetching all employees from the database.");
        List<EmployeeEntity> employees = userRepository.findAll();
        // Log the number of employees retrieved
        logger.info("Retrieved {} employees from the database.", employees.size());
        return employees;
    }

    //Method to getAllEmployeeById
    public Optional<EmployeeEntity> getEmployeeById(Long id){
        // Log that we are retrieving a specific employee
        logger.info("Fetching employee with ID: {}", id);
        Optional<EmployeeEntity> employee = userRepository.findById(id);

        if (employee.isPresent()) {
            logger.info("Employee with ID {} found: {}", id, employee.get());
        } else {
            logger.warn("Employee with ID {} not found.", id); //Consider Warn
        }

        return employee;
    }

    //Method to add Employee
    public EmployeeEntity addEmployee(EmployeeEntity employee){
        // Log that we are adding a new employee
        logger.info("Adding new employee: {}", employee);
        EmployeeEntity savedEmployee = userRepository.save(employee);
        // Log the details of the saved employee
        logger.info("Saved new employee with ID: {}", savedEmployee.getId());
        return savedEmployee;
    }

    //Method to delete employee
    public void deleteEmployee(Long id){
        // Log that we are deleting an employee
        logger.info("Deleting employee with ID: {}", id);
        userRepository.deleteById(id);
        // Log deletion completion
        logger.info("Successfully deleted employee with ID: {}", id);
    }

    //Method to update employee
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employee){
        // Log that we are updating an employee
        logger.info("Updating employee with ID: {} with details: {}", id, employee);
        Optional<EmployeeEntity> newEmployee = userRepository.findById(id);
        if(newEmployee.isPresent()){
            EmployeeEntity existingEmployee = newEmployee.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setSalary(employee.getSalary());
            EmployeeEntity updatedEmployee = userRepository.save(existingEmployee);
            // Log the details of the updated employee
            logger.info("Employee with ID {} updated successfully.", id);
            return updatedEmployee;
        } else {
            logger.warn("Employee with ID {} not found, cannot update.", id); // Use warn as no employee found may indicate incorrect calls from controller
            return null;
        }
    }
}