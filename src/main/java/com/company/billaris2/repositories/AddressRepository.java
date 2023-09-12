package com.company.billaris2.repositories;

import com.company.billaris2.DTO.AddressDTO;
import com.company.billaris2.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByStreet(String street);

    boolean findByZipCode(String zipCode);
}
