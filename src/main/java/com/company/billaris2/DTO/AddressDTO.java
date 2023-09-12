package com.company.billaris2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AddressDTO {

    private String street;
    private String zipCode;
    private String city;
    private String country;
}