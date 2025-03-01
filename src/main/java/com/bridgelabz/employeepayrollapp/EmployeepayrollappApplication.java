package com.bridgelabz.employeepayrollapp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//UC-02 Use Lombok Library for Logging
import lombok.extern.slf4j.Slf4j;
@Slf4j

@SpringBootApplication
public class EmployeepayrollappApplication {
	public static void main(String[] args) {
		log.info("Starting Application.......");
		SpringApplication.run(EmployeepayrollappApplication.class, args);
		log.info("Application in process.......");
	}
}
