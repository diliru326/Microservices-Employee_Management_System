package com.example.microservices.employee_service.dto;

import jakarta.persistence.Column;

public class EmployeeDTO {

    private long id;

    private String firstname;

    private String lastname;

    private String email;

    private String departmentCode;

    private String organizationCode;

    public EmployeeDTO() {
    }

    public EmployeeDTO(long id, String firstname, String lastname, String email, String departmentCode, String organizationCode) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.departmentCode = departmentCode;
        this.organizationCode = organizationCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getOrganizationCode() {return organizationCode;}

    public void setOrganizationCode(String organizationCode) {this.organizationCode = organizationCode;}
}
