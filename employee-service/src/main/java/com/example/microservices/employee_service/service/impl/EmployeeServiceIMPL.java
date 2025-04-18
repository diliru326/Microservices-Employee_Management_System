package com.example.microservices.employee_service.service.impl;

import com.example.microservices.employee_service.dto.ApiResponseDTO;
import com.example.microservices.employee_service.dto.DepartmentDTO;
import com.example.microservices.employee_service.dto.EmployeeDTO;
import com.example.microservices.employee_service.dto.OrganizationDTO;
import com.example.microservices.employee_service.entity.Employee;
import com.example.microservices.employee_service.repository.EmployeeRepository;
import com.example.microservices.employee_service.service.APIClient;
import com.example.microservices.employee_service.service.EmployeeService;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import reactor.core.publisher.Mono;



@Service
public class EmployeeServiceIMPL implements EmployeeService {

    private static  final Logger logger = LoggerFactory.getLogger(EmployeeServiceIMPL.class);
    // here using the constructor injection. if you want you can use @Autowired
    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private APIClient apiClient;

//    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;



    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstname(),
                employeeDTO.getLastname(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode(),
                employeeDTO.getOrganizationCode()
        );
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO employeeDTO2 = new EmployeeDTO(
                savedEmployee.getId(),
                savedEmployee.getFirstname(),
                savedEmployee.getLastname(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode(),
                savedEmployee.getOrganizationCode()

        );
        return employeeDTO2;
    }

    //below comment out each annotaion one by one and run to see what happens with other annotaion

    @Override
    //@CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    public ApiResponseDTO getEmployeeById(Long id) {
        logger.info("inside getEmployeeById method");
        Employee employee = employeeRepository.findById(id).get();

        // Communication with Rest Template

//        ResponseEntity<DepartmentDTO> responseEntity= restTemplate
//                .getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDTO.class);
//
//        DepartmentDTO departmentDTO = responseEntity.getBody();


        // Communication with WebClient

        DepartmentDTO departmentDTO = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();        // when use .block() this will turn in to a synchronus communication. if not asynchronus


        OrganizationDTO organizationDTO = webClient.get()
                .uri("http://localhost:8083/api/v1/organization/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDTO.class)
                .block();


//        DepartmentDTO departmentDTO = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDTO employeeDTO2 = new EmployeeDTO(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        );

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO2);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        apiResponseDTO.setOrganizationDTO(organizationDTO);

        return apiResponseDTO;
    }

    //below is the method that will call if the department service is down.
    //you can see there are some default department details we have manually set.

    public ApiResponseDTO getDefaultDepartment(Long id, Exception exception) {
        logger.info("inside getDefaultDepartment method");
        Employee employee = employeeRepository.findById(id).get();

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentName("Default Department");
        departmentDTO.setDepartmentDescription("Development Department");
        departmentDTO.setDepartmentCode("D001");

        EmployeeDTO employeeDTO2 = new EmployeeDTO(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        );

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO2);
        apiResponseDTO.setDepartmentDTO(departmentDTO);

        return apiResponseDTO;
    }
}
