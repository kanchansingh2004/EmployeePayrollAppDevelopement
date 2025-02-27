package com.bridgelabz.employeepayrollapp.employeedto;

public class EmployeeDTO {
    String name;
    String salary;

    public EmployeeDTO() {}

    public EmployeeDTO(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
