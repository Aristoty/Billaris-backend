package com.company.billaris2.controllers;

import com.company.billaris2.DTO.CompanyDTO;
import com.company.billaris2.entities.Company;
import com.company.billaris2.entities.User;
import com.company.billaris2.repositories.UserRepository;
import com.company.billaris2.services.interfaces.CompanyService;
import com.company.billaris2.services.interfaces.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private  final CompanyService companyService;
    private final UserService userService;
    private final UserRepository userRepository;


    @PostMapping("/create")
    public ResponseEntity<Company> createCompany(@RequestBody CompanyDTO company, Principal principal){
        // Récupération de l'utilisateur actuellement authentifié




//        company.setAdminId(company.getUserId());
        
        Company createdCompany = companyService.createCompany(company, principal);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all-Company")
    public ResponseEntity<List<Company>> getAllCompanies(){
        List<Company> companies = companyService.getAllCompanies();
//        if (companies.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(Collections.singletonList((Company) Collections.emptyList()));
//        }
        return ResponseEntity.ok(companies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
        Company updatedCompany = companyService.updateCompany(id, companyDTO);
        if (updatedCompany != null) {
            return ResponseEntity.ok(updatedCompany);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}
