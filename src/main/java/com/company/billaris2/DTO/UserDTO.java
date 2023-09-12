package com.company.billaris2.DTO;

import com.company.billaris2.entities.Address;
import com.company.billaris2.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDTO {


    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String about;
    private Role role;
    private Long companyId;
    private AddressDTO address;
}

