package com.example.microsServices.department_service.repository;

import com.example.microsServices.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DepartmentRespository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
