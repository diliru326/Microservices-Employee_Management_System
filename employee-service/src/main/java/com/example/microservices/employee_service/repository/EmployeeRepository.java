package com.example.microservices.employee_service.repository;

import com.example.microservices.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories(basePackageClasses = EmployeeRepository.class)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
