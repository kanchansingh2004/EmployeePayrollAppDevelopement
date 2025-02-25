package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Create an interface which extends the jpa Repository
public interface UserRepository extends JpaRepository<EmployeeEntity, Long> {
}
