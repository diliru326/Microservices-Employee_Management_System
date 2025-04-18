package com.example.microsServices.department_service.service.IMPL;

import com.example.microsServices.department_service.dto.DepartmentDto;
import com.example.microsServices.department_service.entity.Department;
import com.example.microsServices.department_service.repository.DepartmentRespository;
import com.example.microsServices.department_service.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceIMPL implements DepartmentService {

    private DepartmentRespository departmentRespository;

    public DepartmentServiceIMPL(DepartmentRespository departmentRespository) {
        this.departmentRespository = departmentRespository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        departmentRespository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
       Department department = departmentRespository.findByDepartmentCode(code);
       DepartmentDto departmentDto = new DepartmentDto(
               department.getId(),
               department.getDepartmentName(),
               department.getDepartmentDescription(),
               department.getDepartmentCode()
       );
        return departmentDto;
    }
}
