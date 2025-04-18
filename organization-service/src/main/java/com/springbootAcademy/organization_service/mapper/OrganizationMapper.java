package com.springbootAcademy.organization_service.mapper;

import com.springbootAcademy.organization_service.dto.OrganizationDTO;
import com.springbootAcademy.organization_service.entity.Organization;
import org.springframework.stereotype.Component;

// we dont need to use @Component to access this class from a different. Because this is a static method
//we can access this class from a different class without creating an object of this class there.
public class OrganizationMapper {

    public static OrganizationDTO mapToOrganizationDTO(Organization organization) {
        OrganizationDTO organizationDTO = new OrganizationDTO(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()
        );
        return organizationDTO;
    }

    public static Organization mapToOrganization(OrganizationDTO organizationDTO) {
        Organization organization = new Organization(
                organizationDTO.getId(),
                organizationDTO.getOrganizationName(),
                organizationDTO.getOrganizationDescription(),
                organizationDTO.getOrganizationCode(),
                organizationDTO.getCreatedDate()
        );
        return organization;
    }
}
