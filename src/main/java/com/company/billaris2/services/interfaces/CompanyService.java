package com.company.billaris2.services.interfaces;

import com.company.billaris2.DTO.CompanyDTO;
import com.company.billaris2.entities.Company;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;

@Component
public interface CompanyService {

    Company createCompany(CompanyDTO companyDTO, Principal principal);
    Company getCompanyById(Long id);
    List<Company> getAllCompanies();
    Company updateCompany(Long id, CompanyDTO companyDTO);
    void deleteCompany(Long id);
}
