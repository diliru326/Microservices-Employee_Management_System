package com.example.microservices.employee_service.dto;

public class ApiResponseDTO {

    private EmployeeDTO employeeDTO;
    private DepartmentDTO departmentDTO;
    private OrganizationDTO organizationDTO;

    public ApiResponseDTO() {
    }

    public ApiResponseDTO(EmployeeDTO employeeDTO, DepartmentDTO departmentDTO , OrganizationDTO organizationDTO) {
        this.employeeDTO = employeeDTO;
        this.departmentDTO = departmentDTO;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

    public OrganizationDTO getOrganizationDTO() { return organizationDTO; }

    public void setOrganizationDTO(OrganizationDTO organizationDTO) { this.organizationDTO = organizationDTO; }

}
