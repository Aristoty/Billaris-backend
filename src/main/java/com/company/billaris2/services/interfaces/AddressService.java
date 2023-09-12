package com.company.billaris2.services.interfaces;

import com.company.billaris2.DTO.AddressDTO;
import com.company.billaris2.entities.Address;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AddressService {
    Address createAddress(AddressDTO addressDTO);

    Address getAddressById(Long addressId);

    List<Address> getAllAddresses();

    Address updateAddress(Long id, AddressDTO addressDTO);

    void deleteAddress(Long id);
}
