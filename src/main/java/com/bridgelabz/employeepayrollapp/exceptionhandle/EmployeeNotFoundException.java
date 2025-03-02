package com.bridgelabz.employeepayrollapp.exceptionhandle;

//UC-03 Custom Exception for Employee Not Found
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
