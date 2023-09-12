package com.company.billaris2.services.impl;

import com.company.billaris2.DTO.CompanyDTO;
import com.company.billaris2.entities.Address;
import com.company.billaris2.entities.Company;
import com.company.billaris2.entities.User;
import com.company.billaris2.repositories.AddressRepository;
import com.company.billaris2.repositories.CompanyRepository;
import com.company.billaris2.services.interfaces.CompanyService;
import com.company.billaris2.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;
    private final UserService userService;


    @Override
    public Company createCompany(CompanyDTO companyDTO, Principal principal) {
        Address address = addressRepository.findByStreet(companyDTO.getAddress().getStreet());
        if (address == null) {
            address = Address.builder()
                    .country(companyDTO.getAddress().getCountry())
                    .city(companyDTO.getAddress().getCity())
                    .street(companyDTO.getAddress().getStreet())
                    .zipCode(companyDTO.getAddress().getZipCode())
                    .build();

            addressRepository.save(address);
        }
        var currentUser = userService.getCurrentUser(principal);

        Company company = modelMapper.map(companyDTO, Company.class);
        company.setAddress(address);
        company.setAdminId(currentUser.getId());

        // Création d'un ensemble de références d'utilisateurs à partir des IDs
        List<User> users = new ArrayList<>();
        for (Integer userId : companyDTO.getUserIds()){
            User user = userService.getUserById(userId);
            if (user != null){
                users.add(user);
            }
        }
        company.setUsers(users);



        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Long id, CompanyDTO companyDTO) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company existingCompany = optionalCompany.get();
            modelMapper.map(companyDTO, existingCompany);
            return companyRepository.save(existingCompany);
        }
        return null;
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
