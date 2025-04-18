package com.springbootAcademy.organization_service.service.impl;

import com.springbootAcademy.organization_service.dto.OrganizationDTO;
import com.springbootAcademy.organization_service.entity.Organization;
import com.springbootAcademy.organization_service.mapper.OrganizationMapper;
import com.springbootAcademy.organization_service.repository.OrganizationRepository;
import com.springbootAcademy.organization_service.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceIMPL implements OrganizationService {

    private OrganizationRepository organizationRepository;

    public OrganizationServiceIMPL(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDTO);
        organizationRepository.save(organization);

        OrganizationDTO organizationDTO1 = OrganizationMapper.mapToOrganizationDTO(organization);
        return organizationDTO1;
    }

    @Override
    public OrganizationDTO getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        OrganizationDTO organizationDTO1 = OrganizationMapper.mapToOrganizationDTO(organization);
        return organizationDTO1;
    }
}
