package com.springbootAcademy.organization_service.service;

import com.springbootAcademy.organization_service.dto.OrganizationDTO;
import com.springbootAcademy.organization_service.entity.Organization;

public interface OrganizationService {
    OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);

    OrganizationDTO getOrganizationByCode(String organizationCode);
}
