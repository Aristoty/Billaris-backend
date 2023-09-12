package com.company.billaris2.mappers;

import com.company.billaris2.DTO.AddressDTO;
import com.company.billaris2.entities.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDTO toDTO(Address address) {
        AddressDTO dto = new AddressDTO();
//        dto.setId(address.getId());
        dto.setCity(address.getCity());
        dto.setCountry(dto.getCountry());
        dto.setStreet(dto.getStreet());
        dto.setZipCode(dto.getZipCode());

        return dto;
    }

    public Address toEntity(AddressDTO dto) {
        Address address = new Address();
//        address.setId(dto.getId());
        address.setStreet(dto.getStreet());
        address.setZipCode(dto.getZipCode());
        address.setCity(dto.getCity());
        address.setCountry(dto.getCountry());
        return address;
    }



}
