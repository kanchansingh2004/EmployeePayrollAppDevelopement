package com.bridgelabz.employeepayrollapp.employeedto;

public class EmployeeDTO {
    private String name;
    private String department;
    private String salary;

    // Constructors
    public EmployeeDTO() {}

    public EmployeeDTO(String name, String department, String salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
