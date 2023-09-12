package com.company.billaris2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ClientDTO {


    private String name;
    private String email;
    private String phoneNumber;
    private AddressDTO address;
}
