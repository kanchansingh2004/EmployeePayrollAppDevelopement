package com.bridgelabz.employeepayrollapp;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeepayrollappApplication {
	public static final Logger logger = LoggerFactory.getLogger(EmployeepayrollappApplication.class);
	public static void main(String[] args) {
		logger.info("Starting Application.......");
		SpringApplication.run(EmployeepayrollappApplication.class, args);
		logger.info("Application in process.......");
	}
}
