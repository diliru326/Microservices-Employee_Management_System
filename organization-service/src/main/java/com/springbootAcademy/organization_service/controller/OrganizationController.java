package com.springbootAcademy.organization_service.controller;

import com.springbootAcademy.organization_service.dto.OrganizationDTO;
import com.springbootAcademy.organization_service.entity.Organization;
import com.springbootAcademy.organization_service.repository.OrganizationRepository;
import com.springbootAcademy.organization_service.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/save")
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO){
        OrganizationDTO organizationDTO1 = organizationService.saveOrganization(organizationDTO);
        return new ResponseEntity<>(organizationDTO1, HttpStatus.CREATED);

    }
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable("code")String organizationCode ){
    OrganizationDTO organizationDTO = organizationService.getOrganizationByCode(organizationCode);
    return new ResponseEntity<>(organizationDTO, HttpStatus.OK);
    }
}
