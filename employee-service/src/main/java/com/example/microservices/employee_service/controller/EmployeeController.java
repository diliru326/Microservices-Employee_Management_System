package com.example.microservices.employee_service.controller;

import com.example.microservices.employee_service.dto.ApiResponseDTO;
import com.example.microservices.employee_service.dto.EmployeeDTO;
import com.example.microservices.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
    EmployeeDTO savedEmployee =employeeService.saveEmployee(employeeDTO);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDTO> getEmployee(@PathVariable(value = "id") Long id) {
        ApiResponseDTO apiResponseDTO = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }

}
