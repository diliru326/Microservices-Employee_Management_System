package com.springbootAcademy.organization_service.repository;

import com.springbootAcademy.organization_service.dto.OrganizationDTO;
import com.springbootAcademy.organization_service.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories(basePackageClasses = OrganizationRepository.class)
public interface OrganizationRepository extends JpaRepository<Organization,Long> {

    Organization findByOrganizationCode(String organizationCode);
}
