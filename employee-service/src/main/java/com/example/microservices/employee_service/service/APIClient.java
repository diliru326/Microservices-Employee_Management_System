package com.example.microservices.employee_service.service;

import com.example.microservices.employee_service.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080" , value = "DEPARTMENT-SERVICE")
//since these services are registered in the service registry you dont need to specify a port number like above.
// just give the service id in the application.properties file.
@FeignClient(name = "department-service")
public interface APIClient {

    @GetMapping("api/departments/{department-code}")
    DepartmentDTO getDepartment(@PathVariable(value = "department-code")String departmentCode);


}
