package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EmployeeEntity, Long> {
}
